package com.jdk.thread;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 3/26/13
 * Time: 4:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadDemo {
    private int i;

    @Test
    public void testMulti() {
        Thread incdemo = new IncClass();
        Thread desdemo = new DesClass();   //ThreadDemo.new IncClass()
        incdemo.start();
        desdemo.start();

        try {
            //pause current main thread ,wait other thread complete
            desdemo.join();
            incdemo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void inc() {
        i++;
        System.out.println(Thread.currentThread().getName() + "-inc: " + i);
    }

    private void des() {
        i--;
        System.out.println(Thread.currentThread().getName() + "-des: " + i);
    }

    class IncClass extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 100; i++)
                inc();
        }
    }

    class DesClass extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 100; i++)
                des();
        }
    }
}
