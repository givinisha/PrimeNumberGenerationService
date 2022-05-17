package com.restapi.demo.PrimeNumberGenerationService;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;



import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.http.ResponseEntity;


import com.restapi.PrimeNumberGeneration.PrimeNumberEntity;
import com.restapi.demo.PrimeNumberGenerationService.MockPrimeNumberList;


import org.junit.jupiter.api.Test;



	public class PrimeNumberGenerationControllerTest {

	    private TestRestTemplate restTemplate = new TestRestTemplate();

	    // Make sure the service is not currently running when executing these tests
	    private String baseUrl = "http://localhost:8082";

	    /**
	     * Test prime number generation on default upper limit value
	     */
	    @Test
	    public void testPrimeGeneration() {

	    
	       ResponseEntity<PrimeNumberEntity> entity = restTemplate.getForEntity(baseUrl + "/generatePrimeNumbers",PrimeNumberEntity.class);
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

	        // Test negative upper limit
	        entity = restTemplate.getForEntity(baseUrl + "/generatePrimeNumbers?upperLimit=-3", PrimeNumberEntity.class);
	        expected.ListOfPrimeNumbers = Collections.emptyList();
	        validateContent(entity, expected);

	        // Test MockPrimeNumberList.MOCK_PRIME_NUMBER_LIST
	        entity = restTemplate.getForEntity(baseUrl + "/generatePrimeNumbers?upperLimit=120", PrimeNumberEntity.class);
	        expected.ListOfPrimeNumbers = MockPrimeNumberList.MOCK_PRIME_NUMBER_LIST;
	        validateContent(entity, expected);
	    }

	  

	    private void validateContent(ResponseEntity entity, PrimeNumberEntity expected) {
	        final PrimeNumberEntity actual = (PrimeNumberEntity) entity.getBody();
	        assertEquals(expected.ListOfPrimeNumbers.size(), actual.ListOfPrimeNumbers.size());
	        assertEquals(expected.ListOfPrimeNumbers, actual.ListOfPrimeNumbers);
	    }

}
