package com.jdk.resource;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;

/**
 * Created by Rui on 6/29/2015.
 */
public class ResourceLoader {

    private static final Logger logger = Logger.getLogger(ResourceLoader.class);
    @Test
    public void testSourceCode() {
        ProtectionDomain domain = ResourceLoader.class.getProtectionDomain();
        CodeSource codeSource = null;
        URL result = null;
        if (domain != null)
            codeSource = domain.getCodeSource(); //get code source
        if (codeSource != null)
            result = codeSource.getLocation();
        System.out.println(codeSource.getCodeSigners());
        System.out.println(result);
    }

    @Test
    public void testJunitJarVersion() {
        URL url = this.getClass().getClassLoader().getResource("org/junit/Test.class");
        logger.info("load junit jar from :" + url.getPath());
        logger.info("load junit jar from path :" + Test.class.getResource("").getFile());

    }
}
