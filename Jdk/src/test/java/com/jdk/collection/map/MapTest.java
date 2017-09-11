package com.jdk.collection.map;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by a549238 on 5/25/2015.
 */
public class MapTest {

    Map<String, String> map = new HashMap<String, String>();
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

    @Test
    public void testMerge() throws Exception {
        Map<String,Integer> pageVisitMap  = new HashMap<>();
        updatePageVisit(pageVisitMap,"baidu.com");
        updatePageVisit(pageVisitMap,"baidu.com");
        for(Map.Entry<String,Integer> item:pageVisitMap.entrySet()){
            System.out.println(item.getKey()+":"+item.getValue());
        }
    }

    private void updatePageVisit(Map<String,Integer> pageVisitMap,String page){
        pageVisitMap.merge(page,1,(key,value)->value+1);
    }

    private void changeValue(Map<String, String> map) {
        map.put("2", "2");
    }
}
