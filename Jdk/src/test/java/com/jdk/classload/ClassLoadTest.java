package com.jdk.classload;

import com.jdk.bean.Production;
import com.jdk.bean.classinfo.AllChild;
import com.jdk.bean.classinfo.AllFather;
import com.jdk.bean.classinfo.singleton.NoStaticSingleton;
import com.jdk.bean.classinfo.singleton.StaiticSingleton;
import org.apache.log4j.Logger;
import org.junit.Test;


/**
 * Created by e631876 on 9/11/2017.
 */
public class ClassLoadTest {
    public static final Logger logger = Logger.getLogger(ClassLoadTest.class);

    /**
     * test Class static field method and normal field and method init and load order
     *
     * @throws Exception
     */
    @Test
    public void testClassLoadOrder() throws Exception {
        logger.info("testClassLoadOrder");
        AllFather allFather = new AllChild();
    }

    /**
     * test static field init in singleton
     */
    @Test
    public void testStaticInit() {
        StaiticSingleton mysingleton = StaiticSingleton.GetInstence();
        logger.info(StaiticSingleton.a);
        logger.info(StaiticSingleton.b);
    }

    /**
     * test non static field init in singleton
     */
    @Test
    public void testNoStaticInit() {
        NoStaticSingleton mysingleton = NoStaticSingleton.GetInstence();
        logger.info(mysingleton.a);
        logger.info(mysingleton.b);
    }

    @Test
    public void testClassForNameWithoutinit() throws Exception {
        try {
            Class<Production> clazz = (Class<Production>) Class.forName("com.jdk.bean.Production", false, ClassLoadTest.class.getClassLoader());    //load but not init
            logger.info("Before Init,Production.staticField still 0");
            Production calledClass2 = clazz.newInstance();
            logger.info("After Init");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testClassForNameWithInit() throws Exception {
        Class<?> clazz = null; // load and init
        try {
            clazz = Class.forName("com.jdk.bean.Production");
            logger.info("Before Init,Production.staticField has value 1");
            Production calledClass = (Production) clazz.newInstance();
            logger.info("After Init");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}