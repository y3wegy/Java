package com.test;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Created by a549238 on 8/17/2015.
 */

public class SuitTest extends TestCase {
    public static Test suite() {

        return new TestSetup(new TestSuite(TestAbc.class)) {

            protected void setUp() throws Exception {
                System.out.println(" Global setUp ");
            }

            protected void tearDown() throws Exception {
                System.out.println(" Global tearDown ");
            }
        };

        /*TestSuite suite=new TestSuite();
        suite.addTestSuite(TestAbc.class);

        return (Test) suite;*/
    }

}


