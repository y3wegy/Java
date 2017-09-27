package com.jdk.thread.sync;


import com.jdk.bean.thread.Ticket;
import com.jdk.thread.sync.SyncClassThread;
import com.jdk.thread.sync.SyncMethodThread;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Rui
 * Date: 4/2/13
 * Time: 3:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadTicketTest {
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

