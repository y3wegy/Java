package com.jdk.thread.consume;

import com.jdk.bean.sync.Product;
import com.jdk.bean.sync.WaitProduct;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by Rui on 6/8/2016.
 */
public class Producer implements Callable<Boolean> {


    private Product product;

    private int produceNum;

    public Producer(Product product) {
        this.product = product;
    }

    public void setProduct(WaitProduct product) {
        this.product = product;
    }

    public void setProduceNum(int produceNum) {
        this.produceNum = produceNum;
    }

    @Override
    public Boolean call() throws Exception {

        List<Object> objects = new LinkedList<>();
        objects.addAll(Collections.nCopies(produceNum, new Object()));
        this.product.produce(objects);
        return true;
    }
}
