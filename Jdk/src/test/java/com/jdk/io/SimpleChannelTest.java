package com.jdk.io;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class SimpleChannelTest {
    public static final Logger logger = Logger.getLogger(SimpleChannelTest.class);
    private static final int BUFF_SIZE = 1024;
    private static final String DATA_PATH = SimpleChannelTest.class.getClassLoader().getResource(".").getPath() + "data.txt";
    private static final String FILE_PATH = SimpleChannelTest.class.getClassLoader().getResource(".").getPath() + "out.txt";

    @Before
    public void setUp() throws Exception {
        File file= new File(FILE_PATH);
        if(file.exists()){
            file.delete();
        }
    }
    @Test
    public void testSimple() throws Exception {
        FileChannel fc = null;
        try {
            fc = new FileOutputStream(FILE_PATH).getChannel();
            fc.write(ByteBuffer.wrap("Some Text".getBytes()));
        } finally {
            if (fc != null) {
                fc.close();
            }
        }

        try {
            fc = new RandomAccessFile(FILE_PATH, "rw").getChannel();
            fc.position(fc.size());
            fc.write(ByteBuffer.wrap("Some More".getBytes()));
        } finally {
            if (fc != null) {
                fc.close();
            }
        }

        try {
            fc = new FileInputStream(FILE_PATH).getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(BUFF_SIZE);
            fc.read(byteBuffer);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining())
                logger.info((char) byteBuffer.get());
        } finally {
            if (fc != null) {
                fc.close();
            }
        }
    }

    @Test
    public void testChannel2Channel() throws Exception {
        FileChannel fileInChannnel = null;
        FileChannel fileOutChannel = null;
        try {
            fileInChannnel = new FileInputStream(DATA_PATH).getChannel();
            fileOutChannel = new FileOutputStream(FILE_PATH).getChannel();
            fileInChannnel.transferTo(0, fileInChannnel.size(), fileOutChannel);
        } finally {
            if (fileInChannnel != null) {
                fileInChannnel.close();
            }
            if (fileOutChannel != null) {
                fileOutChannel.close();
            }
        }

        try {
            fileInChannnel = new FileInputStream(FILE_PATH).getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(BUFF_SIZE);
            while (fileInChannnel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    logger.info((char) byteBuffer.get());
                }
                byteBuffer.clear();
            }
        } finally {
            if (fileInChannnel != null) {
                fileInChannnel.close();
            }
        }
    }
}
