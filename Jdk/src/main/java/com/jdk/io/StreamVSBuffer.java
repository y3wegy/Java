package com.jdk.io;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * Created by a549238 on 8/19/2015.
 */
public class StreamVSBuffer {
    private static final String filePath = "temp.txt";

    @Before
    public void initTempFile() {
        File file = new File(filePath);
        if (file.exists())
            file.delete();
    }

    @Test
    public void streamMethod() {
        long start = System.currentTimeMillis();
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(filePath));
            for (int i = 0; i < 10000; i++)
                dataOutputStream.writeBytes(String.valueOf(i) + "\r\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new FileInputStream(filePath));
            while (dataInputStream.readLine() != null)
                ;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dataInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("no Buffered IO writer 10000 records take time :" + (end - start) + " ms ");

    }

    @Test
    public void bufferedMethod() {
        long start = System.currentTimeMillis();
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filePath)));
            for (int i = 0; i < 10000; i++) {
                dataOutputStream.writeBytes(String.valueOf(i) + "\r\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(filePath)));
            while (dataInputStream.readLine() != null)
                ;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dataInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Buffered IO writer 10000 record take time:" + (end - start) + " ms ");
    }
}
