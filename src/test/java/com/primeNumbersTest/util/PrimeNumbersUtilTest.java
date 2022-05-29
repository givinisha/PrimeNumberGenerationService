package com.primeNumbersTest.util;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.primeNumbers.util.PrimeNumbersUtil;

public class PrimeNumbersUtilTest {

public static final List<Integer> MOCK_PRIME_NUMBER_LIST = new ArrayList<Integer>() {{ 				
    	add(2);
				add(3);
				add(5);
				add(7); 
				add(11);
				add(13);
				add(17);
				add(19);
				add(23);
				add(29); 
				add(31);
				add(37); 
				add(41);
				add(43);
				add(47);
				add(53); 
				add(59);
				add(61); 
				add(67);
				add(71); 
				add(73); 
				add(79); 
				add(83);
				add(89); 
				add(97);
				add(101); 
				add(103);
				add(107);
				add(109); 
				add(113); 
    }};
    
    @Test
    /**
     * Test case to check if a number is prime number or not 
     */
    public void testIsPrimeNumberUsingJava8()
    {
    	
        for (int i = 0; i < MOCK_PRIME_NUMBER_LIST.size(); i++) {
            final int prime = MOCK_PRIME_NUMBER_LIST.get(i);
            assertTrue(prime + " is a prime number", PrimeNumbersUtil.isPrimeBruteForce(prime));
        }       
    }
    
    
    @Test
    /**
     * Test case to check if a number is prime number or not 
     */
    public void testIsPrimeNumberUsingBruteForce()
    {
    	
        for (int i = 0; i < MOCK_PRIME_NUMBER_LIST.size(); i++) {
            final int prime = MOCK_PRIME_NUMBER_LIST.get(i);
            assertTrue(prime + " is a prime number", PrimeNumbersUtil.isPrimeBruteForce(prime));
        }       
    }

}