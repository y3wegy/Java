package com.jdk.io;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * Created by Chen,Rui on 9/11/2017.
 */
public class IORedirectingTest {
    private static final String FILE_PATH = IORedirectingTest.class.getClassLoader().getResource("data.txt").getFile();
    private static final String OUT_PATH = IORedirectingTest.class.getClassLoader().getResource("out.txt").getFile();

    @Test
    public void testRecirect() {
        PrintStream console = System.out;
        PrintStream outPrintStream = null;
        BufferedReader bufferedReader = null;
        InputStream fileInputStream = null;
        try {
            String temp;
            fileInputStream = new FileInputStream(FILE_PATH);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            outPrintStream = new PrintStream(new FileOutputStream(OUT_PATH));
            System.setIn(bufferedInputStream);
            System.setOut(outPrintStream);
            //System.setErr(outPrintStream);
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while ((temp = bufferedReader.readLine()) != null)
                System.out.println(temp);
            System.out.println("Chen,Rui");
            System.setOut(console);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(fileInputStream);
            IOUtils.closeQuietly(outPrintStream);
        }
    }

    @Before
    public void clean() {
        File file = new File(OUT_PATH);
        if (file.exists())
            file.delete();
    }
}