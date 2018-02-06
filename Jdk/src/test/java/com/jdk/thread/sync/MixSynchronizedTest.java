package com.jdk.thread.sync;

import org.junit.Test;

import static com.jdk.thread.sync.MixSynchronize.synchronizedStaticMethod;

/**
 * http://webcache.googleusercontent.com/search?q=cache:xwKoVgNOnRYJ:www.cnblogs.com/GnagWang/archive/2011/02/27/1966606.html+&cd=1&hl=en&ct=clnk&gl=us
 * each instance  has one lock
 * synchronized(this)  =synchronized method
 * synchronized(class) = synchronized static
 * Created by Rui on 12/4/2015.
 */
public class MixSynchronizedTest {

    @Test
    public void testNoBlock() {
        final MixSynchronize synchronizedThis = new MixSynchronize();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedThis.synchronizedMethod();
            }
        }, "T1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedThis.nonSychronizedMethod();
            }
        }, "T2");
        t1.start();
        t2.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Synchronized (this ) will block Synchronized method
     */
    @Test
    public void testSynchronizedMethodAndSynchronzedThisBlock() {
        final MixSynchronize mixSynchronize = new MixSynchronize();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mixSynchronize.synchronizedMethod();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                mixSynchronize.synchronizedThisMthod();
            }
        });
        t1.start();
        t2.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Synchronized method will block each other
     */
    @Test
    public void testSynchronziedMethodBlock() {
        final MixSynchronize mixSynchronize = new MixSynchronize();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mixSynchronize.synchronizedMethod();
            }
        }, "T1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                mixSynchronize.synchronizedMethod2();
            }
        }, "T2");
        t1.start();
        t2.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * class has one lock ,each instance has one lock
     * synchronized static  = synchronized (class),which will block each other
     *
     * @throws Exception
     */
    @Test
    public void testSynchronizedClassAndStaticMethodBlock() throws Exception {
        final MixSynchronize mixSynchronize = new MixSynchronize();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mixSynchronize.synchronizedClass();
            }
        }, "T1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronizedStaticMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T2");
        t1.start();
        t2.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
