package com.primeNumbers.model;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement

public class PrimeNumberEntity {
	
	public String AlgorithmName;
	
	public List<Integer> ListOfPrimeNumbers;

 
}
