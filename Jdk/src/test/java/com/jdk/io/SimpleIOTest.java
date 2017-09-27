package com.jdk.io;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA. User: bokee Date: 12-10-9 Time:
 * change this template use File | Settings | File Templates.
 */
public class SimpleIOTest {
    private static final Logger logger = Logger.getLogger(SimpleIOTest.class);

    private static final String FILE_PATH = SimpleIOTest.class.getClassLoader().getResource("data.txt").getPath();
    private static final String OUT_PATH = IORedirectingTest.class.getClassLoader().getResource("out.txt").getFile();

    /**
     * console
     */
    @Test
    public void testConsole() {
        BufferedReader reader = null;
        try {
            String readerstr = null;
            reader = new BufferedReader(new InputStreamReader(
                    System.in));
            while ((readerstr = reader.readLine()) != null && readerstr.equalsIgnoreCase(":wq")) {
                logger.info(readerstr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(reader);
        }
    }

    /**
     * accept input from console
     *
     * @throws Exception
     */
    @Test
    public void testScanner() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input UserName:");
        String name = sc.nextLine();
        System.out.println("Please input Age:");
        int age = sc.nextInt();
        System.out.println("Please input Salary:");
        float salary = sc.nextFloat();
        System.out.println("Your Info:");
        System.out.println("UserName：" + name + "\n" + "Age：" + age + "\n" + "Salary：" + salary);
    }

    /**
     * StringReader
     */
    @Test
    public void testStringReader() {
        String str = "stringIO:";
        StringReader stringReader = new StringReader(str);
        BufferedReader bufferedReader = new BufferedReader(stringReader);
        try {
            while ((str = bufferedReader.readLine()) != null)
                logger.info(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(bufferedReader);
            IOUtils.closeQuietly(stringReader);
        }
    }

    /**
     *
     */
    @Test
    public void readFileByReader() {
        String buffer = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(FILE_PATH));
            while (null != (buffer = reader.readLine()))
                logger.info(buffer);
        } catch (FileNotFoundException e) {
            logger.info(String.format("% not found", FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(reader);
        }
    }

    /**
     *
     */
    @Test
    public void readFileStreamReader() {
        BufferedReader bufferedReader = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream); //
            bufferedReader = new BufferedReader(inputStreamReader);
            String buffer = null;
            while (null != (buffer = bufferedReader.readLine()))
                logger.info(buffer);
        } catch (FileNotFoundException e) {
            logger.info("File 'data.ini' not found");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(bufferedReader);
        }
    }

    /**
     *
     */
    @Test
    public void testFileWriter() {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(OUT_PATH, true));
            bufferedWriter.write("SB");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
        }

    }

    /**
     * bufferedWriter
     */
    @Test
    public void consoleBufferWrite() {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(System.out));
            bufferedWriter.write("OutTest:");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
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
