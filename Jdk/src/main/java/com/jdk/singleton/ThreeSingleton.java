package com.jdk.singleton;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rui on 6/25/2015.
 */
public class ThreeSingleton {
    public static final Logger logger = Logger.getLogger(ThreeSingleton.class);
    private static final String DEFAULT_PREFIX = "CACHE";
    private static final int INSTANCE_SIZE = 3;
    private static Map<String, ThreeSingleton> instatnceMap = new HashMap<>();
    private static int number = 1;

    private ThreeSingleton() {
        logger.info("ThreeSingleton create");
    }

    public static synchronized ThreeSingleton getInstance() {
        String key = DEFAULT_PREFIX + number;
        ThreeSingleton instance = instatnceMap.get(key);
        if (instance == null) {
            instance = new ThreeSingleton();
            instatnceMap.put(key, instance);
        }
        number++;
        if (number > INSTANCE_SIZE)
            number = 1;
        return instance;
    }
}
