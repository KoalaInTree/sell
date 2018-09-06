package com.djcao.sell.jvm;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-08-21
 */
public class TestClass {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(TestClass.inc());;
        ClassLoader myClassLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String className = name.substring(name.lastIndexOf(".")+1).concat(".class");
                InputStream stream = getClass().getResourceAsStream(className);
                if (stream == null){
                    super.loadClass(className);
                }
                try {
                    byte[] a = new byte[stream.available()];
                    stream.read(a);
                    return defineClass(name,a,0,a.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return super.loadClass(name);
            }
        };
        Class<?> aClass = myClassLoader.loadClass("com.djcao.sell.jvm.VMtest");
        VMtest testClass = new VMtest();
        System.out.println(testClass.getClass().equals(aClass));
    }

    private static int inc(){
        int i = 0;
        try {
            i = 1;
            return i;
        }catch (Exception e){
            i = 2;
        }finally {
            System.out.println("finally");
            i = 3;
        }
        return i;
    }
}
