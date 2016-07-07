package com.jdk.thread.method;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/26/13
 * Time: 11:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadExecute());
        thread.start();
        thread.interrupt();
    }
}

class ThreadExecute implements Runnable {

    @Override
    public void run() {
        //To change body of implemented methods use File | Settings | File Templates.
        for (int i = 0; i < 10000; i++)
            System.out.println("id:" + i + ", 123          ");
        //Thread.yield();
    }
}