package com.jdk.string;

import org.junit.Test;

/**
 * Created by a549238 on 10/8/2015.
 */
public class StringBuilderDemo {
    @Test
    public void testDel() {
        StringBuilder sb = new StringBuilder();
        sb.append("123456789");
        System.out.println("SB length:" + sb.length());
        sb.delete(sb.length() - 2, sb.length());
        System.out.println("After del:" + sb.toString());
    }
}
