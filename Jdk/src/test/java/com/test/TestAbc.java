package com.test;

/**
 * Created by a549238 on 8/17/2015.
 */

import junit.framework.TestCase;
import org.junit.Test;

public class TestAbc extends TestCase {

    @Test
    public void testABC() {
        System.out.println("ABC");
    }

    @Test
    public void testAC() {
        System.out.println("AC");
    }

    @Test
    public void testADC() {
        System.out.println("ADC");
    }

    @Test
    public void testReplaceNull(){
        try {
            "123".replaceAll("1",null==null?"":null);

            String value = String.valueOf(null);
            assertEquals(null,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
