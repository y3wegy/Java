package com.jdk.generic;

import java.lang.reflect.Array;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/20/13
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class ArrayOfGeneric<T> {
    private T[] gia;

    public ArrayOfGeneric(Class<T> type, int size) {
        gia = (T[]) Array.newInstance(type, size);
    }

    public void put(T item, int index) {
        gia[index] = item;
    }

    public T get(int index) {
        return gia[index];
    }

    public T[] rep() {
        return gia;
    }
}
