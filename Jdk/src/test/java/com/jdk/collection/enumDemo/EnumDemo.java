package com.jdk.collection.enumDemo;

/**
 * Created by a549238 on 10/23/2015.
 */
public class EnumDemo {
    public static void main(String[] args) {
        System.out.println("value:" + EnumTest.valueOf("i"));
    }

    public enum EnumTest {
        NULL, TEST1, TEST2;

        public EnumTest getbyName(String name) {
            return valueOf(name);
        }
    }
}
