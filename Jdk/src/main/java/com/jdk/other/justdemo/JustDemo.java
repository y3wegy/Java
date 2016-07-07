package com.jdk.other.justdemo;

import org.junit.Test;

import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 3/26/13
 * Time: 12:28 PM
 * To change this template use File | Settings | File Templates.
 */

public class JustDemo {
    @Test
    public void testArray() {
        int[] a = new int[3];
        int b[] = new int[6];
    }



    @Test
    public void testPrintFormat() {
        for (int i = 0; i < 6; i++)
            System.out.print("***\n");
        System.out.format("%s", "----");
    }

    @Test
    public void testJunitJarPath() {
        URL url = this.getClass().getClassLoader().getResource("com/jdk/other/justdemo/StringDemo.class");
        System.out.println(url.getPath());
    }
}

