package com.djcao.sell.algorithm.datastructor;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/2/28
 */
public class Heap<T> {

    private int DEFAULT = 16;
    private Comparable[] value;
    //下一个插入点
    private int index;
    private int size;

    public Heap(Comparable[] value){
        this.value = value;
        init();
    }

    public Heap(){
        this.value = new Comparable[DEFAULT];
    }

    public Heap(int cap){
        if (cap < 0 )
            throw new ArrayIndexOutOfBoundsException();
        this.value = new Comparable[cap];
    }

    private void init(){
        if (value == null || value.length == 0) return;
        size = value.length;
        index = value.length;
        //第一个非叶子节点
        rebuild();
    }

    private void rebuild(){
        int i  = size / 2 - 1;
        for (; i >= 0; i--){
            adjust(i , size - 1);
        }
    }

    private void adjust(int parent,int lastIndex){
        int left = getLeftChild(parent);
        int right = getRightChild(parent);
        int bigger = parent;
        if (right <= lastIndex){
            bigger = value[left].compareTo(value[right]) > 0 ? left : right;
            bigger = value[bigger].compareTo(value[parent]) > 0 ? bigger : parent;
        }else if (left <= lastIndex){
            bigger = value[left].compareTo(value[bigger]) > 0 ? left : bigger;
        }
        if (bigger != parent)
            swap(bigger,parent);
    }

    private int getLeftChild(int parent){
        return parent * 2 + 1;
    }

    private int getRightChild(int parent){
        return parent * 2 + 2;
    }

    private void swap(int source,int target){
        Comparable temp = value[source];
        value[source] = value[target];
        value[target] = temp;
    }

    public void add(Comparable i){
        if (index >= size)
            resize();
        value[index++] = i;
        size++;
        rebuild();
    }

    public Comparable get(){
        if (value == null || value.length == 0)
            throw new NullPointerException();
        Comparable target = value[0];
        Comparable[] dest = new Comparable[value.length];
        System.arraycopy(value,1,dest,0,value.length-1);
        value = dest;
        return target;
    }

    public void resize(){
        int curSize = size;
        int newSize = curSize * 2;
        Comparable[] dest = new Comparable[newSize];
        System.arraycopy(value,0,dest,0,size);
        value = dest;
    }

    public static void main(String[] args) {
        Heap heap = new Heap(new Integer[]{1,1000,23,435,4565,65,767,6523,424,354,54,54,6,55,65,5,2999,-100});
        heap.add(10000);
        Comparable comparable = heap.get();
        System.out.println(comparable);
    }
}
