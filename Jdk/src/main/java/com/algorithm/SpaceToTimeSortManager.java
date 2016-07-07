package com.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by a549238 on 8/20/2015.
 */
public class SpaceToTimeSortManager {

    private static final int SIZE = 1000000;
    private int[] arrayValue;

    public static void main(String[] args) {
        SpaceToTimeSortManager spaceToTimeSortManager = new SpaceToTimeSortManager();
        int[] a = spaceToTimeSortManager.initData();
        int[] old = new int[SIZE];

        System.arraycopy(a, 0, old, 0, a.length); //back up data

        long start = System.currentTimeMillis();
        Arrays.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("Array .sort take time :" + (end - start) + " ms ");

        start = end;
        System.arraycopy(old, 0, a, 0, old.length);  //restore data

        spaceToTimeSortManager.spaceToTime(a);
        end = System.currentTimeMillis();
        System.out.println("Space to Time method take time:" + (end - start) + " ms ");


    }

    public int[] initData() {
        int[] arrayValue = new int[SIZE];
        Map<Integer, Object> map = new HashMap<Integer, Object>();
        int count = 0;
        while (count < arrayValue.length) {
            int value = (int) (Math.random() * SIZE * 10 + 1);
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
