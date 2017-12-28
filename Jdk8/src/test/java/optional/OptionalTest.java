package optional;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class OptionalTest {
	public static final Logger logger = Logger.getLogger(OptionalTest.class);

	@Test
	public void testOptional() {
		Optional<String> stringOptional = Optional.ofNullable(null);
		assertTrue(!stringOptional.isPresent());
		logger.info(stringOptional.orElse("Value"));
		logger.info(stringOptional.orElseGet(()->"1"));
		stringOptional.map(value->value.concat("1"));
	}
}
