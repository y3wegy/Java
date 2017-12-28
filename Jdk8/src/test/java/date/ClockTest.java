package date;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.time.Clock;

public class ClockTest {
	public static final Logger logger = Logger.getLogger(ClockTest.class);

	@Test
	public void testClock() {
		final Clock clock = Clock.systemUTC();
		logger.info(clock.instant());
	}
}
