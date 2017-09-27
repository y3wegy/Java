package com.plugin.surefire;

import com.test.exmple.Greeting;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Rui on 1/24/14.
 */
public class GreetingTest {

    @Before
    public void beforeTest() {
        System.out.println("Test is running !");
    }

    @Test
    public void test() {
        new Greeting().coveredByUnitTest();
    }
}
