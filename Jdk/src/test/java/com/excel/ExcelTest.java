package com.excel;

import com.excel.impl.JXLExcelManager;
import com.excel.impl.POIExcelManager;
import org.junit.Test;

/**
 * Created by e631876 on 9/11/2017.
 */
public class ExcelTest {
    private static final String JXL_EXCEL_NAME = "jxl.xls";
    private static final String POI_EXCEL_NAME = "POI.xls";
    @Test
    public void testJXL() throws Exception {
        IExcel excelManager  = new JXLExcelManager();
        excelManager.createExcel(JXL_EXCEL_NAME, "JXL_TEST", AbstractExcelManager.SIZE);
        excelManager.readExcel(JXL_EXCEL_NAME, "JXL_TEST");
    }

    @Test
    public void testPOI() throws Exception {
        IExcel excelManager = new POIExcelManager();
        excelManager.createExcel(POI_EXCEL_NAME, "POI_TEST", AbstractExcelManager.SIZE);
        excelManager.readExcel(POI_EXCEL_NAME, "POI_TEST");

    }
}
