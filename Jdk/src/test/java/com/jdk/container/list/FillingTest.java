package com.jdk.container.list;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/24/13
 * Time: 2:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class FillingTest {
    public static final Logger logger = LoggerFactory.getLogger(FillingTest.class);
    @Test
    public void testFill() {
        List<StringAddress> list = new ArrayList<>(Collections.nCopies(4, new StringAddress("Hello")));
        logger.info(String.valueOf(list.size()));
        Collections.fill(list, new StringAddress("World"));
        logger.info(String.valueOf(list.size()));
    }
}

class StringAddress {
    private String str;

    public StringAddress(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return super.toString() + " " + str;
    }
}
