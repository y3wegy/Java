package com.jdk.Container.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 8/16/13
 * Time: 4:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class ListUtilsDemo {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("123");
        list1.add("asdsad");
        list1.add("fdgdfg");
        boolean flag = false;
        for (String str : list1) {
            if (flag)
                list1.remove("fdgdfg");
            flag = true;
        }

    }
}
