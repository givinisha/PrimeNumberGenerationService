package com.restapi.demo.PrimeNumberGenerationService;


import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import com.restapi.PrimeNumberGeneration.PrimeNumberEntity;
import com.restapi.PrimeNumberGeneration.Service.PrimeNumberGenerationService;


@SpringBootTest
@RunWith(SpringRunner.class)

public class PrimeNumberGenerationImplTest {

	@Autowired
	private PrimeNumberGenerationService service;

	@Test
	public void contextLoad() {
	}

	@Test
	public void testPrime() {
		assertEquals(1, 1);
	}
	
	  // Test the prime number generation using brute force algorithm
	  
	  @Test public void testPrimeNumberGeneratorUsingBruteForce() {
	  
	  
	  final PrimeNumberEntity prime = new PrimeNumberEntity();
	  prime.ListOfPrimeNumbers =
	  service.getAllPrimeNumbersTillNUsingBruteForce(120);
	  assertEquals("'primeNumberList' and 'MOCK_PRIME_NUMBER_LIST' should be equal in size"
	  , MockPrimeNumberList.MOCK_PRIME_NUMBER_LIST.size(),
	  prime.ListOfPrimeNumbers.size());
	  
	  assertEquals("'primes' and 'KNOWN_PRIMES' should be equal in size",
	  MockPrimeNumberList.MOCK_PRIME_NUMBER_LIST.size(),
	  prime.ListOfPrimeNumbers.size());
	  
	  for (int i = 0; i < MockPrimeNumberList.MOCK_PRIME_NUMBER_LIST.size(); i++) {
	  assertEquals("'primes.get(i)' should equal 'MOCK_PRIME_NUMBER_LIST[i]'",
	  (Integer)MockPrimeNumberList.MOCK_PRIME_NUMBER_LIST.get(i),
	  (Integer)prime.ListOfPrimeNumbers.get(i)); } } 
	  // Test the prime number	  generation using Sieve Of Eratosthene algorithm
	  
	  @Test public void testPrimeNumbersTillNUsingSieveOfEratosthenes() {
	  
	  final PrimeNumberEntity prime = new PrimeNumberEntity();
	  prime.ListOfPrimeNumbers =
	  service.getAllPrimeNumbersTillNUsingSieveOfEratosthenes(120);
	  assertEquals("'primeNumberList' and 'MOCK_PRIME_NUMBER_LIST' should be equal in size"
	  , MockPrimeNumberList.MOCK_PRIME_NUMBER_LIST.size(),
	  prime.ListOfPrimeNumbers.size());
	  
	  assertEquals("'primes' and 'KNOWN_PRIMES' should be equal in size",
	  MockPrimeNumberList.MOCK_PRIME_NUMBER_LIST.size(),
	  prime.ListOfPrimeNumbers.size());
	  
	  for (int i = 0; i <MockPrimeNumberList.MOCK_PRIME_NUMBER_LIST.size(); i++) {
	  assertEquals("'primes.get(i)' should equal 'MOCK_PRIME_NUMBER_LIST[i]'",
	  MockPrimeNumberList.MOCK_PRIME_NUMBER_LIST.get(i),
	  prime.ListOfPrimeNumbers.get(i)); } } 
	  
	  // Test the prime number generation using Java8 algorithm
	  
	  @Test public void testPrimeNumberGeneratorUsingJava8() {
	  
	  final PrimeNumberEntity prime = new PrimeNumberEntity();
	  prime.ListOfPrimeNumbers = service.getAllPrimeNumbersTillNUsingJava8(120);
	  assertEquals("'primeNumberList' and 'MOCK_PRIME_NUMBER_LIST' should be equal in size"
	  , MockPrimeNumberList.MOCK_PRIME_NUMBER_LIST.size(),
	  prime.ListOfPrimeNumbers.size());
	  
	  assertEquals("'primes' and 'MOCK_PRIME_NUMBER_LIST' should be equal in size",
	  MockPrimeNumberList.MOCK_PRIME_NUMBER_LIST.size(), prime.ListOfPrimeNumbers
	  .size());
	  
	  for (int i = 0; i < MockPrimeNumberList.MOCK_PRIME_NUMBER_LIST.size(); i++) {
	  assertEquals("'primes.get(i)' should equal 'MOCK_PRIME_NUMBER_LIST[i]'",
	  MockPrimeNumberList.MOCK_PRIME_NUMBER_LIST.get(i),
	  prime.ListOfPrimeNumbers.get(i)); } }
	  
	 
}
