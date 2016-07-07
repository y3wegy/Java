package com.jdk.Singleton;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 3/26/13
 * Time: 5:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Client {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();

    }

    @Test
    public void testSingleton() {
        ThreeSingleton instance = ThreeSingleton.getInstance();
        System.out.println(instance.toString());
        instance = ThreeSingleton.getInstance();
        System.out.println(instance.toString());
        instance = ThreeSingleton.getInstance();
        System.out.println(instance.toString());
        instance = ThreeSingleton.getInstance();
        System.out.println(instance.toString());
    }
}
