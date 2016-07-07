package com.jdk.proxy;

import org.junit.Test;

import java.lang.reflect.*;

interface A {
    public void doSomething();

    public void SomethingElse();
}

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/16/13
 * Time: 2:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleDynamicProxyDemo {
    public static void consumer(A ins) {
        ins.doSomething();
        ins.SomethingElse();
    }

    @Test
    public void testProxy() {
        A ins = (A) new SimpleDynamicProxy().bind(new SubA());
        ins.doSomething();
        ins.SomethingElse();

    }

    @Test
    public void testProxyDetail() {
        A ins = (A) new SimpleDynamicProxy().bindDetail(new SubA());
        ins.doSomething();
        ins.SomethingElse();
    }
}

class SimpleDynamicProxy implements InvocationHandler {

    private Object proxied;

    public Object bind(Object delegate) {
        Object obj = Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), this);
        this.proxied=delegate;
        return obj;
    }

    public Object bindDetail(Object delegate) {
        Object proxy = null;
        Class<?> clazz = Proxy.getProxyClass(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces());
        try {
            Constructor<?> constructor = clazz.getConstructor(new Class[]{InvocationHandler.class});
            proxy = constructor.newInstance(new Object[]{this});
            this.proxied=delegate;
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return proxy;

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("profxy:" + proxy.getClass() +
                ",method:" + method + ",args:" + args);
        if (args != null)
            for (Object arg : args)
                System.out.println(arg);
        return method.invoke(proxied, args);  //To change body of implemented methods use File | Settings | File Templates.
    }
}

class SubA implements A {

    @Override
    public void doSomething() {
        System.out.println("do something");
    }

    @Override
    public void SomethingElse() {
        System.out.println("do something else");
    }
}
