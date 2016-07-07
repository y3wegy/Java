package com.jdk.nio.channel;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/5/13
 * Time: 5:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class GetChannel {

    private static final int SIZE = 1024;

    private static final String TEMP = "temp.txt";

    public static void main(String[] args) {
        init();
        //Writer
        try {
            FileChannel fc = new FileOutputStream(TEMP).getChannel();
            fc.write(ByteBuffer.wrap("Some Text".getBytes()));
            fc.close();

            fc = new RandomAccessFile(TEMP, "rw").getChannel();
            fc.position(fc.size());
            fc.write(ByteBuffer.wrap("Some More".getBytes()));
            fc.close();

            fc = new FileInputStream(TEMP).getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(SIZE);
            fc.read(byteBuffer);
            byteBuffer.flip(); //the method must be called before read data from bytebuffer  , you must call clear() before  put data
            while (byteBuffer.hasRemaining())
                System.out.print((char) byteBuffer.get());

            fc.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private static void init() {
        File file = new File(TEMP);
        if (file.exists())
            file.delete();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
