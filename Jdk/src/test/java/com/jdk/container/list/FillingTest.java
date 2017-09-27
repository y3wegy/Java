package com.jdk.container.list;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Rui
 * Date: 12/24/13
 * Time: 2:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class FillingTest {
    private static final Logger logger = Logger.getLogger(FillingTest.class);
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
