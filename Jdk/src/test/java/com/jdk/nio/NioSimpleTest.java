package com.jdk.nio;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

public class NioSimpleTest {
    private static final Logger logger = Logger.getLogger(NioSimpleTest.class);
    @Test
    void testRewind() {
        ByteBuffer byteBuffer = ByteBuffer.wrap("test".getBytes());
        byteBuffer.mark();
        byteBuffer.put("2222".getBytes());
        byteBuffer.rewind();
        logger.info(new String(byteBuffer.array()));
    }

    @Test
    void testInt() {
        int num = 907654321;
        System.out.println(Integer.toHexString(num));
        System.out.println(Long.toHexString(num * 16L));
        System.out.println((int)((num * 16L) & 0xffffffff));

    }
}
