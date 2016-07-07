package com.jdk.thread.method.interrupt;

import java.util.Timer;
import java.util.TimerTask;

public class InterruptedDemo {

    public static void main(String[] args) {
        final Stopable stop = new Stopable();
        stop.start();
        new Timer(true).schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("Requesting Interrupt");
                        stop.interrupt();//just set interrupt status to true,not really interrupt
                        System.out.println("in timer stopable.isInterrupted()" + stop.isInterrupted());
                    }
                }, 50);
    }

}

class Stopable extends Thread {
    private int counter = 0;

    @Override
    public void run() {
        boolean done = false;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (counter < 1000 && !done) {
            System.out.println(counter++);
            System.out.println("in thread stopable,isinterrupted()" + isInterrupted());
            if (Thread.interrupted() == true) {
                try {
                    System.out.println("in thread after Thread.interrupted()" + isInterrupted());
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
