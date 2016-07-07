package com.jdk.Container.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListIteration {
    @Test
    public void iteraion() {
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(9);
        intList.add(8);
        intList.add(3);
        intList.add(5);
        Collections.sort(intList);
        for (Integer item : intList) {
            System.out.println(item);
        }
    }

}
