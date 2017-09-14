package com.jdk.bean.classinfo;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 3/21/13
 * Time: 2:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class AllChild extends AllFather {

    private static int childStaticField = nn(1);
    private int childField = nn(2);

    public AllChild() {
        logger.info("This is run in  AllChild constructor method!");
        logger.info("childStaticField=" + childStaticField + ";childField=" + childField);
    }

    public static int nn(int x) {
        logger.info("This is run in AllChild.nn() ;x=" + x);
        return x;
    }
}
