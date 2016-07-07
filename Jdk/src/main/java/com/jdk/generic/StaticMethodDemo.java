package com.jdk.generic;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/20/13
 * Time: 11:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class StaticMethodDemo<T> {
    private T t;

    public StaticMethodDemo(T t) {
        this.t = t;
    }

    /*
    static method has no access to generaic variable
     */
   /* public  static T getT()
    {
        return t;
    }*/


}
