package com.jdk.Enum.utility;

import com.jdk.Enum.WeekDayEnum;
import jxl.Range;
import jxl.Sheet;
import jxl.format.Colour;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

/**
 * Created by a549238 on 3/30/2016.
 */
public class UtilityTest {
    @Test
    public void testEnumSet() {
        for (WeekDayEnum item : EnumSet.range(WeekDayEnum.Mon, WeekDayEnum.Fri)) {
            System.out.println(item);
        }
    }

    //map key is enum

    @Test
    public void testEnumMap() {
        WritableWorkbook book = new WritableWorkbook() {
            @Override
            public WritableSheet[] getSheets() {
                return new WritableSheet[0];
            }

            @Override
            public String[] getSheetNames() {
                return new String[0];
            }

            @Override
            public WritableSheet getSheet(int index) throws IndexOutOfBoundsException {
                return null;
            }

            @Override
            public WritableSheet getSheet(String name) {
                return null;
            }

            @Override
            public WritableCell getWritableCell(String loc) {
                return null;
            }

            @Override
            public int getNumberOfSheets() {
                return 0;
            }

            @Override
            public void close() throws IOException, WriteException {

            }

            @Override
            public WritableSheet createSheet(String name, int index) {
                return null;
            }

            @Override
            public WritableSheet importSheet(String name, int index, Sheet s) {
                return null;
            }

            @Override
            public void copySheet(int s, String name, int index) {

            }

            @Override
            public void copySheet(String s, String name, int index) {

            }

            @Override
            public void removeSheet(int index) {

            }

            @Override
            public WritableSheet moveSheet(int fromIndex, int toIndex) {
                return null;
            }

            @Override
            public void write() throws IOException {

            }

            @Override
            public void setProtected(boolean prot) {

            }

            @Override
            public void setColourRGB(Colour c, int r, int g, int b) {

            }

            @Override
            public WritableCell findCellByName(String name) {
                return null;
            }

            @Override
            public Range[] findByName(String name) {
                return new Range[0];
            }

            @Override
            public String[] getRangeNames() {
                return new String[0];
            }

            @Override
            public void removeRangeName(String name) {

            }

            @Override
            public void addNameArea(String name, WritableSheet sheet, int firstCol, int firstRow, int lastCol, int lastRow) {

            }

            @Override
            public void setOutputFile(File fileName) throws IOException {

            }
        };
        Map<WeekDayEnum, WeekDayEnum> schema = new EnumMap<WeekDayEnum, WeekDayEnum>(WeekDayEnum.class);
        for (int i = 0; i < WeekDayEnum.values().length; i++)
            schema.put(WeekDayEnum.values()[i], WeekDayEnum.values()[i]);
    }
}
