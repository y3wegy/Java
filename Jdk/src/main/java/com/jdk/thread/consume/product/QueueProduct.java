package com.jdk.thread.consume.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by a549238 on 6/16/2016.
 */
public class QueueProduct implements Product {

    private static final Logger logger = LoggerFactory.getLogger(QueueProduct.class);
    private static final int MAX_SIZE = 100;
    private LinkedBlockingDeque<Object> queue = new LinkedBlockingDeque<Object>(MAX_SIZE);

    @Override
    public void produce(List<Object> products) {
        if (queue.size() == MAX_SIZE) {
            logger.info("Queue is full,size:" + MAX_SIZE + ",can not produce");
        }

        for (int i = 0; i < products.size(); i++) {
            queue.add(products.get(i));
            logger.info("Now Capacity :" + queue.size());
        }
    }

    @Override
    public void consume(int size) {
        if (queue.size() == 0) {
            logger.info("Capacity is zero,can not consume!");
        }


        for (int i = 0; i < size; i++) {
            try {
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        logger.info("After consume, Capacity:" + queue.size());
    }
}
