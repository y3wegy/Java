package com.jdk.classpkg.classinit.initorder;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/30/13
 * Time: 2:56 PM
 * To change this template use File | Settings | File Templates.
 */

import org.junit.Test;

/**
 * very import demo
 */
class StaiticSingleton {

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

class NoStaticSingleton {
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

public class ConstructorTest {

    @Test
    public void testStaticInit() {
        StaiticSingleton mysingleton = StaiticSingleton.GetInstence();
        System.out.println(StaiticSingleton.a);
        System.out.println(StaiticSingleton.b);
    }

    @Test
    public void testNoStaticInit() {
        NoStaticSingleton mysingleton = NoStaticSingleton.GetInstence();
        System.out.println(mysingleton.a);
        System.out.println(mysingleton.b);
    }

}
