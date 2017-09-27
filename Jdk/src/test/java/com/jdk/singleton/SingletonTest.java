package com.jdk.singleton;

import org.junit.Test;
import org.testng.Assert;

public class SingletonTest {
    @Test
    public void testSimpleSingleton() throws Exception {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        Assert.assertEquals(singleton, singleton2);
    }

    @Test
    public void testThreeSingleton() throws Exception {
        ThreeSingleton singleton1 = ThreeSingleton.getInstance();
        ThreeSingleton singleton2 = ThreeSingleton.getInstance();
        ThreeSingleton singleton3 = ThreeSingleton.getInstance();
        ThreeSingleton singleton4 = ThreeSingleton.getInstance();
        Assert.assertNotEquals(singleton1, singleton2);
        Assert.assertNotEquals(singleton1, singleton3);
        Assert.assertNotEquals(singleton2, singleton3);
        Assert.assertEquals(singleton1, singleton4);
    }

    @Test
    public void testInnerSingleton(){
        InnerClassSingleton innerClassSingleton = InnerClassSingleton.getInstance();
        InnerClassSingleton innerClassSingleton1 = InnerClassSingleton.getInstance();
        Assert.assertEquals(innerClassSingleton,innerClassSingleton1);
    }
}
