package com.jdk.classpkg.classinit.resourcedemo;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 6/7/13
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class ResourcesDemo {
    @Test
    public void testRes() {
        ResourcesDemo resourcesDemo = new ResourcesDemo();
        ClassLoader classLoader = resourcesDemo.getClass().getClassLoader();
        System.out.println("classLoader.getResource(\"\").getPath():" + classLoader.getResource("").getPath());
        System.out.println("classLoader.getResource(\"\"):" + classLoader.getResource(""));
        System.out.println("resourcesDemo.getClass().getResource(\"\"):" + resourcesDemo.getClass().getResource(""));
        System.out.println("resourcesDemo.getClass().getResource(\".\"):" + resourcesDemo.getClass().getResource("."));
    }
}
