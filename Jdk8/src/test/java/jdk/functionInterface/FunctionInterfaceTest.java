package jdk.functionInterface;

import jdk.bean.ShortToByteFunction;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Chen,Rui
 * @create 1/18/2018
 * @description
 **/
public class FunctionInterfaceTest {
	private static final Logger logger = Logger.getLogger(FunctionInterfaceTest.class);

	@Test
	@DisplayName("Simple Test")
	void testFunctioninterface() {
		HashMap<String, Integer> map = new HashMap<>(12);
		Integer res = map.computeIfAbsent("12222", String::length);
		logger.info(res);
	}

	@Test
	void testSec() {
		short[] array = {(short) 1, (short) 2, (short) 3};
		byte[] transformedArray = ShortToByteFunction.transformArray(array, s -> (byte) (s * 2));

		byte[] expectedArray = {(byte) 2, (byte) 4, (byte) 6};
		assertArrayEquals(expectedArray, transformedArray);
	}

	@Test
	void testCompose() {
		Function<Integer, String> intToString = Object::toString;
		Function<String, String> quote = s -> "'" + s + "'";

		Function<Integer, String> quoteIntToString = quote.compose(intToString);

		assertEquals("'5'", quoteIntToString.apply(5));

		//compose by andThen
		Function<Integer, String> quoteIntToString2 = intToString.andThen(quote);
		assertEquals("'5'", quoteIntToString2.apply(5));
	}

	@Test
	void testPredicates() {
		List<String> names = Arrays.asList("Angela", "Aaron", "Bob", "Claire", "David");

		List<String> namesWithA = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
		logger.info(namesWithA);
	}
}
