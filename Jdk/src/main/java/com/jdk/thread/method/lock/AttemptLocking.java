package com.jdk.thread.method.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/30/13
 * Time: 11:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        final AttemptLocking attemptLocking = new AttemptLocking();
        attemptLocking.time();
        attemptLocking.unTime();

        new Thread() {
            {
                setDaemon(true);
            }

            @Override
            public void run() {
                attemptLocking.lock.lock();
                System.out.println("captured");
            }


        }.start();

        Thread.yield();
        attemptLocking.time();
        attemptLocking.unTime();
    }

    public void unTime() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock():" + captured);
        } finally {
            if (captured)
                lock.unlock();
        }
    }

    public void time() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);

            System.out.println("lock.tryLock(2,TimeUnit.SECONDS):" + captured);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            if (captured)
                lock.unlock();
        }
    }
}
