package com.jdk.classpkg.classinit.initorder;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 3/21/13
 * Time: 2:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class CalledClass {
    private static int i = go(22);

    static {
        System.out.println("This is run in  static !");
    }

    protected int j = go(11);

    public CalledClass() {
        System.out.println("This is run in  CalledClass constructor method!");
        System.out.println("i=" + i + ";j=" + j);
        j = 39;
    }

    public static int go(int x) {
        System.out.println("This is run in CalledClass.go() ;x=" + x);
        return x;
    }
}
