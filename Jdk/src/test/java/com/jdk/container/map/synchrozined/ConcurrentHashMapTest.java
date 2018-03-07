package com.jdk.container.map.synchrozined;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * concurrentHashmap set and put method is sy
 * Created by Rui on 7/1/2016.
 */
public class ConcurrentHashMapTest {
    private static final Logger logger = Logger.getLogger(ConcurrentHashMapTest.class);
    @Test
    public void testSynarizhed() throws InterruptedException {
        Map<String, String> map = new ConcurrentHashMap<>(100,0.75f,6);
        map.put("key","1");
        String value = map.get("key");
        logger.info(String.format("before operate,staticValue:%s",value));
        new Thread(new TestThread(map)).start();
        new Thread(new TestThread(map)).start();

        Thread.sleep(1000);
        value =map.get("key");
        logger.info(String.format("After operate,staticValue:%s",value));
    }

    class TestThread implements Runnable {
        private Map<String,String> map;

        public TestThread(Map<String,String>  map) {
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
