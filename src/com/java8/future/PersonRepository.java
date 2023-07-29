package com.java8.future;

import java.util.Arrays;
import java.util.List;

public class PersonRepository {

	public static List<Person> getAllPerson(){
		
		Person p1=new Person("Deepak",10,2000.0,"Male",2,Arrays.asList("Cricket","Swimming","Tenis"));
		Person p2=new Person("John",165,2000,"Male",2,Arrays.asList("Driving","Swimming","Tenis"));
		Person p3=new Person("Angel",158,5000,"Female",2,Arrays.asList("Cricket","Football","Driving"));
		Person p4=new Person("Dean",140,5700,"Male",2,Arrays.asList("Football","Cricket","Swimming"));
		Person p5=new Person("Nancy",130,4900,"Female",2,Arrays.asList("Music","Cricket","Tenis"));
		Person p6=new Person("Harper",125,9000,"Female",2,Arrays.asList("Tenis","Football","Swimming"));
		Person p7=new Person("Alan",110,9500,"Male",2,Arrays.asList("Swimming","Driving","Football"));
		
		return Arrays.asList(p1,p2,p3,p4,p5,p6,p7);
	}
	
	public static Person getPerson() {
		
		return new Person("Deepak",10,2000.0,"Male",2,Arrays.asList("Cricket","Swimming","Tenis"));
	}
	
}
