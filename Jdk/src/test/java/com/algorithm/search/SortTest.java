package com.algorithm.search;

import com.algorithm.SortManager;
import org.junit.Test;

/**
 * Created by Rui on 5/25/2015.
 */
public class SortTest {
    private SortManager sortManager = new SortManager();

    @Test
    public void testBubbleSort() {
        int[] values = {3, 4, 1, 8, 6, 4, 0, 2, 6, 7, 2, 1};
        values = sortManager.bubbleSort(values);
        for (int value : values)
            System.out.print(value + " ");
    }
}
