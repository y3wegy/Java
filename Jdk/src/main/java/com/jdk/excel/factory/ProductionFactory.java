package com.jdk.excel.factory;

import com.jdk.bean.Production;

import java.util.ArrayList;
import java.util.List;

public class ProductionFactory {
    public static List<Production> createRecords(int size) {
        if (size < 0)
            return null;
        List<Production> recordList = new ArrayList<Production>();
        int i = 0;
        while (i++ < size) {
            Production record = new Production();
            record.setId(i);
            record.setCount((int) (Math.random() * 60));
            record.setDescription("jxl test");
            record.setPrice(Math.random() * 100);
            record.setSubject("test");
            recordList.add(record);
        }
        return recordList;
    }
}
