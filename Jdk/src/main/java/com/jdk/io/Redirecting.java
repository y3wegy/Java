package com.jdk.io;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/5/13
 * Time: 3:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class Redirecting {

    private static final String TEMP = "temp.out";

    public static void main(String[] args) {
        init();
        PrintStream console = System.out;
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("data.ini"));
            PrintStream out = new PrintStream(new FileOutputStream(TEMP));

            System.setIn(bufferedInputStream);
            System.setOut(out);
            System.setErr(out);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String temp = null;
            while ((temp = bufferedReader.readLine()) != null)
                System.out.println(temp);
            out.close();
            System.setOut(console);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    private static void init() {
        File file = new File(TEMP);
        if (file.exists())
            file.delete();
    }
}
