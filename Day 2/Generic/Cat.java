package com.aurionpro.generics_extendEx;

public class Cat extends Animal{
	private String name;
	
	
	
	public Cat(String name) {
		super();
		this.name = name;
	}

	@Override
	void eat() {
		System.out.println("cat eat");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
