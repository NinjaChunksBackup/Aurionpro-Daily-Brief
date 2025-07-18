package com.aurionpro.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPractice {

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Mayuri", "Rohan", "Manish", "Suraj");

      
        List<String> result = names.stream()
                                   .filter(name -> name.startsWith("M"))
                                   .collect(Collectors.toList());

        System.out.println("Names starting with M: " + result);
        
        System.out.println("----------------------------------------------");
	
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> squares = numbers.stream()
                                       .filter(n -> n % 2 == 0)
                                       .map(n -> n * n)
                                       .collect(Collectors.toList());

        System.out.println("Even number squares: " + squares);
        
        System.out.println("----------------------------------------------");
		
		List<List<Integer>> list = Arrays.asList((Arrays.asList(1,2,3))
				, Arrays.asList(3,4,5),Arrays.asList(5,6,7));
		
		
		List<Integer> result1  =
				list.stream()
				.flatMap(s -> s.stream())
//				.peek(s -> System.out.println(s + " " ))
				.distinct()
				.sorted((a,b) -> b - a)
				.collect(Collectors.toList());
		
		System.out.println("the flatmap list is :" +result1);

	}

}