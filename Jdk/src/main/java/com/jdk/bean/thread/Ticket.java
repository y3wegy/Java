package com.jdk.bean.thread;

import org.apache.log4j.Logger;

public class Ticket {
    private static final Logger logger = Logger.getLogger(Ticket.class);
    private int cnt = 100;

    public void show() {
        logger.info(this.cnt);
    }

    public int getCnt() {
        return this.cnt;
    }

    public void sell() {
        this.cnt--;
    }
}