package com.jdk.value;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by a549238 on 1/28/2016.
 */
public class DoubleTest {
    @Test
    public void testGetPrecisionDoubleValue() {
        Double value = 0.1;
        BigDecimal bigDecimal = new BigDecimal(value);
        System.out.println(bigDecimal);  //0.1000000000000000055511151231257827021181583404541015625

        //so if you want to get precision BigDecimal value ,should use String

        String strValue = "0.1";
        bigDecimal = new BigDecimal(strValue);
        Assert.assertEquals("0.1", bigDecimal.toString());
    }
}
