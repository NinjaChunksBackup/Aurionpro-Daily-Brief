package com.aurionpro.generics_extendEx;

import java.util.ArrayList;
import java.util.List;


public class AnimalTest {

	public static void main(String[] args) {
		
		
		Printer2<Animal> p = new Printer2<>(new Cat("kitty"));
		p.print();
		Printer2<Animal> p2 = new Printer2<>(new Dog("tommy"));
		p2.print();
		
		
		
		
		List<Integer> inList = new ArrayList<>();
		inList.add(3);
		printList(inList);
		
		List<Cat> catList = new ArrayList<>();
		catList.add(new Cat("cat"));
		printList(catList);
		
		
		List<Dog> dogList = new ArrayList<>();
		dogList.add(new Dog("tommy"));
		printListAnimal(dogList);
		printListAnimal(catList);
		
		
		
		
		
	}
	public static void printList(List<?> myList) {
		System.out.println(myList);
	}
	
	public static void printListAnimal(List<? extends Animal> myList) {
		System.out.println(myList);
	}

}
