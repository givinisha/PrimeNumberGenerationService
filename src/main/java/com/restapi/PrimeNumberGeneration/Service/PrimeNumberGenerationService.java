package com.restapi.PrimeNumberGeneration.Service;

import java.util.List;

public interface PrimeNumberGenerationService {

	/*
	 	The below method list the prime number from 2 till  'upperLimit' number
		This  method determines prime by Brute force algorithm
	 */
	 List<Integer> getAllPrimeNumbersTillNUsingBruteForce(int upperLimit);
	 
	 /*
	 	The below method list the prime number from 2 till  'upperLimit' number
		This  method determines prime by inbuilt Java 8 functions such as IntStream
	 */
		public List<Integer> getAllPrimeNumbersTillNUsingJava8(int upperLimit);
		
		/*
	 	The below method list the prime number from 2 till  'upperLimit' number
		This  method determines prime by SieveOfEratosthenes algorithm
	 */
		public  List<Integer> getAllPrimeNumbersTillNUsingSieveOfEratosthenes(int upperLimit);
		
	 
}
