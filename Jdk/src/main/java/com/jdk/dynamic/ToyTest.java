package com.jdk.dynamic;

interface A {
}

interface B {
}

interface C {
}

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/11/13
 * Time: 2:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class ToyTest {
    private static void printInfo(Class clazz) {
        System.out.println("class name:" + clazz.getName()
                + "\nis interface[" + clazz.isInterface()
                + "]\ncanonical name:" + clazz.getCanonicalName());
    }

    public static void main(String[] args) {
        Class clazz = FancyToy.class;
        printInfo(clazz);

        System.out.println("++++++++++++++++++++");
        for (Class interfaceClazz : clazz.getInterfaces())
            printInfo(interfaceClazz);
        System.out.println("++++++++++++++++++++++++++++++++++++");
        printInfo(clazz.getSuperclass());

        System.out.println("create new instance");
        try {
            Object obj = clazz.newInstance();  //return an object not  toy??????????
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}

class Toy {
    Toy() {
    }

    Toy(int x) {
    }
}

class FancyToy extends Toy implements A, B, C {
    FancyToy() {
        super(1);
    }

    FancyToy(int x) {
        super(1);
    }
}
