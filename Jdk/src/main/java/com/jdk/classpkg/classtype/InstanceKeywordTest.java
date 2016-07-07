package com.jdk.classpkg.classtype;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by a549238 on 5/8/14.
 */
public class InstanceKeywordTest {

    @Test
    public void testInstanceOf() {
        List<String> list = Arrays.asList("123", "234");

        if (list instanceof List)
            System.out.println("This is a List"); //true
        if (list instanceof ArrayList)
            System.out.println("This is an ArrayList"); //true
        if (list instanceof Object)
            System.out.println("This is an Object");//true

        Father father = new Father();

        Assert.assertTrue(father instanceof SubClass); //false

        Father sub = new SubClass();
        Assert.assertTrue(sub instanceof SubClass); //true
    }

    @Test
    public void testIsInstance() {
        List<String> list = Arrays.asList("123", "234");

        if (List.class.isInstance(list))
            System.out.println("This is a List");//true
        if (ArrayList.class.isInstance(list))
            System.out.println("This is an ArrayList");//true
        if (Object.class.isInstance(list))
            System.out.println("This is an Object");//true
    }

    @Test
    public void testIsAssignableFrom() {
        List<String> list = Arrays.asList("123", "234");

        if (list.getClass().isAssignableFrom(List.class))
            System.out.println("This is a List");//false
        if (list.getClass().isAssignableFrom(ArrayList.class))
            System.out.println("This is an ArrayList");//true
        if (list.getClass().isAssignableFrom(Object.class))
            System.out.println("This is an Object");//false
    }

    class Father {
    }

    class SubClass extends Father {
    }
}



