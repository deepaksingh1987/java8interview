package com.employeebaseprogram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeDriver {
	
	public static void method1(List<Employee> employeeList) {
		
		//1)How many male and female employees are there in organization
		  
	  Map<String,Long>map=employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		
	  for(Entry<String, Long>entry:map.entrySet()) {
		  
		  System.out.println(entry.getKey()+" "+entry.getValue());
	  }
	}
	public static void method2(List<Employee> employeeList) {
		//2)print name of all department in the organization
		
	List emp=employeeList.stream().map(e->e.getDepartment()).distinct().collect(Collectors.toList());
		
		System.out.println(emp);
	}
	public static void method3(List<Employee> employeeList) {
		//3)what is average age of male and female  Employee
		 
	Map<String, Double>map=	employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
	
	for(Entry<String, Double>entry:map.entrySet()) {
		System.out.println(entry.getKey()+" "+entry.getValue());
	}
		
	}
	
	public static void method4(List<Employee> employeeList) {
		//4)Get the details of highest paid employee in the organization?
	Optional<Employee>salary=employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
	
	Employee details=salary.get();
	
		System.out.println("Name="+details.getName()+" salary="+details.getSalary());
		
		Optional<Employee>age=employeeList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getAge)));
		
		Employee eage=age.get();
		System.out.println("Name="+eage.getName()+" Age="+eage.getAge());
	}
	public static void method5(List<Employee> employeeList) {
		//5)Get the names of all employees who have joined after 2015?
		employeeList.stream().filter(e->e.getYearOfJoining()>2015).map(Employee::getName).forEach(System.out::print);
		
	}
	
	public static void method6(List<Employee> employeeList) {
		//6)Count the number of employees in each department?
	Map<String,Long>countdep=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
	System.out.println(countdep);
		
	}
	public static void method7(List<Employee> employeeList) {
		//7)What is the average salary of each department?
		Map<String,Double>avgsal=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
		
		Set<Entry<String,Double>>entryset=avgsal.entrySet();
		for(Entry<String,Double>entry:entryset) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}
	public static void method8(List<Employee> employeeList) {
		//8)Get the details of youngest male employee in the product development department?
	Optional<Employee>youngest=	employeeList.stream().filter(e->e.getGender()=="Male" && e.getDepartment()=="Product Development").min(Comparator.comparingInt(Employee::getAge));
	Employee emp=youngest.get();
	System.out.println(emp.getName()+" "+emp.getAge());
	}
	public static void method9(List<Employee> employeeList) {
		//9)Who has the most working experience in the organization?
	Optional<Employee>mostexp=	employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
	Employee emp=mostexp.get();
	System.out.println(emp.getName()+" "+emp.getYearOfJoining());
	}
	public static void method10(List<Employee> employeeList) {
		//10)How many male and female employees are there in the sales and marketing team?
	Map<String,Long>map=	employeeList.stream().filter(e->e.getDepartment()=="Sales And Marketing").collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
	System.out.println(map);
	}
	public static void method11(List<Employee> employeeList) {
		//11)What is the average salary of male and female employees?
	Map<String,Double>map=	employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(map);
	}

	public static void method12(List<Employee> employeeList) {
		//12) List down the names of all employees in each department?
	Map<String,List<Employee>>emplist=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
	Set<Entry<String,List<Employee>>>empentry=emplist.entrySet();
	
	for(Entry<String,List<Employee>>entryes:empentry) {
		System.out.println("--------------------------------------");
        
	    System.out.println("Employees In "+ entryes.getKey() + " : ");
	             
	    System.out.println("--------------------------------------");
	             
	    List<Employee> list = entryes.getValue();
	    for(Employee es:list) {
	    	System.out.println(es.getName());
	    }
	}
	
	}
	public static void method13(List<Employee> employeeList) {
		//13)What is the average salary and total salary of the whole organization?
	 double doubles= employeeList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
	 System.out.println(doubles);
	DoubleSummaryStatistics doublesum= employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
	System.out.println("Average ::"+doublesum.getAverage());
	System.out.println("Total Sum "+doublesum.getSum());
	
	}
	public static void method14(List<Employee> employeeList) {
		//14) Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
	Map<Boolean,List<Employee>>emp=employeeList.stream().collect(Collectors.partitioningBy(e-> e.getAge()>25));
		
		Set<Entry<Boolean,List<Employee>>>entryset=emp.entrySet();
		for(Entry<Boolean,List<Employee>>entry:entryset) {
			if(entry.getKey()) {
				System.out.println("Employees older than 25 years :");
			}else {
				System.out.println("Employees younger than or equal to 25 years :");
			}
			System.out.println("-------------------");
			List<Employee>list=entry.getValue();
			for(Employee e:list) {
				System.out.println(e.getName());
			}
		}
	}
	public static void method15(List<Employee> employeeList) {
		//15)Who is the oldest employee in the organization? What is his age and which department he belongs to?
		Optional<Employee> oldestEmployeeWrapper=employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getAge)));
		Employee emp=oldestEmployeeWrapper.get();
		 System.out.println("Name::"+emp.getName());
		 System.out.println("age::"+emp.getAge());
	}
	public static void method16(List<Employee> employeeList) {
		//16)increment Salary who age is 25 in Employee
	
	Map<Double,List<Employee>>map=employeeList.stream().filter(e->e.getAge()>27).collect(Collectors.groupingBy(Employee::getSalary));
	
	
	
	for(Entry<Double,List<Employee>>entry:map.entrySet()) {
		List<Employee>lisemp=entry.getValue();
		for(Employee e:lisemp) {
			
			System.out.println("Name ->"+e.getName()+", Age->"+e.getAge()+",Salary->"+e.getSalary());
		}
		System.out.println("------------------");
		double salary=entry.getKey();
		System.out.println("Base Salry "+salary);
		System.out.println("After Increment ::");
		System.out.println(salary+(salary*10/100));
		System.out.println("------------------");
		
		
		
	}
	
	
	
	}
	public static void method17(List<Employee> employeeList) {
		//17)Using stream(), try to remove the white-spaces in the string values in the list and try generate a new list with the unique string values from it.
		//(" abc dd", " abcd d", " acc dd", " a c c d d ", "a bcddd")
		List<String>list=Arrays.asList(" abc dd"," abcd d"," acc dd"," a c c d d"," a c c d d"," a bcddd");
		List<String>newlist=list.stream().map(e->e.replaceAll(" ", "")).distinct().collect(Collectors.toList());
		
		System.out.println(newlist);
	}
	public static void method18(List<Employee> employeeList) {
		//18)Using stream() API sort the below list in reverse order by Value
		//[("a",3),("b",4),("c",76),("d",43)]
		Map<String,Integer>map=new HashMap<String, Integer>();
		
		map.put("a", 3);
		map.put("b", 4);
		map.put("c", 76);
		map.put("d", 43);
		List<Map<String,Integer>>list=new ArrayList<Map<String,Integer>>();
		list.add(map);
	//List<Map<String,Integer>>listmap=list.stream().sorted().collect(Collectors.toList());
	
		Map<String, Integer> sortedByValueDesc=	map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
		.collect(Collectors.toMap(Map.Entry::getKey,
				  Map.Entry::getValue,(e1,e2)->e1,
				  LinkedHashMap::new));
		System.out.println(sortedByValueDesc);
		
	 
	 
	}
	public static void method19(List<Employee> employeeList) {
		//19)Provide Employee Name, who get 2nd Highest Salary from an Employee Collection. Employee Collection have 3 attribute => id, name and salary. Highest Salaried and Second Highest Salaried employees can be multiple.
	Optional<Double>emp=employeeList.stream().map(e->e.getSalary()).sorted(Comparator.reverseOrder()).skip(2).findFirst();	 
	  System.out.println(emp.get());
	  
	Optional<Employee>stortedemp=employeeList.stream()
			.sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst();
		System.out.println(stortedemp.get());
		
		
		
	}
	public static void method20(List<Employee> employeeList) {
		//20)find the heigest salary for each department
	
		
		Map<String, Employee> topEmployees1 =employeeList.stream().collect(Collectors.groupingBy(e->e.getDepartment(),Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(e->e.getSalary())), Optional::get)));
			
		for(Entry<String, Employee>entry:topEmployees1.entrySet()) {
			
			Employee sal=entry.getValue();
			
			System.out.println("Department Name::::"+entry.getKey() +" :: heigest Sal ::"+sal.getSalary());
			
		}
		System.out.println("--------------------------------------");
		Map<String, Employee> topEmployees2=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));
		
       for(Entry<String, Employee>entry:topEmployees2.entrySet()) {
			
			Employee sal=entry.getValue();
			
			System.out.println("Department Name::::"+entry.getKey() +" :: heigest Sal ::"+sal.getSalary());
			
		}
		}
	public static void printDublicateCharjava8() {
		String name="deepakkumarsinghhDeepak";
		String lowname=name.toLowerCase();
		//Count Dublicate from String
		List<String>liststr=Arrays.asList(name.toLowerCase());
	    Map<String,Long>str=liststr.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	   // System.out.println(str);
	     
	    List<String>dunlicatestr=liststr.stream().filter(s->Collections.frequency(liststr, s)>1).collect(Collectors.toList());
	    // System.out.println(dunlicatestr);
	     
	    Map<Character,Integer>map=new HashMap<Character, Integer>();
	    char[]chr=lowname.toCharArray();
	   
	    for(int i=0; i<lowname.length(); i++) {
	    	
	    	 char ch=chr[i];
	    	if(map.containsKey(chr[i])) {
	    		
	    		map.put(ch, map.get(ch)+1);
	    	}else {
	    		map.put(ch, 1);
	    	}
	    }
	    for(Entry<Character, Integer>entryset:map.entrySet()) {
	    	if(entryset.getValue()==1) {
	    		System.out.print(entryset.getKey()+"="+entryset.getValue());
	    	}
	    }
	}
	
	public static void main(String[] args) {
		
		List<Employee> employeeList = new ArrayList<Employee>();
        
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		
		//EmployeeDriver.method1(employeeList);
		//EmployeeDriver.method2(employeeList);
		//EmployeeDriver.method3(employeeList);
		//EmployeeDriver.method4(employeeList);
		//EmployeeDriver.method5(employeeList);
		//EmployeeDriver.method6(employeeList);
		//EmployeeDriver.method7(employeeList);
		//EmployeeDriver.method8(employeeList);
		//EmployeeDriver.method9(employeeList);
		//EmployeeDriver.method10(employeeList);
		//EmployeeDriver.method11(employeeList);
		//EmployeeDriver.method12(employeeList);
		// EmployeeDriver.method13(employeeList);
		 //EmployeeDriver.method14(employeeList);
		// EmployeeDriver.method16(employeeList);
		// EmployeeDriver.method17(employeeList);
		// EmployeeDriver.method18(employeeList);
		// EmployeeDriver.method19(employeeList);
		// EmployeeDriver.method20(employeeList);
		  // EmployeeDriver.printDublicateCharjava8();
		
	}

}
