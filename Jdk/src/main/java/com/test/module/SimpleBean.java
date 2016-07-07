package com.test.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by a549238 on 1/22/14.
 */
public class SimpleBean {
    public int add(int a, int b) {
        return a + b;
    }

    public double div(double a, double b) {
        return a / b;
    }

    public String getName(String name) {
        return name;
    }

    public List<String> getList(String value) {
        List list = new ArrayList();
        list.add(value);
        return list;
    }

    public Map<String, String> getMap(String key, String value) {
        Map<String, String> map = new HashMap<String, String>();
        map.put(key, value);
        return map;
    }
}
