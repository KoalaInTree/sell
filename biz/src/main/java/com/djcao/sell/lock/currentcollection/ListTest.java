package com.djcao.sell.lock.currentcollection;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/11/4
 */
public class ListTest {

    public static void testToArray(){
        ArrayList<Integer> arrayList = new ArrayList<Integer>(8);
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(3);
        arrayList.add(2);
        Integer[] integers = arrayList.toArray(new Integer[1]);
        Stream.of(integers).forEach(System.out::println);
    }

    private static void testObjectFiled(){
        class Obj{
            String str = "6";
        }
        Obj obj = new Obj();
        final Obj obj1 = obj;
        String string = "1";

        Thread thread = new Thread(() -> {
            obj.str = "9";
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(obj1.str);

    }

    private static void testChangeStr(String string){
        string = "2";
    }
    public static void main(String[] args) {
        testObjectFiled();
    }

    {}
}
