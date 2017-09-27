package com.jdk.proxy;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.lang.reflect.*;

/**
 * Created with IntelliJ IDEA.
 * Date: 12/16/13
 * Time: 2:47 PM
 * To change this template use File | Settings | File Templates.
 * <p>
 * JDK dynamic Proxy bean must implements one interface
 */
public class SimpleDynamicProxyTest {
    private static final Logger logger = Logger.getLogger(SimpleDynamicProxyTest.class);

    @Test
    public void testProxy() {
        A ins = (A) new SimpleDynamicProxy().bind(new SubA());
        ins.doSomething();
        ins.SomethingElse();

    }

    @Test
    public void testProxyDetail() throws Exception {
        A ins = (A) new SimpleDynamicProxy().bindDetail(new SubA());
        ins.doSomething();
        ins.SomethingElse();
    }
}

class SimpleDynamicProxy implements InvocationHandler {
    private static final Logger logger = Logger.getLogger(SimpleDynamicProxy.class);
    private Object proxied;

    public Object bind(Object delegate) {
        Object obj = Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), this);
        this.proxied = delegate;
        return obj;
    }

    public Object bindDetail(Object delegate) throws Exception {
        Object proxy = null;
        Class<?> clazz = Proxy.getProxyClass(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces());
        Constructor<?> constructor = clazz.getConstructor(new Class[]{InvocationHandler.class});
        proxy = constructor.newInstance(new Object[]{this});
        this.proxied = delegate;
        return proxy;

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info("profxy:" + proxy.getClass() +
                ",method:" + method + ",args:" + args);
        if (args != null)
            for (Object arg : args)
                logger.info(arg);
        return method.invoke(proxied, args);  //To change body of implemented methods use File | Settings | File Templates.
    }
}


interface A {
    public void doSomething();

    public void SomethingElse();
}

class SubA implements A {
    private static final Logger logger = Logger.getLogger(SubA.class);

    @Override
    public void doSomething() {
        logger.info("do something");
    }

    @Override
    public void SomethingElse() {
        logger.info("do something else");
    }
}
