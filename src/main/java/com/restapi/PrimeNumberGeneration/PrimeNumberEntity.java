package com.restapi.PrimeNumberGeneration;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement

public class PrimeNumberEntity {
	public String AlgorithmName;
	public List<Integer> ListOfPrimeNumbers;

 
}
