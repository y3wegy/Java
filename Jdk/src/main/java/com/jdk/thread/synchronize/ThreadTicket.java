package com.jdk.thread.synchronize;


import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 4/2/13
 * Time: 3:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadTicket {
    @Test
    public void testSyncClassThread() throws Exception {
        Ticket ticket = new Ticket();
        SyncClassThread syncClassThread = new SyncClassThread(ticket);
        SyncClassThread syncClassThread1 = new SyncClassThread(ticket);
        SyncClassThread syncClassThread2 = new SyncClassThread(ticket);
        syncClassThread.start();
        syncClassThread1.start();
        syncClassThread2.start();

        syncClassThread.join();
        syncClassThread1.join();
        syncClassThread2.join();
    }

    @Test
    public void testSyncMethodThread() throws Exception {
        Ticket ticket = new Ticket();
        SyncMethodThread syncMethodThread = new SyncMethodThread(ticket);
        SyncMethodThread syncMethodThread1 = new SyncMethodThread(ticket);
        SyncMethodThread syncMethodThread2 = new SyncMethodThread(ticket);
        syncMethodThread.start();
        syncMethodThread1.start();
        syncMethodThread2.start();

        syncMethodThread.join();
        syncMethodThread1.join();
        syncMethodThread2.join();
    }
}

class SyncClassThread extends Thread {

    private final Ticket ticket;

    public SyncClassThread(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {

        while (ticket.getCnt() > 0) {
            synchronized (ticket.getClass()) {
                if (ticket.getCnt() > 0) {
                    ticket.show();
                    System.out.println(Thread.currentThread().getName() + "  is selling!");
                    ticket.sell();
                }
            }
            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SyncMethodThread extends Thread {
    private final Ticket ticket;

    public SyncMethodThread(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (ticket.getCnt() > 0) {
            sell();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void sell() {
        ticket.show();
        System.out.println(Thread.currentThread().getName() + "  is selling!");
        ticket.sell();
    }
}

class Ticket {
    private int cnt = 100;

    public void show() {
        System.out.println(this.cnt);
    }

    public int getCnt() {
        return this.cnt;
    }

    public void sell() {
        //show();
        this.cnt--;
    }
}