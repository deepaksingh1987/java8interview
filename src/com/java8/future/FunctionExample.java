package com.java8.future;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionExample {

	static Function<List<Person>, Map<String, Double>>f1=personList->{
		Map<String, Double>map=new HashMap<String, Double>();
		personList.forEach(per->{
			map.put(per.getName(), per.getSalary());
		});
		return map;
	};
	public static void main(String[] args) {
		List<Person>person=PersonRepository.getAllPerson();
		Map<String, Double>map=	f1.apply(person);
		System.out.println(map);

	}

}
