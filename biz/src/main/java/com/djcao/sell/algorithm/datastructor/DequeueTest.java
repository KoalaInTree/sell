package com.djcao.sell.algorithm.datastructor;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/11/18
 */
public class DequeueTest<E> implements Deque<E>{
    private int[] arr;
    private int head;
    private int tail;

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public static void main(String[] args) {
        int a = 16;
        a |= a >>> 1;
        System.out.println(a);
        int[] ints = new int[10];
        for (int i = 0 ; i < ints.length; i++){
            ints[i] = i;
        }
        int[] copyInt = new int[5];
        System.arraycopy(ints,0,copyInt,0,5);
        Arrays.stream(copyInt).forEach(System.out::println);

        ArrayDeque deque = new ArrayDeque(7);
        for (int i = 0 ; i < 7 ; i++){
            deque.add(i);
        }
        deque.add(9);
        System.out.println(deque.getLast());
        int b = 0, c = 0;
        b = c++;
        System.out.println(b);
        b = c++;
        System.out.println(b);
    }

    private boolean isFull(){
        return head == tail;
    }

    @Override
    public void addFirst(E e) {

    }

    @Override
    public void addLast(E e) {

    }

    @Override
    public boolean offerFirst(E e) {
        return false;
    }

    @Override
    public boolean offerLast(E e) {
        return false;
    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }
}
