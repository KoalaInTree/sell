package com.djcao.sell.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-08-05
 */
public class TestException extends Exception {

    public TestException(String message) {
        super(message);
    }

    public static void main(String[] args) {
        /*Integer[] arr={5,3,7,1,8,2,9,4,7,2,6,6};
        List<Integer> list = Arrays.asList(arr);
        //List<Integer> collect = list.stream().sorted((a, b) -> b-a).limit(5).collect(Collectors.toList());
        list.stream().forEach(System.out::print);
        list.sort((a,b) -> a-b);
        System.out.println("");
        list.stream().forEach(System.out::print);
        list.sort((a,b) -> b-a);
        System.out.println("");
        list.stream().forEach(System.out::print);*/

        /*SubException subException= new SubException(new Exception("hi"));
        FatherException fatherException= new FatherException(subException);
        GrandPaException grandPaException= new GrandPaException(fatherException);
        grandPaException.getCause().getCause().getCause();*/
        TreeMap treeMap = new TreeMap();
        treeMap.put(10,10);
        treeMap.put(12,12);
        SortedMap sortedMap = treeMap.tailMap(11);
        sortedMap.entrySet();
        sortedMap.firstKey();
        sortedMap.values();
    }

    public void test() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    public void test2(){
        Integer.parseInt("1");
        File file = new File("123123");
    }

    public static class SubException extends Exception{
        public SubException(Throwable cause){
            super(cause);
        }
    }

    public static class FatherException extends Exception{
        public FatherException(Throwable cause){
            super(cause);
        }
    }
    public static class GrandPaException extends Exception{
        public GrandPaException(Throwable cause){
            super(cause);
        }
    }

}
