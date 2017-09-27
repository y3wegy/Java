package com.jdk.thread.sync;

import com.jdk.bean.thread.Ticket;
import org.apache.log4j.Logger;

public class SyncClassThread extends Thread {
    private static final Logger logger = Logger.getLogger(SyncClassThread.class);
    private final Ticket ticket;

    public SyncClassThread(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (ticket.getCnt() > 0) {
            synchronized (Ticket.class) {
                if (ticket.getCnt() > 0) {
                    ticket.show();
                    logger.info(Thread.currentThread().getName() + "  is selling!");
                    ticket.sell();
                }
            }
            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                logger.error(e);
                Thread.currentThread().interrupt();
            }
        }
    }
}