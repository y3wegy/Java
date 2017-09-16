package com.jdk.thread.consume.product;


import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by a549238 on 6/8/2016.
 */
public class WaitProduct implements Product {

    private static final Logger logger = Logger.getLogger(WaitProduct.class);

    private static final int MAX_SIZE = 100;

    private LinkedList<Object> prodList = new LinkedList<Object>();

    public static int getMaxSize() {
        return MAX_SIZE;
    }

    public void produce(List<Object> objects) {
        if (objects == null)
            return;
        synchronized (prodList) {
            while (prodList.size() + objects.size() > MAX_SIZE) {
                logger.info("Current capacity:" + prodList.size() + "/t; produce capacity:" + objects.size() + ", so can not produce");
                try {
                    prodList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            prodList.addAll(objects);
            logger.info("Produce :" + objects.size() + ";Current Capacity:" + prodList.size());
            prodList.notifyAll();
        }
    }

    public void consume(int size) {
        if (size < 1) {
            logger.info("want consume size:" + size + ";can not do it!!!");
        }

        synchronized (prodList) {
            while (prodList.size() - size < 0) {
                logger.info("Current Capacity :" + prodList.size() + ",but want to sonsume " + size + ",need wait.");
                try {
                    prodList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < size; i++) {
                prodList.remove();
            }
            logger.info("Consume " + size + "; After consume Capacity:" + prodList.size());
            prodList.notifyAll();
        }

    }

    public List<Object> getProdList() {
        return prodList;
    }

}
