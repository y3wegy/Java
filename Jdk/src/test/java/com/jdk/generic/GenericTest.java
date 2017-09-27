package com.jdk.generic;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by e631876 on 9/11/2017.
 */
public class GenericTest {
    private static final Logger logger = Logger.getLogger(GenericTest.class);

    @Test
    public void testGenericMethod() throws Exception {
        GenericMethod simpleClass = new GenericMethod();
        simpleClass.<String, String>function("ssss");
        simpleClass.<String, Boolean>function2(simpleClass.<String, Boolean>map());
    }

    @Test
    public void testContructor() {
        Object obj = new String("123");
        Class clazz = String.class;
        try {
            Constructor constructor = clazz.getConstructor(StringBuffer.class);
            String value = (String) constructor.newInstance(new StringBuffer("abc"));
            String value2 = (String) clazz.newInstance();
            logger.info(String.format("create with param:%s;create without param:%s", value, value2));

        } catch (Exception e) {
            e.printStackTrace();
        }

        Class clazz2 = obj.getClass();
        try {
            logger.info(clazz2.newInstance().toString());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCast() throws Exception {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("Object.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (objectInputStream != null) try {
            List<String> list = ArrayList.class.cast(objectInputStream.readObject());
            for (String item : list)
                logger.info(item);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}