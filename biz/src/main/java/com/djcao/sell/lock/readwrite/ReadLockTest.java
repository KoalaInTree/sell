package com.djcao.sell.lock.readwrite;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/10/29
 */
public class ReadLockTest {
    public static void main(String[] args) {
        final int SHARED_SHIFT   = 16;
        final int SHARED_UNIT    = (1 << SHARED_SHIFT);
        final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;
        int i = 3;
        //int i1 = i & EXCLUSIVE_MASK;
        //int i2 = i >>> SHARED_SHIFT;
        //i = i;
        int i1 = SHARED_UNIT & EXCLUSIVE_MASK;
    }
}
