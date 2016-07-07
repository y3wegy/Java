package com.jdk.excel;

/**
 * Excel method
 *
 * @author a549238
 */
public interface IExcel {

    public void createExcel(String fileName, String sheetName, int size);

    void readExcel(String fileName, String sheetName);

}
