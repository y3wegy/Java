package com.jdk.bean.classinfo.singleton;

/**
 * Created by e631876 on 9/11/2017.
 */
public class StaiticSingleton {
    public static int a;
    public static int b = 0;
    private static StaiticSingleton staticSingleton = new StaiticSingleton();

    private StaiticSingleton() {
        super();
        a++;
        b++;
    }

    public static StaiticSingleton GetInstence() {
        return staticSingleton;
    }
}
