package com.jdk.thread.method;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA. User: a549238 Date: 12/26/13 Time: 5:12 PM To
 * change this template use File | Settings | File Templates.
 */
public class DaemonDemo implements Runnable {

    public static void main(String[] args) {
        Thread daemon = new Thread(new DaemonDemo());
        daemon.setDaemon(true);
        daemon.start();
        try {
            TimeUnit.MILLISECONDS.sleep(200);
            System.out.println("System exit");
        } catch (InterruptedException e) {
            e.printStackTrace(); // To change body of catch statement use File |
            // Settings | File Templates.
        }
    }

    @Override
    public void run() {
        final int threadSize = 12;
        Thread[] threads = new Thread[threadSize];
        for (int i = 0; i < threadSize; i++) {
            threads[i] = new Thread(new DaemonSpawn());
            if (i / 2 == 0)
                threads[i].setDaemon(false);
            threads[i].start();

        }

        for (int i = 0; i < threadSize; i++)
            System.out.println(Thread.currentThread().getName() + "-> Threads["
                    + i + "].isDaemon():" + threads[i].isDaemon());
        /*
         * if thread is daemon ,then the subthread is also daemon as default
		 */
    }
}

class DaemonSpawn implements Runnable {

    private int i = 0;

    @Override
    public void run() {
        while (i++ < 100) {
            Thread.yield();
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
