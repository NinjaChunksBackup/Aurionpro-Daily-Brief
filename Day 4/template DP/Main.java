package com.aurionpro.model;

public class Main {

	public static void main(String[] args) {
		
		 DataProcessor processor;

	        System.out.println("=== Excel Processing ===");
	        processor = new ExcelDataProcessor();
	        processor.process();

	        System.out.println("\n=== CSV Processing ===");
	        processor = new CSVDataProcessor();
	        processor.process();
	}

}
