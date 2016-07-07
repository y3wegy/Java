package com.jdk.classpkg;

import org.junit.Test;

/**
 * Created by a549238 on 11/13/2015.
 */
public class thisClass {
    @Test
    public void testThis() {
        Child child = new Child();
        child.visit();
    }
}

class Father {
    public void visit() {
        System.out.println(this.getClass().getName());
    }
}

class Child extends Father {

}
