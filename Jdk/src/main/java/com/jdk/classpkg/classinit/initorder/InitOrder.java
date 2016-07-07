package com.jdk.classpkg.classinit.initorder;

import org.junit.Test;

/**
 * Created by a549238 on 5/2/14.
 */
public class InitOrder {
    @Test
    public void testOrder() {
        Derived demo = new Derived();

        System.out.println(demo.value);
    }
}

class Base {
    public Base() {
        preProcess();
    }

    void preProcess() {
    }

}

class Derived extends Base {
    public String value = "set when declared ";

    @Override
    public void preProcess() {
        value = "set in preProcess";
    }
}
