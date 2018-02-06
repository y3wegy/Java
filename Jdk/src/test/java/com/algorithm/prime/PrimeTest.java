package com.algorithm.prime;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Rui on 9/1/2015.
 */
public class PrimeTest {

	@Test
	public void testNormalPrime() {
		long start = System.currentTimeMillis();
		PrimeNumber number = new PrimeNumber(11111);
		boolean isPrime = number.isPrime();
		long end = System.currentTimeMillis();
		System.out.println("take time " + (end - start) / 1000 + " s");
		Assert.assertFalse(isPrime);
	}
}
