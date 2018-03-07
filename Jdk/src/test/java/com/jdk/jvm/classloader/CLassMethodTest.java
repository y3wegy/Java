package com.jdk.jvm.classloader;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 *
 */
public class CLassMethodTest {
    private static final Logger logger = Logger.getLogger(CLassMethodTest.class);

    /**
     * test some method of Class about class name
     */
    @Test
    public void testClassName() {
        TestClass testClass = new TestClass();
        logger.info(testClass.getClass().getCanonicalName());
        logger.info(testClass.getClass().getName());
        logger.info(testClass.getClass().getSimpleName());
    }

    /**
     * only  display inner class defined in this class(private ,public protected and so on)
     */
    @Test
    public void testGetDecalredClasses() {
        for (Class clazz : TestClass.class.getDeclaredClasses()) {
            System.out.println(clazz.getName());
        }
    }

    /**
     * only get public inner class defined in this class and super class
     * @throws Exception
     */
    @Test
    public void testGetClasses() throws Exception {
        for (Class clazz : TestClass.class.getClasses()) {
            System.out.println(clazz.getName());
        }
    }

    class TestClass extends TestFatherClass implements myInterfaceA,myInterfaceB{
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

    interface myInterfaceA {}

    interface myInterfaceB {}
}


