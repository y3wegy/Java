package stream;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamTest {
	public static final Logger logger = Logger.getLogger(StreamTest.class);
	@Test
	public void testStream() {
		Arrays.asList("1","2").stream()
				.filter(value->value!=null)
				.forEach(value->logger.info(value));

	}
}
