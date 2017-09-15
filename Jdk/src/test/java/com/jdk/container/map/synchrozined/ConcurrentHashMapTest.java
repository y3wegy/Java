package com.jdk.container.map.synchrozined;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * concurrentHashmap set and put method is sy
 * Created by a549238 on 7/1/2016.
 */
public class ConcurrentHashMapTest {
    public static final Logger logger = LoggerFactory.getLogger(ConcurrentHashMapTest.class);
    @Test
    public void testSynarizhed() throws InterruptedException {
        Map<String, String> map = new ConcurrentHashMap<>(100,0.75f,6);
        map.put("key","1");
        String value = map.get("key");
        logger.info("before operate,value:{}"+value);
        new Thread(new TestThread(map)).start();
        new Thread(new TestThread(map)).start();

        Thread.sleep(1000);
        value =map.get("key");
        logger.info("After operate,value:{}",value);
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