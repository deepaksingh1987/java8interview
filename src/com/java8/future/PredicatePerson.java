package com.java8.future;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicatePerson {
	
	static Predicate<Person>predicatePerson1=p -> p.getHeight()>=140;
	static Predicate<Person>predicatePerson2=p -> p.getGender().equals("Male");
	static BiConsumer<String, List<String>>biConsumer=(name,hobbies)->{System.out.println("Name::"+name+" Hobbies::"+hobbies);};
    static Consumer<Person>consumerPerson=per->{
    	if(predicatePerson1.and(predicatePerson2).test(per)) {
    		
    		biConsumer.accept(per.getName(), per.getHobbies());
    	}
    };
	public static void main(String[] args) {
		List<Person>listPerson=PersonRepository.getAllPerson();
		listPerson.forEach(consumerPerson);
		//listPerson.stream().filter(predicatePerson1).collect(Collectors.toList());
		
		/*
		 * listPerson.forEach(per->{
		 * if(predicatePerson1.and(predicatePerson2).test(per)) System.out.println(per);
		 * });
		 */

	}

}
