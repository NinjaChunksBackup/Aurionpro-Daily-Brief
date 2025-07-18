package com.aurionpro.generics;

public class Printer <T>{
	
	T anything;
	
	public Printer(T anything) {
		this.anything = anything;
	}
	
	public void print() {
		System.out.println(anything);
	}
	
}
