package com.jdk.jvm;

import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeapStackTest {
    private static final Logger logger = Logger.getLogger(HeapStackTest.class);

    private static int a = 10;

    @Test
    public void testAccessFieldTime() {
        HeapStackTest test = new HeapStackTest();
        test.add(10);
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 10000000; i++)
            a *= i;
        long endTime = System.currentTimeMillis();
        logger.info("operate on static variable take time:" + (endTime - startTime) + " ms");

        int b = 10;
        startTime = System.currentTimeMillis();
        for (int i = 1; i <= 10000000; i++)
            b *= i;
        endTime = System.currentTimeMillis();
        logger.info("operate on main  variable take time:" + (endTime - startTime) + " ms");


    }

    public void add(int value) {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 10000000; i++)
            value *= i;
        long endTime = System.currentTimeMillis();
        logger.info("operate on method variable take time:" + (endTime - startTime) + " ms");
    }
}