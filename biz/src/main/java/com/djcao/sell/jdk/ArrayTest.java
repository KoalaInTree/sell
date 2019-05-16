package com.djcao.sell.jdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Test;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/2/2
 */
public class ArrayTest {

    @Test
    public void testAsList(){
        List<Integer> integers = Arrays.asList(1, 2, 3);
    }

    @Test
    public void copyOnWriteArrayList(){
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add(1);
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.interrupt();
        System.out.println(thread.interrupted());
    }

    @Test
    public void testArrayList(){
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        arrayList.add(1);arrayList.add(2);
        arrayList1.add(2);arrayList1.add(3);
        arrayList.retainAll(arrayList1);
        System.out.println(arrayList.toString());
    }

}
