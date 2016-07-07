package com.algorithm;

/**
 * Created by a549238 on 5/25/2015.
 */
public class SortManager {
    public static int[] bubbleSort(int[] values) {
        // int[] sortedValues= new int[values.length];
        int temp;
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = 0; j < values.length - 1 - i; j++) {
                if (values[j] > values[j + 1]) {
                    temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
            }
        }
        return values;
    }
}
