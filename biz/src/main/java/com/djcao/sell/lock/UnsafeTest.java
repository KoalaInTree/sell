package com.djcao.sell.lock;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/10/24
 */
public class UnsafeTest {
    public int state;
    public static Unsafe getUnsafe(){

        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            Unsafe unsafe = (Unsafe)theUnsafe.get(null);
            return unsafe;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        long exceptOffset = -1;
        int update = 2;
        UnsafeTest unsafeTest = new UnsafeTest();
        unsafeTest.state = 1;
        Unsafe unsafe = getUnsafe();
        exceptOffset = unsafe.objectFieldOffset(UnsafeTest.class.getField("state"));
        if (unsafe.compareAndSwapInt(unsafeTest,exceptOffset,1,update)){
            System.out.println("stateOffset -->"+exceptOffset);
            System.out.println("state -->"+unsafeTest.state);
            System.out.println("update -->"+update);
        }
        Field state = UnsafeTest.class.getField("state");
        state.setAccessible(true);
        Object o = state.get(unsafeTest);
        System.out.println(o);

    }
}
