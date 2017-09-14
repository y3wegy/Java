package com.jdk.bean.classinfo.singleton;

/**
 * Created by e631876 on 9/11/2017.
 */
public class NoStaticSingleton {
    private static NoStaticSingleton noStaticSingleton = new NoStaticSingleton();
    public int a;
    public int b = 0;

    private NoStaticSingleton() {
        super();
        a++;
        b++;
    }

    public static NoStaticSingleton GetInstence() {
        return noStaticSingleton;
    }
}
