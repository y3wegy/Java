package com.jdk.io;

import com.jdk.bean.Production;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * ObjectOutputStream ByteArrayOutputStream
 */

public class DeserializeObjTest {
    public static final Logger logger = Logger.getLogger(DeserializeObjTest.class);
    public static final String FILE_PATH = DeserializeObjTest.class.getClassLoader().getResource("").getPath()+"out.txt";

    private final Production production = new Production(1,"PC",4999d,2,"Lenovo");
    private final Production production2 = new Production(2,"PC",5999d,2,"Dell");

    @Before
    public void setUp() throws Exception {
        logger.info(String.format("ProductionL:%s",production));
    }

    @Test
    public void testSerialiableObjByFile() throws Exception {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
            objectOutputStream.writeObject("Worm Storage\n");
            objectOutputStream.writeObject(production);
            objectOutputStream.writeObject(production2);
            objectOutputStream.flush();
        } finally {
            IOUtils.closeQuietly(objectOutputStream);
        }

        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(FILE_PATH));
            String s = (String) objectInputStream.readObject();
            Production serializabledprod = (Production) objectInputStream.readObject();
            Production serializabledprod2 = (Production) objectInputStream.readObject();
            logger.info(String.format("not serializable:%s\n; serialiable :%s\n%s", s, serializabledprod,serializabledprod2));
        } finally {
            IOUtils.closeQuietly(objectInputStream);
        }
    }

    @Test
    public void testSerialiableByByteArray() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject("Worm Storage\n");
            objectOutputStream.writeObject(production);
            objectOutputStream.writeObject(production2);
            objectOutputStream.flush();

            ObjectInputStream objectInputStream1 = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            String s = (String) objectInputStream1.readObject();
            Production serializabledprod = (Production) objectInputStream1.readObject();
            Production serializabledprod2 = (Production) objectInputStream1.readObject();
            logger.info(String.format("not serializable:%s\n; serialiable :%s\n%s", s, serializabledprod,serializabledprod2));
        } finally {
            IOUtils.closeQuietly(objectOutputStream);
            IOUtils.closeQuietly(byteArrayOutputStream);
        }
    }
}