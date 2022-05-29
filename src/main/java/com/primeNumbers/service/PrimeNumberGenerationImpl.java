/**
 * 
 */
package com.primeNumbers.service;

import java.util.Arrays;
import com.primeNumbers.util.PrimeNumbersUtil;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;



@Service

@Cacheable("PrimeNumberEntity")
public class PrimeNumberGenerationImpl implements PrimeNumberGenerationService {
	
	 private final List<Integer>  primes;
	
	 public PrimeNumberGenerationImpl()
	 {
		this.primes = null;
		
	 }
	  public PrimeNumberGenerationImpl(List<Integer> primes) {
		    this.primes = primes;
		  }
 /*
 	The below method list the prime number from 2 till  'upperLimit' number
	This  method determines prime by Brute force algorithm
 */
	@Override
	public List<Integer> getAllPrimeNumbersTillNUsingBruteForce(int upperLimit)
	{
		/*
		 * To test the catchable property
		 try {
			 System.out.println("Going to sleep for 3 Secs.. to simulate backend call.");
			   				Thread.sleep(1000*3);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			*/
		System.out.println("Prime Number is generated using Brute Force algorithm");
	List<Integer> primeNumbers = new LinkedList<>();
    if (upperLimit >= 2) {
        primeNumbers.add(2);
    }
    for (int i = 3; i <= upperLimit; i += 2) {
        if (PrimeNumbersUtil.isPrimeBruteForce(i)) {
            primeNumbers.add(i);
        }
    }

    return primeNumbers;
	}
/*
 	The below method list the prime number from 2 till  'upperLimit' number
	This  method determines prime by inbuilt Java 8 functions such as IntStream
 */
	@Override
	public List<Integer> getAllPrimeNumbersTillNUsingJava8(int upperLimit)
	{
		System.out.println("Prime Number is generated using Java8");
		 return IntStream.rangeClosed(2, upperLimit)
			      .filter(x -> PrimeNumbersUtil.isPrimeNumberUsingJava8(x)).boxed()
			      .collect(Collectors.toList());
    }
	
	/*
 	The below method list the prime number from 2 till  'upperLimit' number
	This  method determines prime by SieveOfEratosthenes algorithm
 */
	@Override
	public  List<Integer> getAllPrimeNumbersTillNUsingSieveOfEratosthenes(int upperLimit) {
		System.out.println("Prime Number is generated using SieveOfEratosthenes");
		boolean prime[] = new boolean[upperLimit + 1];
	    Arrays.fill(prime, true);
	    for (int p = 2; p * p <= upperLimit; p++) {
	        if (prime[p]) {
	            for (int i = p * 2; i <= upperLimit; i += p) {
	                prime[i] = false;
	            }
	        }
	    }
	    List<Integer> primeNumbers = new LinkedList<>();
	    for (int i = 2; i <= upperLimit; i++) {
	        if (prime[i]) {
	            primeNumbers.add(i);
	        }
	    }
	    return primeNumbers;
	}

	


	

}
