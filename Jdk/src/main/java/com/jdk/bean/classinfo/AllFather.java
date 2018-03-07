package com.jdk.bean.classinfo;

import org.apache.log4j.Logger;

/**
 * test Class static field method and normal field and method init and load order
 * Created with IntelliJ IDEA.
 * User: Rui
 * Date: 3/21/13
 * Time: 2:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class AllFather {
    private static final Logger logger = Logger.getLogger(AllFather.class);
    private static int staticField = go(11);

    protected int c = getC();

    public int getC() {
        logger.info("run in AllFather getC");
        return staticField+c;
    }

    static {
        logger.info("This is run in AllFather static !");
    }

    protected int field = go(22);

    public AllFather() {
        super();
        logger.info("This is run in  AllFather constructor method!");
        logger.info("staticField=" + staticField + ";field=" + field);
        field = 39;
    }

    public static int go(int x) {
        logger.info("This is run in AllFather.go() ;x=" + x);
        return x;
    }
}
