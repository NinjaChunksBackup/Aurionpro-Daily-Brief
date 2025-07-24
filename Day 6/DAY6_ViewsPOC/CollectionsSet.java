
//A Set is a collection that cannot contain duplicate elements.
//
//It does not preserve insertion order (except some implementations).
//
//It is part of the java.util package



//
//No duplicates	Adding a duplicate element is ignored.
//At most one null	
//No indexing
package com.aurionpro.five;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class CollectionsSet {
	public static void main(String[] args) {
		
		Set<String> fruits = new HashSet<>();

        fruits.add("Apple");
        
        fruits.add("Banana");
        fruits.add("Mango");
        

        fruits.add("cherry");
        
        fruits.add("cherry");
        fruits.add(null);
        
        
//        Collections.sort(fruits);
        

        
//        // Convert to LinkedHashSet
//        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(fruits);
//
//        // Print the LinkedHashSet
//        System.out.println("LinkedHashSet: " + linkedHashSet);
        
        

        
       System.out.println(fruits);
       fruits.remove("cherry");
       System.out.println(fruits);
       
    
//        
       System.out.println("*******************************");
        
        
        // new set
        
        Set<String> cities = new HashSet<>();
        
        cities.add("Mumbai");
        cities.add("Delhi");
        cities.add("Bangalore");
        
        
        Set<String> cities1 = new HashSet<>();
        cities1.add("indore");
        cities1.add("bhopal");
        
        System.out.println(cities1);
        
        
        cities.addAll(cities1);
        System.out.println("main set "+cities);
        
        
        System.out.println(cities.isEmpty()); 
        
//        cities.remove("bhopal");
//        cities.removeAll(cities1);
        
            
        System.out.println();
        
        String[] c2 = cities.toArray(new String[0]);
        for(int i=0;i<c2.length;i++) {
        	System.out.println(c2[i]);
        }
        
        
        System.out.println();
        
        
        Iterator itr = cities.iterator();
        while(itr.hasNext()) {
        	System.out.println(itr.next());
        }
        
        

        System.out.println();
        
        Set<String> a = new HashSet<>(List.of("A", "B", "C","E","F"));
        Set<String> b = new HashSet<>(List.of("B", "C", "D"));
        
        
        System.out.println("SET A : "+a);
        System.out.println("SET B : "+b);

        
        System.out.println();
        
        Set<String> union = new HashSet<>(a);
        union.addAll(b); // A, B, C, D
        
        System.out.println(union);
        
        
        

        Set<String> intersection = new HashSet<>(a);
        intersection.retainAll(a); // B, C
        System.out.println(intersection);
        
        System.out.println(b);
        
        
        
        

        Set<String> difference = new HashSet<>(a);
        difference.removeAll(b); // Removes common elements of b from a
        
       
        System.out.println("Difference (a - b): " + difference); // [A]
        
        
        
        Set<String> testSet = new LinkedHashSet<>();
        testSet.add("Banana");
        testSet.add("Apple");
        testSet.add("Orange");
        testSet.add("Mango");
        testSet.add("Pineapple");
        testSet.add("Grapes");
        testSet.add("Kiwi");
        testSet.add("Papaya");
        testSet.add("Watermelon");

        System.out.println("HashSet order: " + testSet);
        
     
        
		
	}

}
