package com.java8.future;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample1 {

	public static void main(String[] args) {
		Stream<Integer>s1=Stream.of(10,20,30,40);
		s1.forEach(p->System.out.println(p));
		Predicate<Person>p1=per->per.getHeight()>140;
		Predicate<Person>p2=per->per.getGender().equalsIgnoreCase("Male");
		Map<String, List<String>>personMap=PersonRepository
				.getAllPerson()
				.stream()
				.filter(p1)
				.filter(p2)
				.collect(Collectors.toMap(Person::getName, Person::getHobbies));
		System.out.println("Person Details ::"+personMap);
		
		List<String>hobbies=PersonRepository
				.getAllPerson()
				.stream()
				.map(Person::getHobbies)
				.flatMap(List::stream)
				.distinct()
				.collect(Collectors.toList());
		
		System.out.println("hobbies ::"+hobbies);
		
		List<String>names=new ArrayList<String>();
		names.add("Deepak");
		names.add("Kumar");
		names.add("Singh");
		
		Stream<String>stream=names.stream();
		stream.forEach(n -> System.out.println(n));
		
		
		List<String>lists=PersonRepository
				.getAllPerson()
				.stream()
				.peek(per->System.out.println(per))
				.map(Person::getName)
				.peek(System.out::println )
				.collect(Collectors.toList());

	}

}
