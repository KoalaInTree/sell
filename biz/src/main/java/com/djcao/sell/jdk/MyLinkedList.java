package com.djcao.sell.jdk;

import java.util.AbstractSequentialList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/2/10
 */
public class MyLinkedList<E> extends AbstractSequentialList<E>
    implements List<E>, Deque<E>, Cloneable, java.io.Serializable {

    transient int size;

    transient Node<E> first;

    transient Node<E> last;

    private static class Node<E>{
        Node<E> prev;
        Node<E> next;
        E item;

        public Node(Node<E> prev, Node<E> next, E item) {
            this.prev = prev;
            this.next = next;
            this.item = item;
        }
    }
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public void addFirst(E e) {
        linkFirst(e);
    }

    private void linkFirst(E e) {
        Node<E> f = first;
        Node<E> newNode = new Node<E>(null,f,e);
        first = newNode;
        if (f != null)
            f.prev = newNode;
        else
            last = newNode;
        size++;
    }

    @Override
    public void addLast(E e) {
        linkLast(e);
    }

    private void linkLast(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l,null,e);
        if (l != null)
            l.next = newNode;
        else
            first = newNode;
        size++;
    }

    @Override
    public boolean offerFirst(E e) {
        linkFirst(e);
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public E removeFirst() {
        Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }

    private E unlinkFirst(Node<E> f) {
        first = f.next;
        f.next = null;
        if (first == null)
            last = null;
        else
            first.prev = null;
        size--;
        return f.item;
    }

    @Override
    public E removeLast() {
        Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return unlinkLast(l);
    }

    private E unlinkLast(Node<E> l) {
        last = l.prev;
        if (last == null)
            first = null;
        else
            last.next = null;
        size--;
        return l.item;
    }

    @Override
    public E pollFirst() {
        Node<E> f = first;
        return f == null ? null : unlinkFirst(f);
    }

    @Override
    public E pollLast() {
        Node<E> l = last;
        return l == null ? null : unlinkLast(l);
    }

    @Override
    public E getFirst() {
        return first == null ? null: first.item;
    }

    @Override
    public E getLast() {
        return last == null ? null : last.item;
    }

    @Override
    public E peekFirst() {
        return getFirst();
    }

    @Override
    public E peekLast() {
        return getLast();
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
    public boolean offer(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return first == null ? null : unlinkFirst(first);
    }

    @Override
    public E element() {
        if (first == null)
            throw new NoSuchElementException();
        return getFirst();
    }

    @Override
    public E peek() {
        return getFirst();
    }

    @Override
    public void push(E e) {
        linkFirst(e);
    }

    @Override
    public E pop() {
        return last == null ? null : unlinkFirst(first);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }
}
