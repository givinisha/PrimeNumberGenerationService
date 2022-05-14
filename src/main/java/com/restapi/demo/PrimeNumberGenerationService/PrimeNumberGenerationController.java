package com.restapi.demo.PrimeNumberGenerationService;


import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PrimeNumberGenerationController {
	
	@GetMapping("hello-world")
	public String getHelloWorld()
	{
	
		return "hello world";
	}
	
	@GetMapping("/generatePrimeNumber")
	public List<Integer> generatePrimeNumber(@RequestParam(name = "number")int n)
	{
		List<Integer> primeNumbers = new LinkedList<>();
	    if (n >= 2) {
	        primeNumbers.add(2);
	    }
	    for (int i = 3; i <= n; i += 2) {
	        if (isPrimeBruteForce(i)) {
	            primeNumbers.add(i);
	        }
	    }
	    return primeNumbers;
	}
	
	private static boolean isPrimeBruteForce(int number) {
	    for (int i = 2; i*i <= number; i++) {
	        if (number % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
	

}
