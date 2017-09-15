package com.jdk.io;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ByteBufferTest {
    private static final Logger logger = Logger.getLogger(ByteBufferTest.class);
    private static final int BUFF_SIZE = 1024;
    private static final String FILE_PATH = ByteBufferTest.class.getClassLoader().getResource("").getPath() + "out.txt";

    private static final String SYSTEM_CHARSET = System.getProperty("file.encoding");
    private static final Charset charSet = Charset.forName(SYSTEM_CHARSET);

    @Before
    public void setUp() throws Exception {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * there two ways to clone byteBuffer:slice() and duplicate().
     * slice will copy remainding content;
     * duplicate will copy all content; cap same as org bytebuffer
     *
     * @throws Exception
     */
    @Test
    public void testClone() throws Exception {
        //treate wrap as clear,data remained ,and  position is 0 ,so can't use flip before get()
        ByteBuffer byteBuffer = ByteBuffer.wrap("Hello".getBytes());
        logger.info(String.format("Original position:%s", byteBuffer.capacity()));
        byteBuffer.get();
        ByteBuffer sliceByteBuffer = byteBuffer.slice();
        ByteBuffer duplicateByteBuffer = byteBuffer.duplicate();
        ByteBuffer compactByteBuffer = byteBuffer.compact();
        sliceByteBuffer.put(2, Byte.parseByte("1"));

        Assert.assertEquals(byteBuffer.capacity() - 1, sliceByteBuffer.capacity());
        Assert.assertEquals(byteBuffer.capacity(), duplicateByteBuffer.capacity());
        Assert.assertEquals(byteBuffer.capacity(), compactByteBuffer.capacity());
    }

    /**
     * decode
     *
     * @throws Exception
     */
    @Test
    public void testReadFileByteBuffer() throws Exception {
        FileChannel fileChannel = null;
        try {
            fileChannel = new FileOutputStream(FILE_PATH).getChannel();
            fileChannel.write(ByteBuffer.wrap("testReadFileByteBuffer".getBytes()));
        } finally {
            if (fileChannel != null) {
                fileChannel.close();
            }
        }

        CharsetDecoder decoder = charSet.newDecoder();
        try {
            fileChannel = new FileInputStream(FILE_PATH).getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(BUFF_SIZE);
            while (fileChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                logger.info(String.format("As Charbuffer will not display correctly:%s", byteBuffer.asCharBuffer()));
                byteBuffer.rewind();
                logger.info(String.format("Use System decoder:%s", decoder.decode(byteBuffer)));
                byteBuffer.clear();
            }
        } finally {
            if (fileChannel != null) {
                fileChannel.close();
            }
        }
    }

    /**
     * encode bytebuffer
     *
     * @throws Exception
     */
    @Test
    public void testEncodeByteBuffer() throws Exception {
        FileChannel fileChannel = null;
        try {
            fileChannel = new FileOutputStream(FILE_PATH).getChannel();
            fileChannel.write(ByteBuffer.wrap("testReadFileByteBuffer".getBytes(SYSTEM_CHARSET)));
        } finally {
            if (fileChannel != null) {
                fileChannel.close();
            }
        }

        try {
            fileChannel = new FileInputStream(FILE_PATH).getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(BUFF_SIZE);
            while (fileChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                logger.info(String.format("As Charbuffer:%s", byteBuffer.asCharBuffer()));
            }
        } finally {
            if (fileChannel != null) {
                fileChannel.close();
            }
        }
    }
}
