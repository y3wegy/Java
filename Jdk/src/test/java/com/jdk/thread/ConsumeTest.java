package com.jdk.thread;

import com.jdk.bean.sync.AwaitProduct;
import com.jdk.bean.sync.Product;
import com.jdk.bean.sync.WaitProduct;
import com.jdk.thread.consume.Consumer;
import com.jdk.thread.consume.Producer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Rui on 6/16/2016.
 */
public class ConsumeTest {
    @Test
    public void testConsumeWait() {
        WaitProduct waitProduct = new WaitProduct();

        process(waitProduct);
    }

    @Test
    public void testAwait() {
        AwaitProduct awaitProduct = new AwaitProduct();

        process(awaitProduct);
    }

    private void process(Product product) {
        Producer producer1 = new Producer(product);
        producer1.setProduceNum(12);
        Producer producer2 = new Producer(product);
        producer2.setProduceNum(14);
        Producer producer3 = new Producer(product);
        producer3.setProduceNum(5);
        Producer producer4 = new Producer(product);
        producer4.setProduceNum(1);
        Producer producer5 = new Producer(product);
        producer5.setProduceNum(9);
        Producer producer6 = new Producer(product);
        producer6.setProduceNum(2);

        Consumer consumer1 = new Consumer(product);
        consumer1.setConsumeSize(3);
        Consumer consumer2 = new Consumer(product);
        consumer2.setConsumeSize(23);
        Consumer consumer3 = new Consumer(product);
        consumer3.setConsumeSize(5);
        Consumer consumer4 = new Consumer(product);
        consumer4.setConsumeSize(10);
        Consumer consumer5 = new Consumer(product);
        consumer5.setConsumeSize(2);

        ExecutorService executorService = Executors.newFixedThreadPool(8);
        List<Future<Boolean>> futureList = new ArrayList<Future<Boolean>>();

        futureList.add(executorService.submit(producer1));
        futureList.add(executorService.submit(consumer5));
        futureList.add(executorService.submit(producer2));
        futureList.add(executorService.submit(consumer2));
        futureList.add(executorService.submit(producer3));
        futureList.add(executorService.submit(producer4));
        futureList.add(executorService.submit(consumer3));
        futureList.add(executorService.submit(consumer4));
        futureList.add(executorService.submit(producer5));
        futureList.add(executorService.submit(producer6));
        futureList.add(executorService.submit(consumer1));


        for (Future<Boolean> item : futureList) {
            try {
                item.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}
