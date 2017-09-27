package com.jdk.io.file;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by Rui on 4/16/2015.
 */
public class FileLoadPathTest {
    private static final Logger logger =Logger.getLogger(FileLoadPathTest.class);

    @Test
    public void testLoadResource() {
        ClassLoader classLoader = FileLoadPathTest.class.getClassLoader();
        logger.info("classLoader.getResource(\"\").getPath():" + classLoader.getResource("").getPath());
        logger.info("classLoader.getResource(\"\"):" + classLoader.getResource(""));
        logger.info("class.getResource(\"\"):" + FileLoadPathTest.class.getResource("").getPath());
        logger.info("class.getResource(\".\"):" + FileLoadPathTest.class.getResource(".").getPath());
        logger.info("class.getResource(\"data.txt\").getPath():" + classLoader.getResource("data.txt").getPath());
        logger.info("class.getResource(\"data.txt\").getFile():" + classLoader.getResource("data.txt").getFile());
    }
}
