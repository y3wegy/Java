package com.jdk.thread.callable;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/26/13
 * Time: 2:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class CallableDemo {

    private static final Logger logger = LoggerFactory.getLogger(CallableDemo.class);
    private static final int POOL_SIZE = 3;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);
        List<Future<String>> futureList = new ArrayList<>();

        for (int i = 0; i < 5; i++)
            futureList.add(executorService.submit(new CallExecute(i)));

        executorService.shutdown();
        try {
            for (Future<String> future : futureList) {
                logger.info(future.get());
            }

        } catch (Exception e) {
           logger.error(e.toString());
        } finally {
            executorService.shutdown();
        }
        logger.info("End ");
    }
}

class CallExecute implements Callable<String> {
    private int id;

    public CallExecute(int id) {
        this.id = id;
    }

    @Override
    public String call() throws InterruptedException {
        Thread.yield();
        Thread.sleep(5000);
        return " Thread is running, id :" + id;
    }
}

