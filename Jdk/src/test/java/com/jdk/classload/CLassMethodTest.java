package com.jdk.classload;

import com.jdk.bean.classinfo.AllChild;
import com.jdk.bean.classinfo.AllFather;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 *
 */
public class CLassMethodTest {
    public static final Logger logger = Logger.getLogger(CLassMethodTest.class);

    /**
     * test some method of Class about class name
     */
    @Test
    public void testFatherClassName() {
        AllFather father = new AllChild();
        logger.info(father.getClass().getCanonicalName());
        logger.info(father.getClass().getName());
        logger.info(father.getClass().getSimpleName());
    }

    /**
     * test some method of Class about class name
     */
    @Test
    public void testChildClassName() {
        AllChild child = new AllChild();
        logger.info(child.getClass().getCanonicalName());
        logger.info(child.getClass().getName());
        logger.info(child.getClass().getSimpleName());
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


