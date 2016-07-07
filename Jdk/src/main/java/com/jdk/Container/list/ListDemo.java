package com.jdk.Container.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 4/1/13
 * Time: 12:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("123");
        list.add("234");
        list.add("345");
        list.add("000");
        for (String item : list)
            System.out.println(item);
        System.out.println("-----------------------------------------------");
        Collections.sort(list);   //
        for (String item : list)
            System.out.println(item);

    }
}
