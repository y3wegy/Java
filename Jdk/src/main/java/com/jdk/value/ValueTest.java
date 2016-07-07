package com.jdk.value;

import org.junit.Test;

/**
 * Created by a549238 on 3/18/2016.
 */
public class ValueTest {
    @Test
    public void testDefaultValue() {
        class A {
            public A() {
                int s = get();
                System.out.println("s:" + s);
            }

            public int get() {

                int a = 1;
                return a;
            }
        }
        new A();
    }

    @Test
    public void testValue() {
        System.out.println("033:" + 033 + "\n0x2F:" + 0x2F + "\n0X7FFF:" + 0X7FFF);
        System.out.println("2E2:" + 2E2);
        float fvalue = 1e12f; //if miss  tail  "f" ,will be error
        System.out.println("0x01^0x1:" + (0x01 ^ 0x1) + "\n~0x01:" + ~0x01 + "\n~0x011:" + ~0x011);
        System.out.println("true|false:" + (true | false) + "\ntrue&false:" + (true & false));
        System.out.println("Integer.toBinaryString(33):" + Integer.toBinaryString(33));
    }
}
