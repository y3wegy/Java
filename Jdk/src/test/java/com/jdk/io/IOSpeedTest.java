package com.jdk.io;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

public class IOSpeedTest {

    private static final Logger logger = Logger.getLogger(IOSpeedTest.class);
    private static final int INT_SIZE = 1000000;
    private static final int BYTE_SIZE = INT_SIZE * 4;
    private static final int INT_BUFF_SIZE = 200000;

    private static final String FILE_PATH = IOSpeedTest.class.getClassLoader().getResource(".") + "out.txt";

    @Before
    public void setUp() throws IOException {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();

    }

    private static Tester[] tests = {
            new Tester("Stream Writer") {
                @Override
                public void test() throws IOException {
                    BufferedOutputStream out = null;
                    try {
                        out = new BufferedOutputStream(new FileOutputStream(FILE_PATH));
                        for (int i = 0; i < BYTE_SIZE; i++) {
                            out.write(i);
                        }
                    } finally {
                        IOUtils.closeQuietly(out);
                    }
                }
            },
            new Tester("Mapped Writer") {
                @Override
                public void test() throws IOException {
                    FileChannel fc = null;
                    try {
                        fc = new RandomAccessFile(FILE_PATH, "rw").getChannel();
                        IntBuffer intBuffer = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                        for (int i = 0; i < INT_SIZE; i++) {
                            intBuffer.put(i);
                        }
                    } finally {
                        if (fc != null) {
                            fc.close();
                        }
                    }
                }
            },
            new Tester("Channel Writer WithOut Mapped") {
                @Override
                public void test() throws IOException {
                    FileChannel fc = null;
                    try {
                        fc = new RandomAccessFile(FILE_PATH, "rw").getChannel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate((int) fc.size());
                        for (int i = 0; i < INT_SIZE; i++) {
                            byteBuffer.put("12".getBytes());
                        }
                        byteBuffer.flip();
                        fc.write(byteBuffer);
                    } finally {
                        if (fc != null) {
                            fc.close();
                        }
                    }
                }
            },
            new Tester("Stream Read") {
                @Override
                public void test() throws IOException {
                    DataInputStream in = null;
                    try {
                        in = new DataInputStream(new BufferedInputStream(new FileInputStream(FILE_PATH)));
                        for (int i = 0; i < INT_SIZE; i++)
                            in.readInt();
                    } finally {
                        IOUtils.closeQuietly(in);
                    }

                }
            },
            new Tester("Mapped Read") {
                @Override
                public void test() throws IOException {
                    FileChannel fc = null;
                    try {
                        fc = new FileInputStream(FILE_PATH).getChannel();
                        IntBuffer intBuffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();
                        while (intBuffer.hasRemaining())
                            intBuffer.get();
                    } finally {
                        if (fc != null) {
                            fc.close();
                        }
                    }
                }
            },
            new Tester("Stream Read/Write") {
                @Override
                public void test() throws IOException {
                    RandomAccessFile file = new RandomAccessFile(FILE_PATH, "rw");
                    file.writeInt(1);
                    for (int i = 0; i < INT_BUFF_SIZE; i++) {
                        file.seek(file.length() - 4);
                        file.writeInt(file.readInt());
                    }
                    file.close();
                }
            },
            new Tester("Mapped Read/write") {
                @Override
                public void test() throws IOException {
                    FileChannel fc = null;
                    try {
                        fc = new RandomAccessFile(FILE_PATH, "rw").getChannel();
                        IntBuffer intBuffer = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                        intBuffer.put(0);
                        for (int i = 1; i < INT_BUFF_SIZE; i++)
                            intBuffer.put(intBuffer.get(i - 1));
                    } finally {
                        if (fc != null) {
                            fc.close();
                        }
                    }
                }
            }
    };

    @Test
    public void testSpeed() {
        for (Tester tester : tests)
            tester.runTest();
    }

    private static abstract class Tester {
        private String name;

        public Tester(String name) {
            this.name = name;
        }

        public void runTest() {
            logger.info("name:" + name);
            long start = System.nanoTime();
            try {
                test();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            System.out.format("    %.2f \n", (System.nanoTime() - start) / 1.0e9);
        }

        public abstract void test() throws IOException;
    }
}