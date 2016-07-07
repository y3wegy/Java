package com.jdk.classpkg;

import org.junit.Test;

/**
 * Created by a549238 on 11/16/2015.
 */
public class classNameTest {

    @Test
    public void testFatherClassName() {
        Father father = new Child();
        System.out.println(father.getClass().getCanonicalName());
        System.out.println(father.getClass().getName());
        System.out.println(father.getClass().getSimpleName());
    }

    @Test
    public void testChildClassName() {
        Child child = new Child();
        System.out.println(child.getClass().getCanonicalName());
        System.out.println(child.getClass().getName());
        System.out.println(child.getClass().getSimpleName());
    }

    class Father {
    }

    class Child extends Father {
    }
}

