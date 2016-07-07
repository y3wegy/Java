package com.jdk.generic;

import java.lang.reflect.Array;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/20/13
 * Time: 1:57 PM
 * To change this template use File | Settings | File Templates.
 */
interface Gemerator<T> {

    public T next();
}

public class BasicGenerator<T> implements Gemerator<T> {
    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    public static <T> Gemerator<T> create(Class<T> type) {
        return new BasicGenerator<T>(type);
    }

    public static void main(String[] args) {
        Gemerator<String> s = create(String.class);
        String[] as = (String[]) Array.newInstance(String.class, 3);
    }

    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
}
