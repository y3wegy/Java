package com.jdk.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA. User: a549238 Date: 3/8/13 Time: 10:43 AM To
 * change this template use File | Settings | File Templates.
 */
public class SocketClient {

    private final String desIP = "127.0.0.1";
    private final String desPort = "8081";

    public static void main(String[] args) {
        SocketClient demo = new SocketClient();
        demo.chat();
    }

    private void chat() {
        try {
            Socket socket = new Socket(desIP, Integer.parseInt(desPort));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            out.println("Start");
            while (true) {
                if (bufferedReader.ready()) {
                    String in = bufferedReader.readLine();
                    System.out.println(in);
                    BufferedReader sayto = new BufferedReader(
                            new InputStreamReader(System.in));
                    out.println(sayto.readLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
