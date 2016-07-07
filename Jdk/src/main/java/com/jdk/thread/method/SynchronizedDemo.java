package com.jdk.thread.method;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/30/13
 * Time: 10:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class SynchronizedDemo {
    /*
    only can access one method  at a time if an object has synchronized method
     */
    public static void main(String[] args) {
        SynchronizedMethod synchronizedMethod = new SynchronizedMethod();
        //synchronizedMethod.IncreaceValue();
        for (int i = 0; i < 6; i++) {
            Thread increaseThread = new Thread(new IncreaseThread(synchronizedMethod));
            increaseThread.start();
        }
        for (int i = 0; i < 6; i++) {
            Thread reduceThread = new Thread(new ReduceThread(synchronizedMethod));
            reduceThread.start();
        }

    }
}

class IncreaseThread implements Runnable {
    private SynchronizedMethod synchronizedMethod;

    public IncreaseThread(SynchronizedMethod synchronizedMethod) {
        this.synchronizedMethod = synchronizedMethod;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++)
            synchronizedMethod.IncreaceValue();
    }
}

class ReduceThread implements Runnable {
    private SynchronizedMethod synchronizedMethod;

    public ReduceThread(SynchronizedMethod synchronizedMethod) {
        this.synchronizedMethod = synchronizedMethod;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++)
            synchronizedMethod.reduceValue();
    }
}

class SynchronizedMethod {
    public int a = 3;

    public synchronized int IncreaceValue() {
        System.out.println("Enter IncreaceValue");
        ++a;
        System.out.println("After IncreaceValue,a:" + a);
        return a;
    }

    public synchronized int reduceValue() {
        System.out.println("Enter ReduceValue");
        --a;
        System.out.println("After ReduceValue,a:" + a);
        return a;
    }
}
