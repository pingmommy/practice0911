package com.example.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CountryMapperTest {
	
	@Autowired
	CountryMapper mapper;

	@Test
	void test1() {
		var list = mapper.selectAll();
		
		assertThat(list).isNotEmpty();
		assertThat(list).isNotNull();
		assertThat(list.size()).isEqualTo(239);
		list.forEach(c -> System.out.println("[" +c.getGovernmentForm()+"]"));
		//char 타입을 varchar2타입으로 바꿈. 
		//list.forEach(c -> System.out.println(c));
		
	}
	
	@Test
	void test2() {
		var list = mapper.selectContinent();
		assertThat(list).isNotEmpty();
		assertThat(list).isNotNull();
		assertThat(list.size()).isEqualTo(7);
		list.forEach(c->System.out.println(c));
	}
	
	@Test
	void selectByContinent() {
		
//		--North America
//		--Europe
//		--Asia
//		--Africa
//		--Oceania
//		--South America
//		--Antarctica
//		
		var list =  mapper.selectByContinent("Africa");
		assertThat(list).isNotEmpty();
		assertThat(list).isNotNull();
		assertThat(list.size()).isEqualTo(58);
		list.forEach(c -> System.out.println(c.getName()));
		assertThat(list).allMatch(e ->e.getContinent().equals("Africa"));
		
		list =  mapper.selectByContinent("North America");
		assertThat(list).allMatch(e ->e.getContinent().equals("North America"));
		
		list =  mapper.selectByContinent("Europe");
		assertThat(list).allMatch(e ->e.getContinent().equals("Europe"));
		
		list =  mapper.selectByContinent("Asia");
		assertThat(list).allMatch(e ->e.getContinent().equals("Asia"));
		
		list =  mapper.selectByContinent("Oceania");
		assertThat(list).allMatch(e ->e.getContinent().equals("Oceania"));
		
		list =  mapper.selectByContinent("South America");
		assertThat(list).allMatch(e ->e.getContinent().equals("South America"));
		
		list =  mapper.selectByContinent("Antarctica");
		assertThat(list).allMatch(e ->e.getContinent().equals("Antarctica"));
	}
	
	@Test
	void allmatch() {
		
		var list = new ArrayList<Boolean>();
		list.add(true);
		list.add(true);
		list.add(true);
		assertThat(list).allMatch(e ->(boolean)e);
	
		var list1 = new ArrayList<Integer>();
		list1.add(10);
		list1.add(20);
		list1.add(30);
		assertThat(list1).allMatch(e -> e<40);
	}
	
	@Test
	void sel() {
		var list =  mapper.selectByContinentAndRegion("Asia", "Eastern Asia");
	     list.forEach(c -> System.out.println(c));
	     assertThat(list).allMatch(c ->c.getContinent().equals("Asia")&&c.getRegion().equals("Eastern Asia"));
	}
}
