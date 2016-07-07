package com.jdk.Singleton;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 3/26/13
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Singleton {
    private static Singleton instance = null;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
}
