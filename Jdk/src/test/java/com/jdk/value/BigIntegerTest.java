package com.jdk.value;

import org.junit.Test;

import java.math.BigInteger;

/**
 * Created by Rui on 3/18/2016.
 */
public class BigIntegerTest {
    @Test
    public void testCreate() {
        BigInteger bigInteger = new BigInteger("1233333333333333333333333333333333333333333333333333");
        System.out.println(bigInteger.add(new BigInteger("1")));
    }
}
