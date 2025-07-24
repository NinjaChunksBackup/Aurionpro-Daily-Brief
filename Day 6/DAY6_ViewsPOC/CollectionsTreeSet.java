package com.aurionpro.five;

import java.util.Set;
import java.util.TreeSet;

public class CollectionsTreeSet {
	public static void main(String[] args) {
		
		Set<String> fruits = new TreeSet<>();

        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Cherry");
        fruits.add("Banana"); // d;uplicate, ignored
//        fruits.add(null);

        System.out.println("TreeSet:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        
        
        
        Set<Integer>  num = new TreeSet<>();
        
        num.add(30);
        num.add(10);
        num.add(200);
        num.add(2);
        
        
        System.out.println("TreeSet:");
        for (Integer i : num) {
            System.out.println(i);
        }
        
	}

}
