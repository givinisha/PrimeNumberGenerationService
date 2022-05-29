package com.primeNumbers.util;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class PrimeNumbersUtil
{
	/**
     * This method determines if number is a prime number.
     * @param n The number which shall be determined to be prime or non-prime
     * @return {@code true} if {@code n} is prime, otherwise {@code false}
     */
	public static boolean isPrimeNumberUsingJava8(int number) {
		IntPredicate isDivisible = index -> number % index == 0;
        return number > 1 && IntStream.range(2, number).noneMatch(isDivisible);
	}
	/**
     * This method determines if number is a prime number.
     * @param n The number which shall be determined to be prime or non-prime
     * @return {@code true} if {@code n} is prime, otherwise {@code false}
     */
	public static boolean isPrimeBruteForce(int number) {
	    for (int i = 2; i*i <= number; i++) {
	        if (number % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}

}