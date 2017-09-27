package com.jdk.socket;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA. User: Rui Date: 3/8/13 Time: 10:43 AM To
 * change this template use File | Settings | File Templates.
 */
public class SocketClient {

    private static final Logger logger = Logger.getLogger(SocketClient.class);
    private static final String desIP = "127.0.0.1";
    private static final String desPort = "8081";

    public static void main(String[] args) {
        SocketClient demo = new SocketClient();
        demo.chat();
    }

    private void chat() {
        Socket socket = null;
        try {
            socket = new Socket(desIP, Integer.parseInt(desPort));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            out.println("Start");
            while (true) {
                if (bufferedReader.ready()) {
                    String in = bufferedReader.readLine();
                    logger.info(in);
                    BufferedReader sayto = new BufferedReader(
                            new InputStreamReader(System.in));
                    out.println(sayto.readLine());
                }
            }
        } catch (IOException e) {
            logger.error(e);
        } finally {
            IOUtils.closeQuietly(socket);
        }
    }
}
