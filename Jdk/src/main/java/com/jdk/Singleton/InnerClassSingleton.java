package com.jdk.Singleton;

/**
 * Created by a549238 on 6/25/2015.
 * <p/>
 * http://www.ibm.com/developerworks/cn/java/j-lo-Singleton/
 */
public class InnerClassSingleton {
    private InnerClassSingleton() {
        System.out.println("InnerClassSingleton create");
    }

    public static InnerClassSingleton getInstance() {
        return SingletonHolder.instance;
    }

    //use static inner class to avoid synchronized
    private static class SingletonHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }
}
