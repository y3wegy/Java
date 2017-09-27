package com.jdk.thread;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class AttemptLockTest {

    private static final Logger logger = Logger.getLogger(AttemptLockTest.class);
    private ReentrantLock lock = new ReentrantLock();

    @Test
    public void testLock() {
        final AttemptLockTest attemptLockTest = new AttemptLockTest();
        attemptLockTest.time();
        attemptLockTest.unTime();

        new Thread() {
            {
                setDaemon(true);
            }

            @Override
            public void run() {
                attemptLockTest.lock.lock();
                logger.info("captured");
            }
        }.start();

        Thread.yield();
        attemptLockTest.time();
        attemptLockTest.unTime();
    }

    public void unTime() {
        boolean captured = lock.tryLock();
        try {
            logger.info("tryLock():" + captured);
        } finally {
            if (captured)
                lock.unlock();
        }
    }

    public void time() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
            logger.info("lock.tryLock(2,TimeUnit.SECONDS):" + captured);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            if (captured)
                lock.unlock();
        }
    }
}
