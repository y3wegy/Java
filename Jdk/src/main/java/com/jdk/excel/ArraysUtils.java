package com.jdk.excel;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by a549238 on 8/12/2015.
 */
public class ArraysUtils {
    @Test
    public void testSearch() {
        String[] values = {"AB", "BC", "CD", "DE"};
        System.out.println(Arrays.binarySearch(values, "A"));
        System.out.println(Arrays.binarySearch(values, "B"));
        System.out.println(Arrays.binarySearch(values, "D"));
        System.out.println(Arrays.binarySearch(values, "F"));
        System.out.println(Arrays.binarySearch(values, "CD"));
        System.out.println(Arrays.binarySearch(values, "2"));
    }
}
