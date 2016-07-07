package com.jdk.fieldoveride;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/11/13
 * Time: 9:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class PrivateOverride extends WithFinal {

    public String a = "child";
    //public final void f(){System.out.println("PrivateOverride.f()");}

    public static void main(String[] args) {
        PrivateOverride demo = new PrivateOverride();
        demo.f();
        demo.g();
        System.out.println(demo.a); //output:child

        WithFinal demo2 = demo;
        // demo2.f();
        demo2.g();
        System.out.println(demo2.a); //output:father
    }

    @Override
    public void g() {
        System.out.println("PrivateOverride.g()");
    }
}

class WithFinal {
    public String a = "father";

    public final void f() {
        System.out.println("WithFinal.f()");
    }

    public void g() {
        System.out.println("WithFinal.g()");
    }
}
