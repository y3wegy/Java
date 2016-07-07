package com.jdk.excel.impl;

import com.jdk.excel.AbstractExcelTest;
import com.jdk.excel.bean.Production;
import com.jdk.excel.factory.ProductionFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class POIDemo extends AbstractExcelTest {

    private static final String EXCEL_NAME = "POI.xls";

    @Test
    public void testExcel() {
        createExcel(EXCEL_NAME, "POI_TEST", SIZE);
        readExcel(EXCEL_NAME, "POI_TEST");
    }

    @Override
    public void createExcel(String fileName, String sheetName, int size) {
        long start = System.nanoTime();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFCell cell = null;
        try {
            FileOutputStream op = new FileOutputStream(fileName);
            HSSFSheet sheet = workbook.createSheet(sheetName);
            HSSFRow row = sheet.createRow(0);
            for (int i = 0; i < HEADERS.length; i++) {
                cell = row.createCell(i, HSSFCell.CELL_TYPE_STRING);
                cell.setCellValue(HEADERS[i]);
            }
            List<Production> productions = ProductionFactory
                    .createRecords(size);
            for (int i = 0; i < productions.size(); i++) {
                row = sheet.createRow(i + 1);
                cell = row.createCell(0, HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(productions.get(i).getId());
                cell = row.createCell(1, HSSFCell.CELL_TYPE_STRING);
                cell.setCellValue(productions.get(i).getSubject());
                cell = row.createCell(2, HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(productions.get(i).getPrice());
                cell = row.createCell(3, HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(productions.get(i).getCount());
                cell = row.createCell(4, HSSFCell.CELL_TYPE_STRING);
                cell.setCellValue(productions.get(i).getDescription());
            }
            workbook.write(op);
            System.out.println("Test write "
                    + SIZE
                    + " rows take time:"
                    + (TimeUnit.SECONDS.convert(System.nanoTime() - start,
                    TimeUnit.NANOSECONDS)) + " s ");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void readExcel(String fileName, String sheetName) {
        int rowNum = 0;
        try {
            long start = System.nanoTime();
            FileInputStream fip = new FileInputStream(fileName);
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            if (".xls".endsWith(suffix)) {
                HSSFWorkbook workbook = new HSSFWorkbook(fip);
                rowNum = praseXLS(workbook);
            }
            fip.close();
            System.out
                    .println("now:"
                            + dateFormat.format(new Date())
                            + ",read "
                            + rowNum
                            + " rows data take time :"
                            + TimeUnit.SECONDS.convert(System.nanoTime()
                            - start, TimeUnit.NANOSECONDS) + " s");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int praseXLS(HSSFWorkbook workbook) {
        if (workbook == null) {
            System.out.println("Work book is null ,return !");
        }
        HSSFSheet sheet = null;
        HSSFRow row = null;
        HSSFCell cell = null;
        int i = 0;
        for (; i < workbook.getNumberOfSheets(); i++) {
            sheet = workbook.getSheetAt(i);
            System.out.println("sheet index:" + i);
            for (int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {
                row = sheet.getRow(j);
                for (int k = 0; k < row.getLastCellNum(); k++) {
                    cell = row.getCell(k);
                    switch (cell.getCellType()) {
                        case HSSFCell.CELL_TYPE_BOOLEAN:
                            System.out.println("value:"
                                    + cell.getBooleanCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_NUMERIC:
                            System.out.println("value:"
                                    + cell.getNumericCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_STRING:
                            System.out
                                    .println("value:" + cell.getStringCellValue());
                            break;
                        default:
                            break;

                    }
                }
            }
        }
        return i - 1;
    }

}
