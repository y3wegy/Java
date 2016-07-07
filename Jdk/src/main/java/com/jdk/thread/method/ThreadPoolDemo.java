package com.jdk.thread.method;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/25/13
 * Time: 4:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadPoolDemo {
    private static final int POOL_SIZE = 1;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE, new DaemonThreadFactory());
        for (int i = 0; i < POOL_SIZE; i++) {
            executorService.execute(new RunDemo());
        }
        executorService.shutdown();

      /*  try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }*/
        /*executorService = Executors.newFixedThreadPool(10);
        for(int i =0;i<10;i++)
        {
            executorService.execute(new RunDemo());
        }
        executorService.shutdown();*/
    }
}

class RunDemo implements Runnable {

    @Override
    public void run() {
        //To change body of implemented methods use File | Settings | File Templates.
        try {
            System.out.println(Thread.currentThread().getName() + " start running!");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " Exception ");
        } finally {
            System.out.println(Thread.currentThread().getName() + " run  in finally");
        }
    }
}