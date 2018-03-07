package stream;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamTest {
	public static final Logger logger = Logger.getLogger(StreamTest.class);

	@Test
	public void testStream() {
		Arrays.asList("1", "2").stream()
				.filter(value -> value != null)
				.forEach(logger::info);

	}

	@Test
	public void testLazy() throws Exception {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		Stream<Integer> stream = numbers.stream().map(n -> n / 0).filter(n -> n % 2 == 0);
		Assumptions.assumeTrue(LocalDate.now().getDayOfWeek()== DayOfWeek.FRIDAY);
		logger.info("Today is Friday");
	}

	/**
	 *
	 * @throws Exception
	 */
	@Test
	public void testLazy2() throws Exception {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		Stream<Integer> stream = numbers.stream().map(n -> n / 0).filter(n -> n % 2 == 0);
		stream.collect(toList());
	}
}
