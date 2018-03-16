package jdk;

import com.module.SimpleBean;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author Chen,Rui
 * @create 1/18/2018
 * @description
 **/
public class SupplierTest {

	private static final Logger logger = Logger.getLogger(SupplierTest.class);

	@Test
	void testSimple() {
		Supplier<SimpleBean> simpleBeanSupplier = () -> new SimpleBean();
		SimpleBean simpleBean1 = simpleBeanSupplier.get();
		SimpleBean simpleBean2 = simpleBeanSupplier.get();
		logger.info(String.format("SimpleBean1:%s  ----  SimpleBean2:%s", simpleBean1, simpleBean2));
		assertNotEquals(simpleBean1, simpleBean2);
	}


}
