package com.jdk.classpkg.classinit.innerclass;

import org.junit.Test;

public class InnerClassDemo {

    @Test
    public void testInnerClass() {
        Outter out = new Outter();
        Outter.InnerClass inner = out.new InnerClass();
        inner.doMyself();
        System.out.println(inner.getClass().getResource(""));
    }

}

class Outter {
    class InnerClass {
        public void doMyself() {
            System.out.print("print in InnerClass");
        }
    }

}
