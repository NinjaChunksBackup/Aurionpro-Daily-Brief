package com.aurionpro.generics_extendEx;

public class Dog extends Animal {

	private String name;

	public Dog(String name) {
		super();
		this.name = name;
	}

	@Override
	void eat() {
		System.out.println("Dog eat");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
