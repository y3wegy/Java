/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package paramter;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ParamterTest {
	public static final Logger logger = Logger.getLogger(ParamterTest.class);
	@Test
	public void testParam() throws NoSuchMethodException {
		Method methodFun = ParamterTest.class.getMethod("fun",String[].class,int.class);
		Arrays.stream(methodFun.getParameters()).forEach(param->logger.info(param.getName()));
	}

	public void fun(String[] values,int intStr){

	}
}
