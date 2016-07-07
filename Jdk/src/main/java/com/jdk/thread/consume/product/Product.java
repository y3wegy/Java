package com.jdk.thread.consume.product;

import java.util.List;

/**
 * Created by a549238 on 6/16/2016.
 */
public interface Product {

    public void produce(List<Object> products);

    public void consume(int size);
}
