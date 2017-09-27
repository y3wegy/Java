package com.jdk.singleton;

/**
 * Created with IntelliJ IDEA.
 * User: Rui
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
