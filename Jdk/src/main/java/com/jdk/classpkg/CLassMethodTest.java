package com.jdk.classpkg;

import org.junit.Test;

/**
 * Created by a549238 on 2/22/2016.
 */
public class CLassMethodTest {

    @Test
    public void testGetDecalredClasses() {
        for (Class clazz : TestClass.class.getDeclaredClasses()) {
            System.out.println(clazz.getName());
        }
    }

    @Test
    public void testGetClasses() throws Exception {
        for (Class clazz : TestClass.class.getClasses()) {
            System.out.println(clazz.getName());
            /*
            Output:
            com.jdk.classpkg.TestClass$InnerClass2
            com.jdk.classpkg.TestFatherClass$InnerClass5
             */
        }
    }
}

class TestClass extends TestFatherClass {
    private int a;

    private void fun() {

    }

    class InnerClass {
    }

    public class InnerClass2 {
    }

    protected class InnerClass3 {
    }
}

class TestFatherClass {
    class InnerClass4 {
    }

    public class InnerClass5 {
    }

    protected class InnerClass6 {
    }
}
