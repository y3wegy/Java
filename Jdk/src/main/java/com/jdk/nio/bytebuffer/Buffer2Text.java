package com.jdk.nio.bytebuffer;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/6/13
 * Time: 10:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class Buffer2Text {

    private static final int SIZE = 1024;
    private static final String SOURCE_FILE = "source.txt";

    private ByteBuffer byteBuffer = ByteBuffer.allocate(SIZE);

    private static void init() {
        File file = new File(SOURCE_FILE);
        if (file.exists())
            file.delete();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Test
    public void testreadAndWrite() {
        FileOutputStream fo = null;
        FileChannel fc = null;
        FileInputStream fi = null;
        try {
            fo = new FileOutputStream(SOURCE_FILE);
            fc = fo.getChannel();
            fc.write(ByteBuffer.wrap("Some Text".getBytes()));
            fc.close();
            fo.close();

            fi = new FileInputStream(SOURCE_FILE);
            fc = fi.getChannel();
            byteBuffer.clear();
            fc.read(byteBuffer);
            fi.close();
            byteBuffer.flip();
            System.out.println("use bytebuffer read:,bytebuffer:" + byteBuffer.toString() + ";\nasCharSet:" + byteBuffer.asCharBuffer());

            byteBuffer.rewind();   // reset the index to zero

            System.out.println("content:" + byteBuffer2String(byteBuffer));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testCharset() {
        FileOutputStream fo = null;
        FileChannel fc = null;
        FileInputStream fi = null;
        try {
            String charSetStr = "UTF-16BE";
            fo = new FileOutputStream(SOURCE_FILE);
            fc = fo.getChannel();
            fc.write(ByteBuffer.wrap("SomeThing".getBytes(charSetStr)));
            fc.close();
            fo.close();
            // now try read again:
            fi = new FileInputStream(SOURCE_FILE);
            fc = fi.getChannel();
            byteBuffer.clear();
            fc.read(byteBuffer);
            byteBuffer.flip();
            System.out.println("Use " + charSetStr + " read:" + byteBuffer.asCharBuffer());
            fi.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void testConvert() {
        FileOutputStream fo = null;
        FileChannel fc = null;
        FileInputStream fi = null;
        try {
            fo = new FileOutputStream(SOURCE_FILE);
            fc = fo.getChannel();
            byteBuffer = ByteBuffer.allocate(24);
            byteBuffer.asCharBuffer().put("SomeThing");
            byteBuffer.asCharBuffer().put("SomeThing2");//will replace prior content
            fc.write(byteBuffer);
            fc.close();
            fo.close();

            fi = new FileInputStream(SOURCE_FILE);
            fc = fi.getChannel();
            byteBuffer.clear();
            fc.read(byteBuffer);
            byteBuffer.flip();
            System.out.println("Use charBuffer:" + byteBuffer.asCharBuffer());
            fc.close();
            fi.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String byteBuffer2String(ByteBuffer byterBuffer) {
        String content = null;
        String charSetString = System.getProperty("file.encoding");
        Charset charSet = Charset.forName(charSetString);
        CharsetDecoder decoder = charSet.newDecoder();
        try {
            CharBuffer charBuffer = decoder.decode(byterBuffer);
            content = charBuffer.toString();
        } catch (CharacterCodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Decoding using " + charSet + ":" + content);
        return content;
    }
}
