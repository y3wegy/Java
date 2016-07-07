package com.jdk.Container.map.synchrozined;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * concurrentHashmap set and put method is sy
 * Created by a549238 on 7/1/2016.
 */
public class ConcurrentHashMapTest {
    @Test
    public void testSynarizhed() {
        Map<String, String> map = new ConcurrentHashMap<String, String>();
        map.put("key","1");
        String value = map.get("key");
        System.out.println("before operate,value:"+value);
        new Thread(new testThread(map)).start();
        new Thread(new testThread(map)).start();

        value =map.get("key");
        System.out.println("After operate,value:"+value);



    }

    class testThread implements Runnable {
        private Map<String,String> map;

        public testThread(Map<String,String>  map) {
            this.map = map;
        }

        @Override
        public void run() {
            String value = map.get("key");
            value= value +"1";
            map.put("key",value);
        }
    }
}
