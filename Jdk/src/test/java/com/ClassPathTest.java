package com;


import org.junit.jupiter.api.Test;

import java.net.URL;

public class ClassPathTest {
    @Test
    public void testJunitJarPath() {
        URL url = this.getClass().getClassLoader().getResource("org/junit/Test.class");
        System.out.println(url.getPath());
    }

}
