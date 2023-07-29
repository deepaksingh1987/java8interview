package com.java8.future;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample2 {
	
	public static List<String> getNameToUperCase(List<Person>listOfPerson){
		
		return listOfPerson.stream()
				.map(Person:: getName)
				.map(String :: toUpperCase)
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		List<String>fruits=Arrays.asList("Apple","Banana","Orange","PineApple");
	    List<Integer>number=	fruits.stream().map(String:: length)
		.collect(Collectors.toList());	
	    System.out.println(number);
	    
	    System.out.println("All Name ::"+getNameToUperCase(PersonRepository.getAllPerson()));
	}
	
	

}
