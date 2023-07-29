package com.java8.future;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerPerson {
	static Consumer<Person>con1=(p)->{System.out.println(p);};
	
	static Consumer<Person>con2=(p)->{System.out.println(p.getName().toUpperCase());};
	static Consumer<Person>con3=(p)->{System.out.println(p.getHobbies());};
	
	static List<Person>getAllPersonList=PersonRepository.getAllPerson();
	
	static void printNameAndHobbies() {
		getAllPersonList.forEach(con1.andThen(con2));
	}
	
	static void conditionBase() {
		
		getAllPersonList.forEach(p->{
			if(p.getGender().equals("Male") && p.getHeight()>125) {
				con2.andThen(con3).accept(p);
			}
		});
	}
	

	public static void main(String[] args) {
		
		//con1.accept(PersonRepository.getPerson());
		//con2.accept(PersonRepository.getPerson());
		//con3.accept(PersonRepository.getPerson());
		//con1.andThen(con2).andThen(con3).accept(PersonRepository.getPerson());
		
		//printNameAndHobbies();
		conditionBase();
	}

}
