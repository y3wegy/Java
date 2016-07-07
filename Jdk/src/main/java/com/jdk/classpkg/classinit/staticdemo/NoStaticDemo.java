package com.jdk.classpkg.classinit.staticdemo;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/10/13
 * Time: 4:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class NoStaticDemo {
    Mug mug1;
    Mug mug2 = new Mug(2);

    {
        mug1 = new Mug(1);
        System.out.println("mug1 inited");
    }

    NoStaticDemo() {
        System.out.println("NoStaticDemo");
    }

    public NoStaticDemo(int marker) {
        System.out.println("NoStaticDemo(" + marker + ")");
    }

    public static void main(String[] args) {
        System.out.println("Run inside Main");
        new NoStaticDemo();
        System.out.println("NoStaticDemo() inited");
        new NoStaticDemo(12);
        System.out.println("NoStaticDemo(12) inited");
    }
}

class Mug {
    Mug(int maker) {
        System.out.println("mug(" + maker + ")");
    }

    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}
