package com.aurionpro.model;

public class AithmeticSolution {

	public static void main(String[] args) {
		
		//with exception
        int a = 10;
        int b = 0;

        try {
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException is there " + e.getMessage());
        }

        
        int a1 = 15;
        int b1 = 0;

        try {
            int result = a1 % b1;  
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException is there  " + e.getMessage());
        }
        
	}
}
