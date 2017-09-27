package com.jdk.bean.sync;

import java.util.List;

/**
 * Created by Rui on 6/16/2016.
 */
public interface Product {

    public void produce(List<Object> products) throws InterruptedException;

    public void consume(int size) throws InterruptedException;
}
