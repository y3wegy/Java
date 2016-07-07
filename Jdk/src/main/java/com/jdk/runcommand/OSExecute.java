package com.jdk.runcommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/5/13
 * Time: 3:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class OSExecute {
    public static void command(String command) {
        boolean err = false;
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = bufferedReader.readLine()) != null)
                System.out.println(s);
            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((s = errors.readLine()) != null) {
                System.err.println(s);
                err = true;
            }
        } catch (IOException e) {
            //e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            if (!command.startsWith("CMD /C"))
                command("CMD /C " + command);
            else
                throw new RuntimeException(e);
        }
        if (err)
            throw new OSExecuteException("Errors executing :" + command);
    }

    public static void main(String[] args) {
        String strIn = "";

        while (true) {
            BufferedReader sayto = new BufferedReader(new InputStreamReader(System.in));
            try {
                strIn = sayto.readLine().toUpperCase();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            if ("EXIT".equals(strIn))
                break;
            command(strIn);

        }

    }
}
