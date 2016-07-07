package com.jdk.classpkg.classinit.staticdemo;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 3/27/13
 * Time: 3:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class StaticDemo {

    public static int a = getValue(12);
    public int b = getValue(23);

    public StaticDemo() {
        System.out.println("run in Constructor");
    }

    private static int getValue(final int x) {
        System.out.println("x:" + x);
        return x;
    }

    public static void main(String[] args) {

        System.out.println("run in main");
        StaticDemo demo = new StaticDemo();
    }
}
