package com.jdk.generic;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Rui
 * Date: 12/20/13
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class GenericMethod {
    private static final Logger logger = Logger.getLogger(GenericMethod.class);
    /*
 generaic  use in method
  */
    public <U, V> void function(U u)

    {
        logger.info(u);
    }

    public <U, V> void function2(Map<U, V> map) {
        logger.info("execute in function2");
    }

    public <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }
}
