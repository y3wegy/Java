package com.jdk.collection;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CollectionNullTest {
    private static final Logger logger = Logger.getLogger(CollectionNullTest.class);


    @Test
    void testssss() {
        logger.info(String.format("%" + 10 + "s", 1));
    }

    @Test
    void testHashMap() {
        //HashMap  允许null-null键值对
        Map<String,String> hashMap = new HashMap<>();
        hashMap.put("11", "ddd");
        hashMap.put("1233", null);
        hashMap.put(null, "wang");
        hashMap.put(null, null);
        logger.info("HashMap以上代码运行成功");
    }

    @Test
    void testTreeMap() {
        //TreeMap  允许value值为null，不允许key值为null
        TreeMap<String,String> treeMap = new TreeMap<>();

        //Map放入第一个元素时不会调用比较器，所以不会调用比较器，不会出现NullPointerException
        //以下一行代码执行时不会报错，但当treeMapp中放入元素大于1时，就会调用比较器，出现NullPointerException
        // treeMap.put(null, null);
        treeMap.put("ddd", null);
        treeMap.put("sss", null);
        logger.info("TreeMap以上代码运行成功");
    }

    @Test
    void testHashTable() {
        Hashtable<String,String> hashtable = new Hashtable<>(1);
        Assertions.assertThrows(NullPointerException.class,()->hashtable.put(null,"1"));
    }

    @Test
    void testHashSet() {
        //HashSet
        Set<String> hashSet = new HashSet<>();
        hashSet.add(null);
        hashSet.add("ddd");
        logger.info("HashSet以上代码运行成功");
    }

    @Test
    void testTreeSet() {
        //TreeSet
        Set<String> treeSet = new TreeSet<>();
        //以下两行代码执行时，会报错。理由同TreeMap
        //treeSet.add(null);
        treeSet.add("sss");
        logger.info("TreeSet以上代码运行成功");
    }

    @Test
    void testArrayList() {
        //ArrayList
        List<String> arrayList = new ArrayList<>();
        arrayList.add(null);
        arrayList.add("dd");
        logger.info("ArrayList以上代码运行成功");
    }

    @Test
    void testLinkedList() {
        //LinkedList
        List<String> linkedList = new LinkedList<>();
        linkedList.add(null);
        linkedList.add("ddd");
        logger.info("LinkedList以上代码运行成功");
    }
}
