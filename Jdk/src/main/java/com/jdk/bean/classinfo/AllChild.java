package com.jdk.bean.classinfo;

import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Rui
 * Date: 3/21/13
 * Time: 2:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class AllChild extends AllFather {
    private static final Logger logger = Logger.getLogger(AllFather.class);
    private static int childStaticField = go(1);
    private int childField = go(2);

    static {
        logger.info("This is run in AllChild static !");
    }

    public AllChild() {
        super();
        logger.info("This is run in  AllChild constructor method!");
        logger.info("childStaticField=" + childStaticField + ";childField=" + childField);
    }

    public static int go(int x) {
        logger.info("This is run in AllChild.go() ;x=" + x);
        return x;
    }
}
