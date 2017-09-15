package com.excel.factory;

import com.jdk.bean.Production;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ProductionFactory {
    private ProductionFactory() {
    }

    public static List<Production> createRecords(int size) {
        if (size < 0)
            return Collections.emptyList();
        List<Production> recordList = new ArrayList<>();
        int i = 0;
        Random random = new Random(60);
        while (i++ < size) {
            Production record = new Production();
            record.setId(i);
            record.setCount(random.nextInt());
            record.setDescription("jxl test");
            record.setPrice(Math.random() * 100);
            record.setSubject("test");
            recordList.add(record);
        }
        return recordList;
    }
}
