package com.java8.future;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java7Vsjava8Example2 {

	public static void main(String[] args) {
		
		List<String>names=Arrays.asList("Deepak","Sam","Alli","Deepak","Aahan");
		
		List<String>uniqueName=new ArrayList<String>();
		
		for(String name:names) {
			
			if(!uniqueName.contains(name)) {
				
				uniqueName.add(name);
			}
		}
		
		System.out.println("Unique Name 1 ::"+uniqueName);
		
		List<String>uniqueName1=names.stream().distinct().collect(Collectors.toList());
        
		System.out.println("Unique Name 2 ::"+uniqueName1);
	}

}
