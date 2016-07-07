package com.jdk.collection.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by a549238 on 5/25/2015.
 */
public class MapTest {
    @Test(expected = ConcurrentModificationException.class)
    public void testIterationWithEx() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if ("2".equals(entry.getKey()))
                map.remove(entry.getKey());
        }
    }

    @Test
    public void testIteration() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            if ("2".equals(entry.getKey()))
                it.remove();
        }

        for (Map.Entry<String, String> entry : map.entrySet())
            System.out.println(entry.getKey() + "=" + entry.getValue());
    }
}
