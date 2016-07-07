package com.jdk.nio.filedemo.datainputstream;

import org.junit.Test;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/4/13
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class FormattedMemoryInput {

    private static final String path = "data.ini";

    @Test
    public void testDataInputStream() {
        try {
            DataInputStream dip = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(path))));
            String lineStr;
            while ((lineStr = dip.readLine()) != null)
                System.out.println(lineStr);
            /*while(dip.available()!=0)
            {
				System.out.println((char)dip.readByte());
			}*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
