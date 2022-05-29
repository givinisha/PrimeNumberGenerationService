package com.primeNumbers.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.primeNumbers.model.PrimeNumberEntity;
import com.primeNumbers.service.PrimeNumberGenerationImpl;

@RestController

public class PrimeNumberGenerationController {
	
	 @Autowired
	 PrimeNumberGenerationImpl primeNumberGenerationService;
	 
	 /**
	  * --------------------------------------------------------------
	  * SAMPLE URLS TO LIST OUT PRIME NUMBERS USING VARIOUS ALGORITHM 
	  * --------------------------------------------------------------
	  * http://localhost:8082/primes?upperLimit=10&algorithm=1 
	  * http://localhost:8082/primes
	  * http://localhost:8082/primes?upperLimit=10
	  */
	
	@RequestMapping (value = "/{upperLimit}",produces = { "application/json", "application/xml" })
	public  PrimeNumberEntity primes(@RequestParam(value = "upperLimit",defaultValue = "20",required = false)int upperLimit, @RequestParam(value = "algorithm", required = false, defaultValue = "3") int algorithm)
										
	{
		try
		{
		PrimeNumberEntity result = new PrimeNumberEntity();
	        switch (algorithm) {
	            case 1:
	            	result.AlgorithmName = "UsingJava8Functions";
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
		catch(Exception ex) {
			throw ex;
		}
	}
	
	}
	


