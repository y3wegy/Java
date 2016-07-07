package com.plugin.failsafe;

import com.test.exmple.Greeting;
import org.junit.Test;

/**
 * Created by a549238 on 1/24/14.
 */
public class GreetingIT {
    @Test
    public void test() {
        new Greeting().coveredByIntegrationTest();
    }
}
