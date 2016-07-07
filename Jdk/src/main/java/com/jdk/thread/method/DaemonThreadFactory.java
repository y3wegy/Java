package com.jdk.thread.method;

import java.util.concurrent.ThreadFactory;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/27/13
 * Time: 10:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
