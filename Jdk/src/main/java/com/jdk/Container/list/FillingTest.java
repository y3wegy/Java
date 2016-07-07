package com.jdk.Container.list;

import org.junit.Test;

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
    @Test
    public void testFill() {
        List<StringAddress> list = new ArrayList<StringAddress>(Collections.nCopies(4, new StringAddress("Hello")));

        System.out.println(list);

        Collections.fill(list, new StringAddress("World"));

        System.out.println(list);
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
