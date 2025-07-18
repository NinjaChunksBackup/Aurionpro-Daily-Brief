package com.aurionpro.generics_extendEx;

public class Printer2 <T extends Animal>{
	
	T anything;
	
	public Printer2(T anything) {
		this.anything = anything;
	}
	
	public void print() {
		anything.eat();
	}
	
}
