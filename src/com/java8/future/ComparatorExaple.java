package com.java8.future;

import java.util.Comparator;

public class ComparatorExaple {

	public static void main(String[] args) {
		Comparator<Integer>c1=new Comparator<Integer>() {

			@Override
			public int compare(Integer x, Integer y) {
				
				return x.compareTo(y);
			}
		};
		System.out.println("Comparator1::"+c1.compare(10, 15));
		
		Comparator<Integer>c2=(Integer x,Integer y)->x.compareTo(y);
		System.out.println("Comparator2 ::"+c2.compare(10, 15));
		
		Comparator<Integer>c3=(x,y)->x.compareTo(y);
		System.out.println("Comparator3 ::"+c3.compare(10, 15));

	}

}
