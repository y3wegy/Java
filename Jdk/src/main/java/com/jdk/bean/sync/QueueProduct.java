package com.jdk.bean.sync;

import org.apache.log4j.Logger;

import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Rui on 6/16/2016.
 */
public class QueueProduct implements Product {

    private static final Logger logger = Logger.getLogger(QueueProduct.class);
    private static final int MAX_SIZE = 100;
    private LinkedBlockingDeque<Object> queue = new LinkedBlockingDeque<>(MAX_SIZE);

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
        if (queue.isEmpty()) {
            logger.info("Capacity is zero,can not consume!");
        }


        for (int i = 0; i < size; i++) {
            try {
                queue.take();
            } catch (InterruptedException e) {
                logger.error(e);
                Thread.currentThread().interrupt();
            }
        }
        logger.info("After consume, Capacity:" + queue.size());
    }
}
