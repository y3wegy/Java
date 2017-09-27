package com.jdk.thread;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Date: 4/1/13
 * Time: 10:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadLocalTest {

    @Test
    public void testThreadLocal() {
        ThreadLocal<AnObject> objectThreadLocal = new ThreadLocal<AnObject>() {
            public AnObject initValue() {
                return new AnObject();
            }
        };
        AnObject anobject = new AnObject();
        anobject.s = Thread.currentThread().getName();
        objectThreadLocal.set(anobject);
        System.out.println("Main Thread[" + Thread.currentThread().getName() + "]---Value[" + objectThreadLocal.get().s + "]");
        TestThread t1 = new TestThread(objectThreadLocal, anobject);
        t1.start();
        TestThread t2 = new TestThread(objectThreadLocal, anobject);
        t2.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println("Main Thread[" + Thread.currentThread().getName() + "] objectThreadLocal.get().s:[" + objectThreadLocal.get().s + "]");
    }

    @Test
    public void testNewThreadLocal() throws Exception {
        ThreadLocal<AnObject> objectThreadLocal = new ThreadLocal<AnObject>() {
            public AnObject initValue() {
                return new AnObject();
            }
        };
        AnObject anobject = new AnObject();
        anobject.s = Thread.currentThread().getName();
        objectThreadLocal.set(anobject);
        System.out.println("Main Thread[" + Thread.currentThread().getName() + "]---Value[" + objectThreadLocal.get().s + "]");
        TestThread t1 = new TestThread();
        t1.start();
        TestThread t2 = new TestThread();
        t2.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println("Main Thread[" + Thread.currentThread().getName() + "] objectThreadLocal.get().s:[" + objectThreadLocal.get().s + "]");
    }
}

class TestThread extends Thread {
    private AnObject anObject;
    private ThreadLocal<AnObject> threadLocalt;

    public TestThread(ThreadLocal threadLocal, AnObject anObject) {
        this.threadLocalt = threadLocal;
        this.anObject = anObject;
        this.anObject.s = this.getName();
        System.out.println("TestThread [" + Thread.currentThread().getName() + "]---[" + this.getName() + "]");
    }

    public TestThread() {
        anObject = new AnObject();
        anObject.s = this.getName();
        threadLocalt = new ThreadLocal<AnObject>();
        threadLocalt.set(anObject);
        System.out.println("TestThread [" + Thread.currentThread().getName() + "]---[" + this.getName() + "]");
    }

    @Override
    public void run() {
        this.threadLocalt.set(this.anObject);
        System.out.println("TestThread run[" + Thread.currentThread().getName() + "]---Value[" + threadLocalt.get().s + "]");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println("TestThread run after[" + Thread.currentThread().getName() + "]---Value[" + threadLocalt.get().s + "]");
    }
}

class AnObject extends Object {
    public String s = "asd";
}