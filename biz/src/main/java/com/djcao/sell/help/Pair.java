package com.djcao.sell.help;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/11/8
 */
public class Pair<T,E> {
    private T first;

    private E second;

    public Pair(T first, E second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public E getSecond() {
        return second;
    }

    public void setSecond(E second) {
        this.second = second;
    }
}
