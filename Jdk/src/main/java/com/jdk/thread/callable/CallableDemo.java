package com.jdk.thread.callable;

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

    private static final int POOL_SIZE = 3;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);
        List<Future<String>> futureList = new ArrayList<Future<String>>();

        for (int i = 0; i < 5; i++)
            futureList.add(executorService.submit(new CallExecute(i)));

        executorService.shutdown();
        try {
            for (Future<String> future : futureList) {
                if (future.isDone())
                    System.out.println(future.get());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ExecutionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            executorService.shutdown();
        }
        System.out.println("End ");
    }
}

class CallExecute implements Callable<String> {
    private int id;

    public CallExecute(int id) {
        this.id = id;
    }

    @Override
    public String call() {
        Thread.yield();
        return " Thread is running, id :" + id;
    }
}

