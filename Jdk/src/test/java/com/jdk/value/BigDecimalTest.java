package com.jdk.value;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by a549238 on 6/8/2016.
 */
public class BigDecimalTest {
    @Test
    public void testDecimal() {
        BigDecimal bigDecimal = new BigDecimal(123.0000000000000003033030303);
        BigDecimal big2 = new BigDecimal(123.22);
        System.out.println(bigDecimal.toString());
        System.out.println(big2.toString());
    }
}
