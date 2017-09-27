package com.jdk.proxy;

import com.jdk.bean.Production;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.lang.reflect.Method;

public class CgLibProxyTest {

    private static final Logger logger = Logger.getLogger(CgLibProxyTest.class);

    @Test
    public void testCGLIB() {
        Production production = (Production) new CGLIBProxyFactory().bind(new Production());
        logger.info(production.toString());
    }

}

class CGLIBProxyFactory implements MethodInterceptor {
    private static final Logger logger = Logger.getLogger(CGLIBProxyFactory.class);
    private Object delegate;

    public Object bind(Object delegate) {
        this.delegate = delegate;
        Enhancer enchaner = new Enhancer();
        enchaner.setSuperclass(delegate.getClass());
        enchaner.setCallback(this);
        return enchaner.create();

    }

    public Object intercept(Object proxyObject, Method method, Object[] args,
                            MethodProxy proxyMethod) throws Throwable {
        logger.info("before invoke");
        Object res = proxyMethod.invoke(delegate, args);
        logger.info("after invoke");
        return res;
    }

}

class Father {
    private static final Logger logger = Logger.getLogger(Father.class);

    public void method1() {
        logger.info("action in method1");
    }

    public void method2() {
        logger.info("action in method2");
    }
}
