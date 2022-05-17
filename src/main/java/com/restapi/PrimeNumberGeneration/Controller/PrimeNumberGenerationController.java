package com.restapi.PrimeNumberGeneration.Controller;


import com.restapi.PrimeNumberGeneration.PrimeNumberEntity;
import com.restapi.PrimeNumberGeneration.Service.PrimeNumberGenerationImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PrimeNumberGenerationController {
	
	 @Autowired
	 PrimeNumberGenerationImpl primeNumberGenerationService;
	 
	 /*
	  * SAMPLE URLS to generate Prime Number till the upper limit provided using the various algorithms:
	  * http://localhost:8082/generatePrimeNumber?upperLimit=10&algorithm=1
	  *  http://localhost:8082/generatePrimeNumber
	  *   http://localhost:8082/generatePrimeNumber?upperLimit=10
	  */
	
	@RequestMapping (value = "/{upperLimit}",produces = { "application/json", "application/xml" })
	public  PrimeNumberEntity generatePrimeNumber(@RequestParam(value = "upperLimit",defaultValue = "20",required = false)int upperLimit, @RequestParam(value = "algorithm", required = false, defaultValue = "3") int algorithm)
										
	{
		  
		PrimeNumberEntity result = new PrimeNumberEntity();
	        switch (algorithm) {
	            case 1:
	            	result.AlgorithmName = "UsingJava8";
	            	result.ListOfPrimeNumbers = primeNumberGenerationService.getAllPrimeNumbersTillNUsingJava8(upperLimit);
	                break;
	                case 2:
	            	result.AlgorithmName = "SieveOfEratosthenes";
	            	result.ListOfPrimeNumbers = primeNumberGenerationService.getAllPrimeNumbersTillNUsingSieveOfEratosthenes(upperLimit);
	                break;
	            default:
	            	result.AlgorithmName = "BruteForce";	            	
	            	result.ListOfPrimeNumbers = primeNumberGenerationService.getAllPrimeNumbersTillNUsingBruteForce(upperLimit);
	        }

	        return result;
	}
	
	}
	


