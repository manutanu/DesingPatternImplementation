package org.designpattern.creational.factorypattern;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class AnimalFactory implements Serializable , Cloneable{
	
	private static volatile AnimalFactory factoryInstance = null;
	private int uuid = 0;
	
	private AnimalFactory() {}
	
	public static synchronized AnimalFactory getFactoryInstance() throws Exception {
		if(factoryInstance == null) {
			factoryInstance = new AnimalFactory();
		}else {
			System.out.println("You cant create new instance of a singleton class");
		}
		return factoryInstance;
	}
	
	public Dog getDog( int age , String name ) {
		Dog dog = new Dog();
		dog.setAnimalId(uuid++);
		dog.setAnimalage(age);
		dog.setAnimalname(name);
		dog.setSound("bow bow ");
		return dog ;
	}

	public Cat getCat( int age , String name ) {
		Cat cat = new Cat();
		cat.setAnimalId(uuid++);
		cat.setAnimalage(age);
		cat.setAnimalname(name);
		cat.setSound("meow meow");
		return cat;
	}
	
	public Bird getBird( int age , String name ) {
		Bird bird = new Bird();
		bird.setAnimalId(uuid++);
		bird.setAnimalage(age);
		bird.setAnimalname(name);
		bird.setSound("chirp chirp");
		return bird;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		throw new CloneNotSupportedException();
	}
	
	 private Object readResolve() throws ObjectStreamException{
	        System.out.println("We have already created instance");
	        return factoryInstance;
	  }
	 
}
