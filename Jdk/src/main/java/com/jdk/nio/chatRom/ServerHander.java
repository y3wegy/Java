package com.jdk.nio.chatRom;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by a549238 on 3/18/14.
 */
public class ServerHander implements Runnable {

    private final static int port = 2345;
    String writeMsg;
    StringBuffer sb = new StringBuffer();
    SelectionKey sscKey;
    private boolean running;
    private Selector selector;

    public ServerHander() {
        running = true;
    }

    public static void main(String[] args) {
        ServerHander server = new ServerHander();
        new Thread(server).start();
    }

    public void init() {
        try {
            selector = Selector.open();
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.socket().bind(new InetSocketAddress(port));
            sscKey = ssc.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("Server is starting....." + new Date());

        } catch (Exception e) {
            Logger.getLogger(ServerHander.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void execute() {
        try {
            while (running) {
                int num = selector.select();
                if (num > 0) {

                    Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                    while (it.hasNext()) {
                        SelectionKey key = it.next();
                        it.remove();
                        if (!key.isValid())
                            continue;
                        if (key.isAcceptable()) {
                            System.out.println("isAcceptable");
                            getConn(key);
                        } else if (key.isReadable()) {
                            System.out.print("isReadable");
                            readMsg(key);
                        } else if (key.isValid() && key.isWritable()) {
                            if (writeMsg != null) {
                                System.out.print("isWritable");
                                writeMsg(key);
                            }
                        } else
                            break;
                    }
                }
                Thread.yield();
            }
        } catch (Exception e) {
            Logger.getLogger(ServerHander.class.getName()).log(Level.SEVERE,
                    null, e);
        }
    }

    private void getConn(SelectionKey key) throws IOException {
        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
        SocketChannel sc = ssc.accept();
        sc.configureBlocking(false);
        sc.register(selector, SelectionKey.OP_READ);
        System.out.print("build connection :"
                + sc.socket().getRemoteSocketAddress());
    }

    private void readMsg(SelectionKey key) throws IOException {
        sb.delete(0, sb.length());
        SocketChannel sc = (SocketChannel) key.channel();
        System.out.print(sc.socket().getRemoteSocketAddress() + " ");
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.clear();
        int len = 0;
        StringBuffer sb = new StringBuffer();
        while ((len = sc.read(buffer)) > 0) {
            buffer.flip();
            sb.append(new String(buffer.array(), 0, len));

        }
        if (sb.length() > 0) {
            System.out.println("get from client:" + sb.toString());
        }
        if (sb.toString().trim().toLowerCase().equals("quit")) {
            sc.write(ByteBuffer.wrap("Bye".getBytes()));
            System.out.print("client is closed " + sc.socket().getRemoteSocketAddress());
            key.cancel();
            sc.close();
            sc.socket().close();
        } else {
            String toMsg = sc.socket().getRemoteSocketAddress() + " said:" + sb.toString();
            System.out.print(toMsg);
            writeMsg = toMsg;
            Iterator<SelectionKey> it = key.selector().keys().iterator();
            while (it.hasNext()) {
                SelectionKey skey = it.next();
                if (skey != key && skey != sscKey) {
                    if (skey.attachment() != null) {
                        String str = (String) skey.attachment();
                        skey.attach(str + toMsg);
                    } else
                        skey.attach(toMsg);
                }
                skey.interestOps(skey.interestOps() | SelectionKey.OP_WRITE);
            }
        }
    }

    @Override
    public void run() {
        init();
        execute();
    }

    private void writeMsg(SelectionKey key) throws IOException {

        System.out.println("++++enter write+++");
        SocketChannel sc = (SocketChannel) key.channel();
        String str = (String) key.attachment();

        sc.write(ByteBuffer.wrap(str.getBytes()));
        key.interestOps(SelectionKey.OP_READ);
    }
}
