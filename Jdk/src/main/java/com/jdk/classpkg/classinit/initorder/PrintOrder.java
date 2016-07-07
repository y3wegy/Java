package com.jdk.classpkg.classinit.initorder;

/**
 * Created by a549238 on 4/14/14.
 */
public class PrintOrder {

    {
        System.out.println("!!!!!!");
    }

    public PrintOrder() {
        System.out.println("execute in contronstor");
    }

    public PrintOrder(String msg) {
        System.out.println("from method 2:" + msg);
    }

    public static void main(String[] args) {
        new PrintOrder();
    }
}
