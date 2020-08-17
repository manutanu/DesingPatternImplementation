package org.designpattern.creational.factorypattern;

public class Dog extends Animal {

	@Override
	public String sound(String sound) {
		return sound;
	}

	@Override
	public String favouriteFood(String food) {
		return food;
	}
	
}
