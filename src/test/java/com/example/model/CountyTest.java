package com.example.model;

import org.junit.jupiter.api.Test;

public class CountyTest {

	@Test
	void test() {
		var c =  new Country();
		c.setName("ara");
		c.setPopulation(100L);
		System.out.println(c);
		
		var c2 = 
		Country.builder().code2("4").headOfState("ARA").build();
		System.out.println(c2);
	}
}
