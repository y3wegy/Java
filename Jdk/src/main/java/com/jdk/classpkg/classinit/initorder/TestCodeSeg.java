package com.jdk.classpkg.classinit.initorder;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 4/17/13
 * Time: 10:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestCodeSeg {
    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    public TestCodeSeg() {
        System.err.println("3"); //
    }

    public static void main(String[] args) {
        new TestCodeSeg();
        int x = 0, a = 2, b = 3, c = 4;
        x = ++a + b++ + c++;
        System.out.println(x);
    }
}