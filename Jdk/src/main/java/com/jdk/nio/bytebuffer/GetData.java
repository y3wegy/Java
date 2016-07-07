package com.jdk.nio.bytebuffer;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/6/13
 * Time: 1:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class GetData {

    private static final int SIZE = 1024;
    private static ByteBuffer byteBuffer = ByteBuffer.allocate(SIZE);

    public GetData() {

        int i = 0;
        while (i++ < byteBuffer.limit())
            if (byteBuffer.get() != 0)
                print("NO ZERO");
        println("i:" + i);
    }

    private static void print(Object obj) {
        System.out.print(obj);
    }

    private static void println(Object obj) {
        System.out.println(obj);
    }

    @Test
    public void testChar() {
        //char
        byteBuffer.rewind();
        byteBuffer.asCharBuffer().put("Hello");
        // byteBuffer.reset();       //reset() make pos to mark position
        char c;
        while ((c = byteBuffer.getChar()) != 0)
            print(c + " ");
    }

    @Test
    public void testShort() {
        //short
        byteBuffer.rewind();
        byteBuffer.asShortBuffer().put((short) 12);
        println("short:" + byteBuffer.getShort());
    }

    @Test
    public void testDouble() {
        //double
        byteBuffer.rewind();
        byteBuffer.asDoubleBuffer().put(234);
        byteBuffer.asDoubleBuffer().put(123);
        println("double:" + byteBuffer.getDouble());   //123.0

    }

    @Test
    public void testArray() {
        byteBuffer.rewind();
        IntBuffer intbuffer = byteBuffer.asIntBuffer();
        intbuffer.put(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        println("index 3:" + intbuffer.get(3));
        intbuffer.put(3, 12);
        intbuffer.flip();
        while (intbuffer.hasRemaining()) {
            println(intbuffer.get());
        }

        intbuffer.rewind();
        int[] arrays = new int[10];
        intbuffer.get(arrays);    //put data to the array
        println("arrays length: " + arrays.length);
    }
}
