package com.jdk.Container.ChangeValueDemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 6/25/13
 * Time: 2:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class ChangeValueDemo {
    @Test
    public void testMe() {
        ChangeValueDemo changeValueDemo = new ChangeValueDemo();
        String str = "123";

        String array1 = "1";
        String[] array = new String[]{array1, "2", "3"};


        Map<String, List<String>> listMap = new HashMap<String, List<String>>();
        List<String> valueList = new ArrayList<String>();
        listMap.put("key", valueList);
        System.out.println("before call change method,str:" + str + " ;array[0]:" + array[0] + " ;array1:" + array1 + " ;listMap.get(\"key\").size():" + (listMap.get("key").size()));
        changeValueDemo.change(str, array, listMap);
        System.out.println("after call change method,str:" + str + " ;array[0]:" + array[0] + " ;array1:" + array1 + " ;listMap.get(\"key\").size():" + (listMap.get("key").size()));
        /**
         * before call change method,str:123 ;array[0]:1 ;array1:1 ;listMap.get("key").size():0
         after call change method,str:123 ;array[0]:a ;array1:1 ;listMap.get("key").size():1
         */
    }

    private void change(String str, String[] array, Map<String, List<String>> listMap) {
        str = "qwe";
        array[0] = "a";
        listMap.get("key").add("123");
    }
}