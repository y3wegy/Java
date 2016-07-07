package com.jdk.nio.filedemo.filepathdemo;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 3/22/13
 * Time: 4:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreateFile {
    public static void main(String[] args) {
        String filepath = "c:\\dd.txt";
        File file = new File(filepath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
