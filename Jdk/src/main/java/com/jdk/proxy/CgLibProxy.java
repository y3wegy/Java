package com.jdk.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;

public class CgLibProxy {


    @Test
    public void testCGLIB() {
        Father father = (Father) new CGLIBProxyFactory().bind(new Father());
        father.method1();
    }

}

class CGLIBProxyFactory implements MethodInterceptor {
    private Object delegate;

    public Object bind(Object delegate) {
        this.delegate = delegate;
        Enhancer enchaner = new Enhancer();
        enchaner.setSuperclass(delegate.getClass());
        enchaner.setCallback(this);
        return enchaner.create();

    }

    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        System.out.println("before invoke");
        Object res = proxy.invoke(delegate, args);
        System.out.println("after invoke");
        return res;
    }

}

class Father {
    public void method1() {
        System.out.println("action in method1");
    }

    public void method2() {
        System.out.println("action in method2");
    }
}
