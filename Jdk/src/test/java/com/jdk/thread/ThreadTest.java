package com.jdk.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by a549238 on 1/10/2017.
 */
public class ThreadTest {

    @Test
    public void testBlock() throws Exception {
        ExecutorService executor = null;
        try {
            executor = Executors.newFixedThreadPool(1);

            List<Future<Boolean>> list = new ArrayList<Future<Boolean>>();
            int index = 1;
            while (index++ < 10) {
                list.add(executor.submit(new Called(index)));
            }

            for (Future<Boolean> future : list) {
                future.get();
            }
            System.out.println("end");
        } finally {
            executor.shutdown();
        }
    }
}


class  Called implements Callable<Boolean> {
    private final int index;

    public Called(int index){
        this.index = index;
    }
    public Boolean call(){
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+":"+index);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}