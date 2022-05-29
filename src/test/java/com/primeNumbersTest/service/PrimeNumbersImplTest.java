package com.primeNumbersTest.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import com.primeNumbers.PrimeNumberGenerationServiceApplication;
import com.primeNumbers.model.PrimeNumberEntity;
import com.primeNumbers.service.PrimeNumberGenerationImpl;
import com.primeNumbersTest.util.PrimeNumbersUtilTest;



@SpringBootTest(classes = PrimeNumberGenerationServiceApplication.class)
@RunWith(SpringRunner.class)

public class PrimeNumbersImplTest {

	@Autowired
	private PrimeNumberGenerationImpl service;

	public void contextLoads() throws Exception {
		assertThat(service).isNotNull();
	}
	@BeforeClass
    public static void isApplicationContextFailed() {
        //logic to check for application failure
    }
	
	/** 
	   * Test case to test the prime number generation using brute force algorithm
	   */
	  @Test 
	  
	  public void testPrimeNumberGeneratorUsingBruteForce() {
	  
	  
	  final PrimeNumberEntity prime = new PrimeNumberEntity();
	  prime.ListOfPrimeNumbers =
	  service.getAllPrimeNumbersTillNUsingBruteForce(114);
	  
	  assertEquals("'primeNumberList' and 'MOCK_PRIME_NUMBER_LIST' should be equal in size"
	  , PrimeNumbersUtilTest.MOCK_PRIME_NUMBER_LIST.size(),
	  prime.ListOfPrimeNumbers.size());
	  
	  for (int i = 0; i < PrimeNumbersUtilTest.MOCK_PRIME_NUMBER_LIST.size(); i++) {
	  assertEquals("'primes.get(i)' should equal 'MOCK_PRIME_NUMBER_LIST[i]'",
	  (Integer)PrimeNumbersUtilTest.MOCK_PRIME_NUMBER_LIST.get(i),
	  (Integer)prime.ListOfPrimeNumbers.get(i)); } } 
	  
	  /** 
	   * Test case to test the prime number generation using Sieve Of Eratosthenes algorithm
	   */
	 
	  @Test 
	  
	  public void testPrimeNumbersTillNUsingSieveOfEratosthenes() {
	  
	  final PrimeNumberEntity prime = new PrimeNumberEntity();
	  prime.ListOfPrimeNumbers =
	  service.getAllPrimeNumbersTillNUsingSieveOfEratosthenes(120);
	  assertEquals("'primeNumberList' and 'MOCK_PRIME_NUMBER_LIST' should be equal in size"
	  , PrimeNumbersUtilTest.MOCK_PRIME_NUMBER_LIST.size(),
	  prime.ListOfPrimeNumbers.size());
	  
	  for (int i = 0; i <PrimeNumbersUtilTest.MOCK_PRIME_NUMBER_LIST.size(); i++) {
	  assertEquals("'primes.get(i)' should equal 'MOCK_PRIME_NUMBER_LIST[i]'",
	  PrimeNumbersUtilTest.MOCK_PRIME_NUMBER_LIST.get(i),
	  prime.ListOfPrimeNumbers.get(i)); } } 
	  
	  /** 
	   * Test case to test the prime number generation using java8 build in functions algorithm
	   */
	  @Test 
	  
	  public void testPrimeNumberGeneratorUsingJava8() {
	  
	  final PrimeNumberEntity prime = new PrimeNumberEntity();
	  prime.ListOfPrimeNumbers = service.getAllPrimeNumbersTillNUsingJava8(120);
	  assertEquals("'primeNumberList' and 'MOCK_PRIME_NUMBER_LIST' should be equal in size"
	  , PrimeNumbersUtilTest.MOCK_PRIME_NUMBER_LIST.size(),
	  prime.ListOfPrimeNumbers.size());
	  
	  
	  for (int i = 0; i < PrimeNumbersUtilTest.MOCK_PRIME_NUMBER_LIST.size(); i++) {
	  assertEquals("'primes.get(i)' should equal 'MOCK_PRIME_NUMBER_LIST[i]'",
			  PrimeNumbersUtilTest.MOCK_PRIME_NUMBER_LIST.get(i),
	  prime.ListOfPrimeNumbers.get(i)); } }
	  
	 
}
