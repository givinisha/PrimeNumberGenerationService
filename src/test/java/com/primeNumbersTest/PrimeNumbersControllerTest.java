package com.primeNumbersTest;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;



import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.primeNumbersTest.util.PrimeNumbersUtilTest;
import com.primeNumbers.model.PrimeNumberEntity;

import org.junit.jupiter.api.Test;

public class PrimeNumbersControllerTest {

	    private TestRestTemplate restTemplate = new TestRestTemplate();

	    // Make sure the service is not currently running when executing these tests
	    private String baseUrl = "http://localhost:8082";

	    /**
	     * Test prime number generation on default upper limit value
	     */
	    @Test
	    public void testPrimeNumberGeneration() {

	    	/**
	         * TEST CASE: Test default upper limit
	         */
	       ResponseEntity<PrimeNumberEntity> entity = restTemplate.getForEntity(baseUrl + "/primes",PrimeNumberEntity.class);
	       PrimeNumberEntity expected = new PrimeNumberEntity();
	       expected.AlgorithmName = "BruteForce";
	    	 expected.ListOfPrimeNumbers = new ArrayList<Integer>() {{ }};
	    	 expected.ListOfPrimeNumbers.add(2); 
	    	 expected.ListOfPrimeNumbers.add(3);
	    	 expected.ListOfPrimeNumbers.add(5);
	    	 expected.ListOfPrimeNumbers.add(7);
	    	 expected.ListOfPrimeNumbers.add(11);
	    	 expected.ListOfPrimeNumbers.add(13);
	    	 expected.ListOfPrimeNumbers.add(17);
	    	 expected.ListOfPrimeNumbers.add(19);
	        validateContent(entity, expected);
	        
	        
	        /**
	         * TEST CASE: Test negative upper limit
	         */
	        entity = restTemplate.getForEntity(baseUrl + "/primes?upperLimit=-3", PrimeNumberEntity.class);
	        expected.ListOfPrimeNumbers = Collections.emptyList();
	        validateContent(entity, expected);

	        /**
	         * TEST CASE: Test MockPrimeNumberList.MOCK_PRIME_NUMBER_LIST
	         */
	        entity = restTemplate.getForEntity(baseUrl + "/primes?upperLimit=120", PrimeNumberEntity.class);
	        expected.ListOfPrimeNumbers = PrimeNumbersUtilTest.MOCK_PRIME_NUMBER_LIST;
	        validateContent(entity, expected);
	        
	        /**
	         * Test the primes numbers API resource using combinations of prime and 3 different algorithms
	         */
	        
	        
	    }

	    @Test
	    public void testPrimeNumbersByVariousAlogorithms() {

	        /*@upperLimit: 47 
	         *@Algorithm: UsingJava8Functions
	         */
	    	
	        ResponseEntity<PrimeNumberEntity> entity = restTemplate.getForEntity(baseUrl + "/primes/?upperLimit={0}&algorithm={1}", PrimeNumberEntity.class, 47, 2);
	        assertEquals(HttpStatus.OK, entity.getStatusCode());

	        /*@upperLimit: 47 
	         *@Algorithm: SieveOfEratosthenes
	         */
	        entity = restTemplate.getForEntity(baseUrl + "/primes/?upperLimit={0}&algorithm={1}", PrimeNumberEntity.class, 47, 2);
	        assertEquals(HttpStatus.OK, entity.getStatusCode());

	        /*@upperLimit: 47
	         *@Algorithm: BruteForce
	         */
	        entity = restTemplate.getForEntity(baseUrl + "/primes/?upperLimit={0}&algorithm={1}", PrimeNumberEntity.class, 47, 3);
	        assertEquals(HttpStatus.OK, entity.getStatusCode());

	        /*@upperLimit: 47
	         *@Algorithm: default algorithm
	         */
	        entity = restTemplate.getForEntity(baseUrl + "/primes/?upperLimit={0}", PrimeNumberEntity.class, 119);
	        assertEquals(HttpStatus.OK, entity.getStatusCode());
	    }

	    private void validateContent(ResponseEntity entity, PrimeNumberEntity expected) {
	        final PrimeNumberEntity actual = (PrimeNumberEntity) entity.getBody();
	        assertEquals(expected.ListOfPrimeNumbers.size(), actual.ListOfPrimeNumbers.size());
	        assertEquals(expected.ListOfPrimeNumbers, actual.ListOfPrimeNumbers);
	    }

}
