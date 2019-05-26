package com.djcao.sell.jdk;

import java.util.LinkedList;

import org.junit.Test;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/2/1
 */
public class LinkedListTest {

    @Test
    public void testAddFirst(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("1");
        linkedList.add("2");
        System.out.println(linkedList.remove());
        linkedList.offer("1");
        System.out.println(linkedList.poll());
        linkedList.push("1");
        System.out.println(linkedList.pop());
        System.out.println(linkedList.peek());
    }

}
