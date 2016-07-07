package com.jdk.thread.consume;

import com.jdk.thread.consume.product.Product;

import java.util.concurrent.Callable;

/**
 * Created by a549238 on 6/15/2016.
 */
public class Consumer implements Callable<Boolean> {

    private Product product;
    private int consumeSize;

    public Consumer(Product product) {
        this.product = product;
    }

    public void setConsumeSize(int consumeSize) {
        this.consumeSize = consumeSize;
    }

    @Override
    public Boolean call() throws Exception {
        product.consume(consumeSize);
        return true;
    }
}
