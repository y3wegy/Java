package com.jdk.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/18/13
 * Time: 11:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleDemo<T extends List> {
    private T list;

    public T getList() {
        return list;
    }

    public void setList(T list) {
        this.list = list;
    }
}

class Client {
    public static void main(String[] args) {
        SimpleDemo<ArrayList<String>> demo = new SimpleDemo<ArrayList<String>>();
        ArrayList list = new ArrayList();
        list.add("213");
        demo.setList(list);

        ArrayList<String> res = demo.getList();
        for (String value : res)
            System.out.println(value);
    }
}
