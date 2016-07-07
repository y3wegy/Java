package com.jdk.value;

import org.junit.Assert;
import org.junit.Test;

public class StringMemoryAddressTest {
    private static final int MAX = 4000000;

    @Test
    public void testWithIntern() {
        long start = System.currentTimeMillis();
        String[] attr = new String[MAX];
        for (int i = 0; i < MAX; i++) {
            // attr[i] = String.valueOf(i%10);
            attr[i] = String.valueOf(i % 10).intern();
        }
        //intern:563 ms
        System.out.println((System.currentTimeMillis() - start) + " ms");
        System.gc();
        System.out.print(attr[0]);
    }

    @Test
    public void testWithoutIntern() {
        long start = System.currentTimeMillis();
        String[] attr = new String[MAX];
        for (int i = 0; i < MAX; i++) {
            // attr[i] = String.valueOf(i%10);
            attr[i] = String.valueOf(i % 10);
        }
        //without intern():1418 ms
        System.out.println((System.currentTimeMillis() - start) + " ms");
        System.gc();
        System.out.print(attr[0]);
    }

    @Test
    public void testAddedStr() {
        String a = "a";
        String aa = "aa";
        String a2 = "a" + a;

        Assert.assertFalse(aa == a2);
        Assert.assertTrue(a2.intern() == aa);
        Assert.assertTrue(aa.equals(a2));

        final String finalA = "a";
        String a3 = finalA + "a";
        Assert.assertTrue(aa == a3);

        String A = "a1";
        String B = "a" + 1;
        Assert.assertTrue(A == B);
    }

    @Test
    public void testAddress() {
        String a = "ja";
        String b = "va";
        String c = a + b;
        String d = "java";
        String e = "ja" + "va";
        Assert.assertFalse(c == d);
        Assert.assertTrue(c.intern() == d);
        Assert.assertTrue(d == e);
    }

}
