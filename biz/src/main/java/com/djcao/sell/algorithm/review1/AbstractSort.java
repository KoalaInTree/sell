package com.djcao.sell.algorithm.review1;

import java.util.Arrays;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/6
 */
public abstract class AbstractSort {

    public int[] value;

    public AbstractSort() {
        this.value = new int[]{9,2,77,33,11,44,55,2,0,-2,-999,-999};
    }

    public AbstractSort(boolean _default) {
        this.value = _default ? new int[]{9,2,77,33,11,44,55,2} : null;
    }

    public abstract AbstractSort sort();

    protected void swap(int a,int b){
        if (null == value || value.length == 0)
            throw new NullPointerException();
        if ( a < 0 || b < 0 || a >= value.length || b >= value.length)
            throw new IndexOutOfBoundsException();
        int temp = value[b];
        value[b] = value[a];
        value[a] = temp;
    }

    protected boolean isSort(boolean desc){
        if (null == value || value.length == 0)
            throw new NullPointerException();
        if(value.length == 1)
            return true;
        boolean sort = true;
        for (int i = 1; i < value.length; i++){
            sort &= desc ? value[i] <= value[i - 1] : value[i] >= value[i - 1];
        }
        return sort;
    }

    protected boolean isSort(){
        return isSort(false);
    }

    protected String printValue(){
        return Arrays.toString(value);
    }

    public int[] getValue() {
        return value;
    }

    public void setValue(int[] value) {
        this.value = value;
    }
}
