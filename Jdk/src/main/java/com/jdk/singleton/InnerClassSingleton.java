package com.jdk.singleton;

import org.apache.log4j.Logger;

/**
 * Created by Rui on 6/25/2015.
 * <p/>
 * http://www.ibm.com/developerworks/cn/java/j-lo-Singleton/
 */
public class InnerClassSingleton {
    public static final Logger logger = Logger.getLogger(InnerClassSingleton.class);
    private InnerClassSingleton() {
        logger.info("InnerClassSingleton create");
    }

    public static InnerClassSingleton getInstance() {
        return SingletonHolder.instance;
    }

    //use static inner class to avoid synchronized
    private static class SingletonHolder {
        private SingletonHolder() {
        }
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }
}
