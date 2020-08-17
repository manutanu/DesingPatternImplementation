package org.designpattern.creational.factorypattern;

public class Demo {

	public static void main(String[] args) throws Exception {
		AnimalFactory animalFacotry = AnimalFactory.getFactoryInstance();
		System.out.println(animalFacotry);
		Dog dog = animalFacotry.getDog(4, "fluffy");
		Cat cat = animalFacotry.getCat(3, "wisker");
		Bird bird = animalFacotry.getBird(5, "twitter");
		
		System.out.println(dog);
		System.out.println(cat);
		System.out.println(bird);
		
		AnimalFactory newanimalFacotry = AnimalFactory.getFactoryInstance();
		System.out.println(newanimalFacotry);
		Dog jacky = newanimalFacotry.getDog(5, "jacky");
		System.out.println(jacky);
		
	}

}
