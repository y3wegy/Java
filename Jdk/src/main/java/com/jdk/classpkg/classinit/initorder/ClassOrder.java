package com.jdk.classpkg.classinit.initorder;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 3/21/13
 * Time: 2:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClassOrder extends CalledClass {

    private static int k = nn(1);
    private int l = nn(2);

    public ClassOrder() {
        System.out.println("This is run in  ClassOrder constructor method!");
        System.out.println("k=" + k + ";l=" + l);
    }

    public static void main(String[] args) {
        System.out.println("run in main");
        CalledClass calledClass = new ClassOrder();
        System.out.println("++++++++++++++++++++++++++++++++++");
    }

    public static int nn(int x) {
        System.out.println("This is run in ClassOrder.nn() ;x=" + x);
        return x;
    }
}
