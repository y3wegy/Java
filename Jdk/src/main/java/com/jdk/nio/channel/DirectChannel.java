package com.jdk.nio.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/6/13
 * Time: 10:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class DirectChannel {

    private static final String IN = "in.txt";
    private static final String OUT = "out.txt";

    public static void main(String[] args) {
        init();
        FileChannel in = null;
        try {
            in = new FileInputStream(new File(IN)).getChannel();
            FileChannel out = new FileOutputStream(new File(OUT)).getChannel();

            in.transferTo(0, in.size(), out);

            in.close();
            out.close();
            // or out.transferFrom(in,0,in.size());
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    private static void init() {
        File in = new File(IN);
        File out = new File(OUT);
        if (out.exists())
            out.delete();
        if (in.exists())
            in.delete();
        try {
            out.createNewFile();
            in.createNewFile();
            FileChannel outChannel = new FileOutputStream(in).getChannel();
            outChannel.write(ByteBuffer.wrap("Some Thing ".getBytes()));
            outChannel.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
