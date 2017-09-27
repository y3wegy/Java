package com.algorithm.prime;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rui on 9/1/2015.
 */
public class PrimeNumber {
    private Integer number;

    public PrimeNumber(int number) {
        this.number = number;
    }

    public boolean isFactor(int potential) {
        return number % potential == 0;
    }

    public Set<Integer> getFactors() {
        Set<Integer> factors = new HashSet<>();
        factors.add(1);
        factors.add(number);
        for (Integer i = 2; i < number; i++) {
            if (isFactor(i)) {
                factors.add(i);
            }
        }
        return factors;
    }

    public int sumFactors() {
        int sum = 0;
        for (int i : getFactors()) {
            sum += i;
        }
        return sum;
    }

    public boolean isPrime() {
        return sumFactors() == number + 1;
    }
}
