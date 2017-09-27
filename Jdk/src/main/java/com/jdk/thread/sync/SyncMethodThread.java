package com.jdk.thread.sync;

import com.jdk.bean.thread.Ticket;
import org.apache.log4j.Logger;

public class SyncMethodThread extends Thread {
    private static final Logger logger = Logger.getLogger(SyncClassThread.class);
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
                logger.error(e);
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized void sell() {
        ticket.show();
        logger.info(Thread.currentThread().getName() + "  is selling!");
        ticket.sell();
    }
}