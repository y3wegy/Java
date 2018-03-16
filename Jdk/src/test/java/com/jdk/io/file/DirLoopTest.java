package com.jdk.io.file;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.File;

/**
 * Created by Chen,Rui on 9/14/2017.
 */
public class DirLoopTest {
    private static final Logger logger = Logger.getLogger(DirLoopTest.class);

    @Test
    public void testLoopDir() throws Exception {
        ProcessFiles.Strategy strategy = new ProcessFiles.Strategy() {
            @Override
            public void process(File file) {
                logger.info(file);
            }
        };
        new ProcessFiles(strategy, "java").start(new String[0]);
    }
}