package com.jdk.jvm.classloader;

import com.jdk.bean.classinfo.AllChild;
import com.jdk.bean.classinfo.AllFather;
import com.jdk.bean.classinfo.singleton.NoStaticSingleton;
import com.jdk.bean.classinfo.singleton.StaiticSingleton;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;


/**
 * 
 * @author Chen,Rui
 * @date 02/28/2018
 * @description test class field init order
 */
public class ClassFieldInitOrderTest {
    private static final Logger logger = Logger.getLogger(ClassFieldInitOrderTest.class);

    /**
     * test Class static field method and normal field and method init and load order
     *
     * @throws Exception
     */
    @Test
    public void testClassLoadOrder() throws Exception {
        logger.info("testClassLoadOrder");
        AllFather allFather = new AllChild();
        allFather.get();
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
        NoStaticSingleton mySingleton = NoStaticSingleton.GetInstence();
        logger.info(mySingleton.a);
        logger.info(mySingleton.b);
    }

    @Test
    public void testClassForNameWithoutinit() throws Exception {
        try {
            Class<AllFather> clazz = (Class<AllFather>) Class.forName("com.jdk.bean.classinfo.AllFather", false, ClassFieldInitOrderTest.class.getClassLoader());    //load but not init
            logger.info("Before Init,all static and normal field will not init");
            clazz.newInstance();
            logger.info("init completed");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testClassForNameWithInit() throws Exception {
        Class<AllFather> clazz = null; // load and init
        try {
            clazz = (Class<AllFather>) Class.forName("com.jdk.bean.classinfo.AllFather");
            logger.info("Before Init,static field will init.");
            clazz.newInstance();
            logger.info("init completed");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}