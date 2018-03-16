package com.excel;

import com.excel.impl.JXLExcelManager;
import com.excel.impl.POIExcelManager;
import org.junit.Test;

/**
 * Created by Chen,Rui on 9/11/2017.
 */
public class ExcelTest {
    private static final String JXL_EXCEL_NAME = ExcelTest.class.getClassLoader().getResource("").getPath()+"jxl.xls";
    private static final String POI_EXCEL_NAME = ExcelTest.class.getClassLoader().getResource("").getPath()+"POI.xls";
    @Test
    public void testJXL() throws Exception {
        IExcel excelManager  = new JXLExcelManager();
        excelManager.createExcel(JXL_EXCEL_NAME, "JXL_TEST", IExcel.SIZE);
        excelManager.readExcel(JXL_EXCEL_NAME, "JXL_TEST");
    }

    @Test
    public void testPOI() throws Exception {
        IExcel excelManager = new POIExcelManager();
        excelManager.createExcel(POI_EXCEL_NAME, "POI_TEST", IExcel.SIZE);
        excelManager.readExcel(POI_EXCEL_NAME, "POI_TEST");

    }
}
