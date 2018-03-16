package com.jdk.jvm.classloader;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

/**
 * @author Chen,Rui
 * @date 02/28/2018
 * @description
 */
public class ValueLoad {
    private static final Logger logger = Logger.getLogger(ValueLoad.class);

    /**
     * -------------------------------------------------------------
     * author       date        comment
     * Chen,Rui   02/28/2018   init version
     * -------------------------------------------------------------
     *
     * @description if directly set static final value ,this will not trigger static failed init
     */
    @Test
    public void testValue() {
        //Class<Clazz1> clazz1 =Clazz1.class;
        logger.info("Clazz1.staticFinalValue:" + Clazz1.staticFinalValue);   //  Clazz1.staticFinalValue is complie constant, not need to init class
        logger.info("get  Clazz1.staticValue,to see Clazz1 init whether or not? ");
        logger.info("Clazz1.staticValue:" + Clazz1.staticValue);
    }

    /**
     * -------------------------------------------------------------
     * author       date        comment
     * Chen,Rui   02/28/2018   init version
     * -------------------------------------------------------------
     *
     * @description if one filed ref another field ,this will trigger another field init first.
     */
    @Test
    public void testValue2() {
        logger.info("Clazz2.staticFinalValue:" + Clazz2.staticFinalValue);
    }

    /**
     * -------------------------------------------------------------
     * author       date        comment
     * Chen,Rui   02/28/2018   init version
     * -------------------------------------------------------------
     *
     * @description if static final field call method to init value,this will trigger all static fiel init
     */
    @Test
    public void testValue3() {
        logger.info("Clazz3.staticFinalValue:" + Clazz3.staticFinalValue);
    }
}

class Clazz1 {
    private static final Logger logger = Logger.getLogger(Clazz1.class);
    public static int staticValue = 5;
    public static final int staticFinalValue = 1;

    static {
        logger.info("init Clazz1 completed");
    }
}

class Clazz2 {
    private static final Logger logger = Logger.getLogger(Clazz2.class);

    static {
        logger.info("init class2 completed!");
    }

    public static int staticValue = get(4);
    public static final int staticFinalValue = staticValue + 1;


    public Clazz2() {
        logger.info("staticFinalValue:" + staticValue);
    }

    private static int get(int x) {
        logger.info("get " + x);
        return x;
    }

}

class Clazz3 {
    private static final Logger logger = Logger.getLogger(Clazz3.class);
    public static final int staticFinalValue = get(1);
    public static int staticValue = get(2);

    static {
        logger.info("init class3 completed!");
    }

    public Clazz3() {
        logger.info("staticFinalValue:" + staticValue);
    }

    private static int get(int x) {
        logger.info("get " + x);
        return x;
    }

}
