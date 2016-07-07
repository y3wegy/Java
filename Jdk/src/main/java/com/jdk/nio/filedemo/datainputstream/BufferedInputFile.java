package com.jdk.nio.filedemo.datainputstream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/4/13
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class BufferedInputFile {
    public static String read(String filePath) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String temp;
            StringBuilder stringBuilder = new StringBuilder();
            while ((temp = bufferedReader.readLine()) != null) {
                stringBuilder.append(temp);
            }
            bufferedReader.close();
            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
