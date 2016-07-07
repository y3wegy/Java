package com.jdk.excel.impl;

import com.jdk.excel.AbstractExcelTest;
import com.jdk.excel.bean.Production;
import com.jdk.excel.factory.ProductionFactory;
import jxl.*;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Number;
import jxl.write.biff.RowsExceededException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class JXLDemo extends AbstractExcelTest {
    private static final String EXCEL_NAME = "jxl.xls";

    @Test
    public void testExcel() {
        createExcel(EXCEL_NAME, "JXL_TEST", SIZE);
        readExcel(EXCEL_NAME, "JXL_TEST");
    }

    @Override
    public void createExcel(String fileName, String sheetName, int size) {
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(new File(fileName));
            WritableSheet sheet = workbook.createSheet(sheetName, 0);
            WritableFont font = new WritableFont(WritableFont.TIMES, 18, WritableFont.BOLD, true, UnderlineStyle.NO_UNDERLINE, Colour.RED);
            WritableCellFormat cellformat = new WritableCellFormat(font);
            int i = 0;
            for (String item : HEADERS) {
                Label label = new Label(i, 0, item, cellformat);
                sheet.addCell(label);
                i++;
            }

            List<Production> productions = ProductionFactory.createRecords(size);
            long start = System.nanoTime();
            int c = 1;
            for (Production prod : productions) {
                sheet.addCell(new Number(0, c, prod.getId()));
                sheet.addCell(new Label(1, c, prod.getSubject()));
                sheet.addCell(new Number(2, c, prod.getPrice()));
                sheet.addCell(new Number(3, c, prod.getCount()));
                sheet.addCell(new Label(4, c, prod.getDescription()));
                c++;
            }
            workbook.write();
            workbook.close();
            long end = System.nanoTime();
            System.out.println("now:" + dateFormat.format(new Date()) + ",JXL write " + SIZE + " rows take time:" + TimeUnit.MILLISECONDS.convert(end - start, TimeUnit.NANOSECONDS) + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readExcel(String fileName, String sheetName) {
        try {
            long start = System.nanoTime();
            Workbook workbook = Workbook.getWorkbook(new File(fileName));
            Sheet sheet = workbook.getSheet(sheetName);
            int i = 0;
            for (; i < sheet.getRows(); i++) {
                Cell[] cells = sheet.getRow(i);
                for (Cell cell : cells) {
                    if (cell.getType() == CellType.NUMBER)
                        System.out.println(((NumberCell) cell).getValue());
                    else
                        System.out.println(cell.getContents() + " ");
                }
            }
            workbook.close();
            System.out.println("now:" + dateFormat.format(new Date()) + ",Jxl read " + (i - 1) + " rows take time:" + TimeUnit.MILLISECONDS.convert(System.nanoTime() - start, TimeUnit.NANOSECONDS) + " ms");
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
