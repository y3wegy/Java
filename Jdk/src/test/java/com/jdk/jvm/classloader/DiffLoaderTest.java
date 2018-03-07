package com.jdk.jvm.classloader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author e631876
 * @create 2/24/2018
 * @description loadClass() java.lang.ClassNotFoundException
 * defineClass() java.lang.NoClassDefFoundError
 *
 * https://webcache.googleusercontent.com/search?q=cache:HmT-N0N2RlsJ:https://zhuanlan.zhihu.com/p/25493756+&cd=3&hl=en&ct=clnk&gl=us
 * http://blog.jobbole.com/96145/
 **/
public class DiffLoaderTest {

    @Test
    void testDiff() throws MalformedURLException {
        URLClassLoader classLoaderA = new URLClassLoader(new URL[]{new URL("file:C:\\Users\\e631876\\Desktop\\Jdk8-1.0-SNAPSHOT.jar")});
        URLClassLoader classLoaderB = new URLClassLoader(new URL[]{new URL("file:C:\\Users\\e631876\\Desktop\\Jdk8-1.0-SNAPSHOT.jar")});

        String className = "jdk.bean.Sample";

        try {
            Class classA = classLoaderA.loadClass(className);
            Class classB = classLoaderB.loadClass(className);

            Object testA = classA.newInstance();
            Object testB = classB.newInstance();
            Method castMethod = classA.getMethod("setSample", Object.class);
            Assertions.assertThrows(InvocationTargetException.class, () -> castMethod.invoke(testA, testB), "Type cast should failed");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
