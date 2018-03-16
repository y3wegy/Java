package com.jdk.jvm.classloader;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.stream.Stream;

/**
 * @author Chen,Rui
 * @create 2/9/2018
 * @description BoostStrap Classloader -> extension ClassLoader -> System ClassLoader
 * <p>
 * http://ruby-java.iteye.com/blog/169854
 **/
public class JVMClassLoaderOrderTest {
	private static final Logger logger = Logger.getLogger(JVMClassLoaderOrderTest.class);

	@Test
	void testBootstrapLoader() {
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		Stream.of(urls).forEach(logger::info);

		//urls is from sun.boot.class.path
		logger.info(System.getProperty("sun.boot.class.path"));
	}

	/**
	 * ExtClassLoader
	 * <p>
	 * default load JAVA_HOME/jre/lib/ext/*.jar
	 */
	@Test
	void testExtensionClassLoader() {
		logger.info(System.getProperty("java.ext.dirs"));
		ClassLoader extensionClassloader = ClassLoader.getSystemClassLoader().getParent();
		logger.info(String.format("extension classloader : %s",  extensionClassloader));
		logger.info(String.format("the parent of extension classloader :%s ",extensionClassloader.getParent()));
	}

	/**
	 * AppClassLoader
	 */
	@Test
	void testSystemLoader() {
		logger.info(String.format("System classloader:%s", JVMClassLoaderOrderTest.class.getClassLoader()));
		logger.info(String.format("System classloader:%s", ClassLoader.getSystemClassLoader()));
	}
}
