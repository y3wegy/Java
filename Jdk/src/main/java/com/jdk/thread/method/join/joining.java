package com.jdk.thread.method.join;

/**
 *
 * The join method allows one thread to wait for the completion of another. If t is a Thread object whose thread is currently executing
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/27/13
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 * <p/>
 * diff  of join and yield :
 * yield:  release current thread  CPU resource ,then this  thread will compete CPU resource immediately
 * join:  pause main thread ,wait called thread  complete, then execute next step
 */
public class joining {
    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("Sleepy", 1000);
        Sleeper gray = new Sleeper("gray", 1000);

        Joiner deop = new Joiner("deop", sleepy);
        Joiner doc = new Joiner("doc ", gray);

        gray.interrupt();


       /*
         output :
             doc  join completed
            Sleepy has awakened
            deop join completed
        */
    }
}

class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " is Interrupted. isInterrupted():" + isInterrupted());    //false ; interrupted status will be  clean up When  sleep wait and  join
            return;
        }
        System.out.println(getName() + " has awakened");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}