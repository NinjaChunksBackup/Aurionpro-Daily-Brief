package com.aurionpro.five;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CollectionsHashSet {
	public static void main(String[] args) {
		
//		Set<String> fruits = new LinkedHashSet<>();
//
//        fruits.add("Banana");
//        fruits.add("Apple");
//        fruits.add("Mango");
//        fruits.add("Cherry");
//        fruits.add("Banana"); // duplicate, ignored
//        fruits.add(null);
//        fruits.add(null);
//
//        System.out.println("LinkedHashSet:");
//        for (String fruit : fruits) {
//            System.out.println(fruit);
//        }
//		
		
		
		
		
		int size = 10000;
		
        String target = "item9980";


        
        
        List<String> itemList = new ArrayList<>();
        
        Set<String> itemSet = new HashSet<>();

        for (int i = 0; i < size; i++) {
        	
            String item = "item" + i;
            
            itemList.add(item);
            itemSet.add(item);
        }

     
        long startList = System.nanoTime();
        boolean listContains = itemList.contains(target);
        long endList = System.nanoTime();

   
        long startSet = System.nanoTime();
        boolean setContains = itemSet.contains(target);
        long endSet = System.nanoTime();

        // Print results
        System.out.println("List contains? " + listContains + " | Time: " + (endList - startList) + " ns");
        System.out.println("Set contains?  " + setContains + " | Time: " + (endSet - startSet) + " ns");
        
        
	}

}
