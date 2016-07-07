package com.jdk.classpkg.classinit.initorder;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/30/13
 * Time: 3:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoaderStep {

    @Test
    public void testClassLoadNotInit() {
        try {
            Class<CalledClass> clazz = (Class<CalledClass>) Class.forName("CalledClass", false, LoaderStep.class.getClassLoader());    //load but not init
            System.out.println("Before Init");
            CalledClass calledClass2 = null;
            calledClass2 = clazz.newInstance();
            System.out.println("After Init");
            CalledClass.go(23);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("testClassLoadNotInit end ");

    }

    @Test
    public void TestClassLoadAndInit() {
        Class<?> clazz = null; // load and init
        try {
            clazz = Class.forName("CalledClass");
            System.out.println("Before Init");
            CalledClass calledClass = (CalledClass) clazz.newInstance();
            System.out.println("After Init");
            CalledClass.go(23);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
