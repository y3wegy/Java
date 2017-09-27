package com.jdk.value;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Rui on 3/25/14.
 */
public class DataIntSegment {
    @Test
    public void IntTest() {
        Integer a1 = 40;
        Integer a2 = 40;
        Integer a3 = 0;

        Integer a4 = new Integer(40);
        Integer a5 = new Integer(40);
        Integer a6 = new Integer(0);


        Assert.assertTrue(a1 == a2);
        Assert.assertTrue(a1 == a2 + a3);
        Assert.assertFalse(a1 == a4);
        Assert.assertFalse(a4 == a5);
        Assert.assertTrue(a4 == a5 + a6);
        Assert.assertTrue(a1 == a5 + a6);


    }

    @Test
    public void testIntAddress() {
        int a = 1;
        int b = 2;
        int c = a + b;
        int d = 3;
        Assert.assertTrue(c == d);

        Integer A = 1;
        Integer B = 2;
        Integer C = A + B;
        Integer D = 3;
        Assert.assertTrue(C == D);
    }
}
