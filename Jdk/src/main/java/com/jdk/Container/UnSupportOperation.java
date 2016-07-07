package com.jdk.Container;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/24/13
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class UnSupportOperation {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A B C D E F G H I J K L M N".split(" "));

        UnSupportOperation operation = new UnSupportOperation();

        operation.test("Arrays.asList()", list);

        operation.test("Modifable ", new ArrayList<String>(list));

        operation.test("Unmodifable", Collections.unmodifiableList(new ArrayList<String>(list)));
    }

    public static void print(Object msg) {
        System.out.println(msg);
    }

    private void test(String message, List<String> list) {
        print(message);
        Collection<String> collection = list;
        Collection<String> subCollection = list.subList(1, 7);

        Collection<String> collection2 = new ArrayList<String>(subCollection);


        try {
            collection.retainAll(collection2);
        } catch (UnsupportedOperationException e) {
            print("retainAll():" + e);
        }
        try {
            collection.removeAll(collection2);
        } catch (UnsupportedOperationException e) {
            print("removeAll():" + e);
        }
        try {
            collection.clear();
        } catch (UnsupportedOperationException e) {
            print("clear():" + e);
        }
        try {
            collection.add("X");
        } catch (UnsupportedOperationException e) {
            print("add():" + e);
        }
        try {
            collection.addAll(collection2);
        } catch (UnsupportedOperationException e) {
            print("addAll():" + e);
        }
        try {
            collection.remove("C");
        } catch (UnsupportedOperationException e) {
            print("remove():" + e);
        }
        try {
            list.set(0, "X");
        } catch (UnsupportedOperationException e) {
            print("set():" + e);
        }

    }
}
