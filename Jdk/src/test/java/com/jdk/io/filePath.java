package com.jdk.io;

import org.junit.Test;

import java.io.File;

/**
 * Created by a549238 on 4/16/2015.
 */
public class filePath {
    @Test
    public void testPath() {
        File file = new File("test.txt");
        String code = System.getProperty("file.encoding");
        System.out.println(code);
    }
}
