package com.aurionpro.generics;

import java.util.List;

public class GenericsExample {

	public static void main(String[] args) {
		
		//allows you to write code that works with different data types
		//while ensuring type safety at compile time.
		
		
		
		IntegerPrinter ip = new IntegerPrinter(30);
		ip.print();
		
		
		
		//=================
	
		Printer<Integer> p1 = new Printer<>(23);
		p1.print();
		
		Printer<String> p2 = new Printer<>("suraj");
		p2.print();
		
		Printer<Double> p3 = new Printer<>(1.0);
		p3.print();
		
		
		//================
		display("suraj");
		display(30);
		display(0.6);
		display(true);
		
		twoDisplay("suraj", "Transit");
		
		int num = returnThing(50);
		System.out.println(num);
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	public static <T> void display(T anything) {
		System.out.println(anything);
	}
	
	
	
	public static <T,V> void twoDisplay(T first ,V second) {
		System.out.println(first);
		System.out.println(second);
	}
	
	
	public static <T> T returnThing(T thing) {
		
		
		return thing;
	}
	
	
	public static void printList(List<?> myList) {
		System.out.println();
	}

}
