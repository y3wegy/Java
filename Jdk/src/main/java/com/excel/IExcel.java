package com.excel;

import java.text.SimpleDateFormat;

/**
 * Excel method
 *
 * @author a549238
 */
public interface IExcel {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String[] HEADERS = new String[]{"ID,", "subject", "price", "count", "description"};
    int SIZE = 65535;

    public void createExcel(String fileName, String sheetName, int size);

    void readExcel(String fileName, String sheetName);

}
