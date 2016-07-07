package com.jdk.jvm;

/**
 * Created by a549238 on 6/1/2015.
 */
public class HeapStack {

    private static int a = 10;

    public static void main(String[] args) {
        HeapStack demo = new HeapStack();
        demo.add(10);
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 10000000; i++)
            a *= i;
        long endTime = System.currentTimeMillis();
        System.out.println("operate on static variable take time:" + (endTime - startTime) + " ms");

        int b = 10;
        startTime = System.currentTimeMillis();
        for (int i = 1; i <= 10000000; i++)
            b *= i;
        endTime = System.currentTimeMillis();
        System.out.println("operate on main  variable take time:" + (endTime - startTime) + " ms");


    }

    public void add(int value) {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 10000000; i++)
            value *= i;
        long endTime = System.currentTimeMillis();
        System.out.println("operate on method variable take time:" + (endTime - startTime) + " ms");
    }
}
