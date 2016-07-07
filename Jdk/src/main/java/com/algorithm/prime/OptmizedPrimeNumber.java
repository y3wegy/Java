package com.algorithm.prime;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by a549238 on 9/1/2015.
 */
public class OptmizedPrimeNumber {
    private Integer number;
    private Map<Integer, Integer> cache;

    public OptmizedPrimeNumber() {
        cache = new HashMap<Integer, Integer>();
    }

    public static OptmizedPrimeNumber getPrime(int number) {
        return new OptmizedPrimeNumber().setCandicate(number);
    }

    public OptmizedPrimeNumber setCandicate(Integer number) {
        this.number = number;
        return this;
    }

    public boolean isFactor(int potential) {
        return number % potential == 0;
    }

    public Set<Integer> getFactors() {
        Set<Integer> factors = new HashSet<Integer>();
        factors.add(1);
        factors.add(number);
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (isFactor(i)) {
                factors.add(i);
                factors.add(number / i);
            }

        }
        return factors;
    }

    public int sumFactors() {
        int sum = 0;
        if (cache.containsValue(number))
            sum = cache.get(number);
        else
            for (int i : getFactors())
                sum += i;
        return sum;
    }

    public boolean isPrime() {
        return number == 2 || sumFactors() == number + 1;
    }
}
