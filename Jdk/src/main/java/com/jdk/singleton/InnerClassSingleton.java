package com.jdk.singleton;

import org.apache.log4j.Logger;

/**
 * Created by Rui on 6/25/2015.
 * <p/>
 * http://www.ibm.com/developerworks/cn/java/j-lo-Singleton/
 */
public class InnerClassSingleton {
	public static final Logger logger = Logger.getLogger(InnerClassSingleton.class);

	private InnerClassSingleton() {
		super();
		logger.info("InnerClassSingleton create");
	}

	static {
		logger.info("InnerClassSingleton ...");
	}

	private static final int a = getA();

	private static int getA() {
		logger.info("getA");
		return 1;
	}

	public static InnerClassSingleton getInstance() {
		return SingletonHolder.instance;
	}

	//use static inner class to avoid synchronized
	private static class SingletonHolder {
		private SingletonHolder() {
			super();
			logger.info("SingletonHolder create");
		}

		private static InnerClassSingleton instance = new InnerClassSingleton();

		static {
			logger.info("SingletonHolder ..");
		}
	}
}
