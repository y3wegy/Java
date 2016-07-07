package com.jdk.generic.cast;

import org.junit.Test;

/**
 * Created by a549238 on 2/13/14.
 */
public class CastDemo {

    @Test
    public void testCast() {
        Class<Integer> clazz = Integer.class;
        try {
            Integer intx = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
