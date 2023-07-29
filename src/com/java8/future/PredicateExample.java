package com.java8.future;

import java.util.function.Predicate;

public class PredicateExample {
	
	public static void printpredicate() {
		Predicate<Integer>lessthan= a ->(a<=50);
		Predicate<Integer>greaterThan=a->(a>150);
		Predicate<Integer>equalsto=a->(a==0);
		
		boolean l1=lessthan.test(20);
		System.out.println("LessThan::"+l1);
		
		boolean l2=greaterThan.test(200);
		System.out.println("GreaterThan::"+l2);
		
		boolean l3=equalsto.test(0);
		System.out.println(l3);
		
		boolean result=lessthan.and(greaterThan).and(equalsto).test(0);
		System.out.println("Result::"+result);
		
	}

	public static void main(String[] args) {
		printpredicate();
		
	}

}
