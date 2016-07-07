package com.jdk.generic;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Created by a549238 on 5/9/14.
 */
public class ConstructorClass {
    @Test
    public void testContructor() {
        Object obj = new String("123");
        Class clazz = String.class;
        try {
            Constructor constructor = clazz.getConstructor(StringBuffer.class);
            String value = (String) constructor.newInstance(new StringBuffer("abc"));
            String value2 = (String) clazz.newInstance();


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Class clazz2 = obj.getClass();
        try {
            clazz2.newInstance().toString();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getClassType() {
        System.out.println(new ArrayList<String>().getClass().getName());
    }
}
