package com.jdk.generic.bound;

/**
 * Created with IntelliJ IDEA.
 * User: Rui
 * Date: 12/23/13
 * Time: 5:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Selfbounded<T extends Selfbounded<T>> {
    T element;

    Selfbounded<T> set(T arg) {
        element = arg;
        return this;
    }

    T get() {
        return element;
    }
}

class A extends Selfbounded<A> {
}

class B extends Selfbounded<A> {
}

class C extends Selfbounded<C> {
    C setAndGet(C arg) {
        set(arg);
        return get();
    }
}

class D {
}

// class E extends  Selfbounded<D>{}   // D is not in the bound

class F extends Selfbounded {
}

class SelfBounding {
    public static void main(String[] args) {
        A a = new A();
        a.set(new A());
        a = a.set(new A()).get();
        a.get();

        C c = new C();
        c.setAndGet(new C());

    }
}
