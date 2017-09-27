package com.jdk.thread.sync;

/**
 * http://webcache.googleusercontent.com/search?q=cache:xwKoVgNOnRYJ:www.cnblogs.com/GnagWang/archive/2011/02/27/1966606.html+&cd=1&hl=en&ct=clnk&gl=us
 * each instance  has one lock
 * class has only one lock
 * synchronized(this)  = synchronized method
 * synchronized(class) = synchronized static
 */
public class MixSynchronize {

    public static synchronized void synchronizedStaticMethod() throws InterruptedException {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            Thread.sleep(100);
        }
    }

    public void nonSychronizedMethod() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void synchronizedThisMthod() {
        synchronized (this) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void synchronizedMethod() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void synchronizedMethod2() {

        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void synchronizedClass() {
        synchronized (MixSynchronize.class) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
