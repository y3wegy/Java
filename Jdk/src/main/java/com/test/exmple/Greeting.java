package com.test.exmple;

import org.apache.log4j.Logger;

/**
 * Created by Rui on 1/24/14.
 */
public class Greeting {
    public static final Logger logger = Logger.getLogger(Greeting.class);
    public void coveredByUnitTest() {
        logger.info("<UnitTest> Hello, world.");
    }

    public void coveredByIntegrationTest() {
        logger.info("<IntegrationTest> Hello, world.");
    }
}
