package com.jdk.io.file;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by Rui on 4/16/2015.
 */
public class FileMethodTest {
    private static final Logger logger = Logger.getLogger(FileMethodTest.class);

    /**
     * class File some constant attr
     */
    @Test
    public void testFileSep() {
        logger.info(File.separator);
        logger.info(File.separatorChar);
        logger.info(System.getProperty("file.encoding"));
    }

    @Test
    public void testFilterByType() {
        String path = getClass().getClassLoader().getResource(".").getPath();
        final String regex = ".+\\.ini";
        File file = new File(path);
        String[] list = file.list(
                new FilenameFilter() {
                    private Pattern pattern = Pattern.compile(regex);

                    @Override
                    public boolean accept(File dir, String name) {
                        return pattern.matcher(name).matches();
                    }
                }
        );
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String name : list)
            logger.info(name);
    }

    /**
     * File method about path
     */
    @Test
    public void testPath() {
        File file = new File(".");
        logger.info("file.getPath():" + file.getPath());
        logger.info("file.getAbsolutePath():" + file.getAbsolutePath());
        try {
            logger.info("file.getCanonicalPath():" + file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("System.getProperty(\"user.dir\"):" + System.getProperty("user.dir"));
    }

    /**
     * create parent dir
     * @throws Exception
     */
    @Test
    public void testFileParent() throws Exception {
        String path = FileMethodTest.class.getClassLoader().getResource("").getPath().toString() + "data\\config.ini";
        File file = new File(path);
        logger.info(file.getParentFile().getPath());
        file.mkdirs();
    }
}
