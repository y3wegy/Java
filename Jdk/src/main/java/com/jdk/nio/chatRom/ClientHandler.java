package com.jdk.nio.chatRom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by a549238 on 3/19/14.
 */
public class ClientHandler implements Runnable {
    private final static String address = "localhost";
    private final static int port = 2345;
    Selector selector;
    boolean running;
    SocketChannel sc;

    public ClientHandler() {
        running = true;
    }

    public static void main(String[] args) {
        ClientHandler clientHandler = new ClientHandler();
        new Thread(clientHandler).start();
    }

    public void init() {
        try {
            sc = SocketChannel.open();
            sc.configureBlocking(false);
            sc.connect(new InetSocketAddress(address, port));
        } catch (IOException e) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void execute() {
        int num = 0;
        try {
            while (!sc.finishConnect()) {

            }
        } catch (IOException e) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE,
                    null, e);
        }
        ReadKeyBoard readKeyBoard = new ReadKeyBoard();
        new Thread(readKeyBoard).start();
        while (running) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.clear();
            StringBuffer sb = new StringBuffer();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                while ((num = sc.read(buffer)) > 0) {
                    sb.append(new String(buffer.array(), 0, num));
                    buffer.clear();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (sb.length() > 0) {
                System.out.println(sb.toString());
            }

            if (sb.toString().toLowerCase().equals("bye")) {
                System.out.print("closed ......");

                try {
                    sc.close();
                    sc.socket().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                readKeyBoard.close();
                running = false;
            }
        }
    }

    @Override
    public void run() {
        init();
        execute();
    }

    class ReadKeyBoard implements Runnable {
        private boolean running2 = true;

        public ReadKeyBoard() {

        }

        public void close() {
            running2 = false;
        }

        @Override
        public void run() {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            while (running2) {
                try {
                    System.out.print("enter some command:");
                    String str = read.readLine();
                    sc.write(ByteBuffer.wrap(str.getBytes()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
