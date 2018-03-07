package com.jdk.jvm.classloader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author e631876
 * @create 2/27/2018
 * @description  this junit just for record some notes
 *
 * https://tomcat.apache.org/tomcat-7.0-doc/class-loader-howto.html
 * If left as blank, the "common" loader will be used as Catalina's "shared"/"server":
 * https://stackoverflow.com/questions/6254869/order-of-tomcat-classloaders-common-shared-and-server
 *
 * order: https://stackoverflow.com/questions/5474765/order-of-loading-jar-files-from-lib-directory
 *
 * tomcat classloader order:
 * bootstrap/system (JRE/lib, then server.loader)
 * webapp libraries (WEB-INF/classes, then WEB-INF/lib)
 * common libraries (common.loader, then Tomcat/lib)
 * webapp-shared libraries (shared.loader)
 **/
public class TomcatCLassLoaderTest {
    @Test
    void testTomcat() {
        Assertions.assertTrue(true);
    }
}
