package com.jdk.Container.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by a549238 on 5/8/2015.
 */
public class SubListDemo {

    @Test
    public void testSubList() {
        List<String> list = Arrays.asList(new String[]{"1", "2", "3", "4", "5"});
        System.out.println(list.get(0));
        for (String item : list.subList(1, 3))
            System.out.println(item);
    }
}
