package com.jdk.excel;

import java.text.SimpleDateFormat;

public abstract class AbstractExcelTest implements IExcel {

    public static final String[] HEADERS = new String[]{"ID,", "subject", "price", "count", "description"};
    public static final int SIZE = 65535;
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //private static final String test="test";
    public AbstractExcelTest() {

    }

    public static String test() {
        return "test";
    }
}
