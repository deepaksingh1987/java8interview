package com.java8.future;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {

	public static void printpersionDetails() {
		BiConsumer<String, List<String>>biConsumerPerson=(name,hobbies)->{System.out.println("Name::"+name+" Hobbies ::"+hobbies);};
		BiConsumer<String, Double>salaryconsummer=(name,salary)->{System.out.println("Name is::"+name+" salary::"+salary);};
		List<Person>personslist=PersonRepository.getAllPerson();
		personslist.forEach(per->{
			biConsumerPerson.accept(per.getName(), per.getHobbies());
			salaryconsummer.accept(per.getName(), per.getSalary());
		});
	}
	public static void main(String[] args) {
		printpersionDetails();

	}

}
