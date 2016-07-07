package com.jdk.io.file;

import org.junit.Test;

import java.io.*;
import java.net.URL;

/**
 * Created with IntelliJ IDEA. User: bokee Date: 12-10-9 Time:
 * change this template use File | Settings | File Templates.
 */
public class IODemo {
    /**
     * console
     */
    @Test
    public void consoleIO() {
        System.out.println("console ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));

        try {
            String readerstr = null;
            while (!(readerstr = reader.readLine()).endsWith(":wq!")) {
                System.out.println(readerstr);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace(); // To change body of catch statement use File |
            // Settings | File Templates.
        }
        System.out.println("end console");
    }

    /**
     * StringReader
     */
    @Test
    public void stringIO() {
        String str = "stringIO:";
        StringReader stringReader = new StringReader(str); //
        BufferedReader bufferedReader = new BufferedReader(stringReader);
        String str2 = null;
        try {
            while ((str = bufferedReader.readLine()) != null)
                System.out.println(str);
            bufferedReader.close();
            stringReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    @Test
    public void readFileByReader() {
        String buffer = null;
        String path = IODemo.class.getClassLoader().getResource("data.ini").getPath();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while (null != (buffer = reader.readLine()))
                System.out.println(buffer);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File 'data.ini' not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    @Test
    public void readFileStreamReader() {
        String path = this.getClass().getClassLoader().getResource("data.ini").getPath();
        try {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(path));
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream); //
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String buffer = null;
            while (null != (buffer = bufferedReader.readLine()))
                System.out.println(buffer);
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File 'data.ini' not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    @Test
    public void testFileWriter() {
        BufferedWriter bufferedWriter = null;
        String path = null;
        try {
            URL url = this.getClass().getClassLoader().getResource("data2.ini");
            if (url == null) {
                path = this.getClass().getClassLoader().getResource(".").getPath() + "data2.ini";
                File file = new File(path);
                if (!file.exists())
                    file.createNewFile();
            }
            bufferedWriter = new BufferedWriter(new FileWriter(path, true));
            bufferedWriter.write("SB");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * bufferedWriter
     */
    @Test
    public void consoleBufferWrite() {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(System.out));
        try {
            bufferedWriter.write("OutTest:");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    @Test
    public void consoleStreamWrite() {
        PrintStream printStream = new PrintStream(System.out, true);
        printStream.println("OutTest2: ");
        printStream.close();

    }

    /**
     * printStream.close();
     */
    @Test
    public void consoleWrite() {
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println("OutTest3:");
        printWriter.flush();
        printWriter.close();
    }
}
