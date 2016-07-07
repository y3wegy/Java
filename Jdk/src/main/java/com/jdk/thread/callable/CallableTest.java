package com.jdk.thread.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableTest {

    private static final int POOL_SIZE = 4;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(POOL_SIZE, new MyThreadFactory());
        List<Future<String>> futureList = new ArrayList<Future<String>>();
        for (int i = 0; i < 9; i++) {
            futureList.add(service.submit(new ExeHandler(i + "~~~~~")));
        }
        service.shutdown();
        for (Future<String> item : futureList) {
            if (item.isDone())
                try {
                    System.out.println(item.get());
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        System.out.println("End ");

    }


}

class ExeHandler implements Callable<String> {

    private String message = null;

    public ExeHandler(String message) {
        this.message = message;
    }

    @Override
    public String call() throws Exception {
        Thread.yield();
        return Thread.currentThread().getName() + ":" + message;
    }

}

class MyThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        //thread.setDaemon(true);
        return thread;
    }

}
