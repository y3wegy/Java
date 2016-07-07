package com.jdk.nio.bytebuffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/6/13
 * Time: 3:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReverseBuffer {

    private static final int SIZE = 1024;

    private static void symmetricsScramable(CharBuffer charBuffer) {
        while (charBuffer.hasRemaining()) {
            charBuffer.mark();
            char c1 = charBuffer.get();
            char c2 = charBuffer.get();
            charBuffer.reset();
            charBuffer.put(c2).put(c1);
        }
    }

    public static void main(String[] args) {
        char[] charArray = "This is a test!".toCharArray();
        ByteBuffer byteBuffer = ByteBuffer.allocate(charArray.length * 2);
        byteBuffer.asCharBuffer().put(charArray);
        symmetricsScramable(byteBuffer.asCharBuffer());
        System.out.println(byteBuffer.asCharBuffer().rewind());
        symmetricsScramable(byteBuffer.asCharBuffer());
        System.out.println(byteBuffer.asCharBuffer().rewind());
        symmetricsScramable(byteBuffer.asCharBuffer());
        System.out.println(byteBuffer.asCharBuffer().rewind());
    }
}
