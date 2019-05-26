package com.djcao.sell.proxy.jdk7handle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/11/8
 */
public class MethodHandleTest {

    private static MethodHandle getMethodHandle(Object object,String name,boolean isStatic)
        throws NoSuchMethodException, IllegalAccessException {
        MethodType methodType = MethodType.methodType(String.class);
        MethodHandle methodHandle;
        if (isStatic){
            methodHandle = MethodHandles.lookup().findStatic(object.getClass(), name, methodType);
        }else {
            methodHandle = MethodHandles.lookup().findVirtual(object.getClass(),name,methodType).bindTo(object);
        }
        return methodHandle;
    }

    public static void main(String[] args) throws Throwable {
        String ss = "sss";
        MethodHandle toString = getMethodHandle(ss, "toString", false);
        System.out.println(toString.invoke());
    }

}
