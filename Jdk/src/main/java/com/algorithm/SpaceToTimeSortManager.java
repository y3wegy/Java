package com.algorithm;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Rui on 8/20/2015.
 */
public class SpaceToTimeSortManager {
    public static final Logger logger = Logger.getLogger(SpaceToTimeSortManager.class);
    private static final int SIZE = 1000000;

    public static void main(String[] args) {
        SpaceToTimeSortManager spaceToTimeSortManager = new SpaceToTimeSortManager();
        int[] a = spaceToTimeSortManager.initData();
        int[] old = new int[SIZE];

        System.arraycopy(a, 0, old, 0, a.length); //back up data

        long start = System.currentTimeMillis();
        Arrays.sort(a);
        long end = System.currentTimeMillis();
        logger.info("Array .sort take time :" + (end - start) + " ms ");

        start = end;
        System.arraycopy(old, 0, a, 0, old.length);  //restore data

        spaceToTimeSortManager.spaceToTime(a);
        end = System.currentTimeMillis();
        logger.info("Space to Time method take time:" + (end - start) + " ms ");


    }

    public int[] initData() {
        int[] arrayValue = new int[SIZE];
        Map<Integer, Object> map = new HashMap<>();
        int count = 0;
        Random random = new Random(SIZE*10);
        while (count < arrayValue.length) {
            int value = random.nextInt() + 1;
            if (map.get(value) == null) {
                map.put(value, value);
                arrayValue[count] = value;
                count++;
            }
        }
        return arrayValue;
    }

    public void spaceToTime(int[] array) {
        int i = 0;
        int max = array[0];
        for (i = 0; i < array.length; i++)
            if (array[i] > max)
                max = array[i];

        int[] temp = new int[max + 1];
        for (i = 0; i < array.length; i++)
            temp[array[i]] = array[i];

        int j = 0;
        for (i = 0; i < max + 1; i++)
            if (temp[i] > 0)
                array[j++] = temp[i];
    }

}
