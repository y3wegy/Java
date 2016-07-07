package com.jdk.Container.map;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by a549238 on 5/12/2015.
 */
public class MapTest {
    Map<String, String> map = new HashMap<String, String>();

    @Test
    public void testIterator() {
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
        }
    }

    @Test
    public void testNUll() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        System.out.print(map.get(1));
        BigDecimal b = new BigDecimal(2);
    }

    @Test
    public void testChangeValue() {
        Map<String, String> map = new HashMap<String, String>();
        changeValue(map);
        System.out.print(map.size());
    }

    @Test
    public void testLinkedHashMap() throws Exception {
        Map map = new LinkedHashMap();
        map.put("1", "a");

    }

    private void changeValue(Map<String, String> map) {
        map.put("2", "2");
    }
}
