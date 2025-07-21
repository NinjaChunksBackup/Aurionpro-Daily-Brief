package com.ap.TemplateDP.one;

public class TemplateTest {
	public static void main(String[] args) {
		
		DocumentConverter dc1 = new Pdf();
		dc1.CovertDoc();
		
		
		System.out.println();
		
		
		DocumentConverter dc2 = new Word();
		dc2.CovertDoc();
		
		
	}

}
