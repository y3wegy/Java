package com.jdk.runcommand;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class OSExecuteTest {
    @Test
    public void testCommand() {
        String strIn = "";
        while (true) {
            BufferedReader sayto = new BufferedReader(new InputStreamReader(System.in));
            try {
                strIn = sayto.readLine().toUpperCase();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            if ("EXIT".equals(strIn))
                break;
            command(strIn);
        }

    }

    public void command(String command) {
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
            if (!command.startsWith("CMD /C"))
                command("CMD /C " + command);
            else
                throw new RuntimeException(e);
        }
        if (err)
            throw new OSExecuteException("Errors executing :" + command);
    }
}

class OSExecuteException extends RuntimeException {
    public OSExecuteException(String why) {
        super(why);
    }
}