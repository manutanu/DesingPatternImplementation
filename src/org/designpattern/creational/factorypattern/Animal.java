package org.designpattern.creational.factorypattern;

public abstract class Animal {

	private int animalId;
	private String animalname ;
	private int animalage;
	private String sound;
	private String food ;
	
	public int getAnimalId() {
		return animalId;
	}
	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}
	public String getAnimalname() {
		return animalname;
	}
	public void setAnimalname(String animalname) {
		this.animalname = animalname;
	}
	public int getAnimalage() {
		return animalage;
	}
	public void setAnimalage(int animalage) {
		this.animalage = animalage;
	}
	
	public void setSound(String sound) {
		this.sound = sound;
	}

	public void setFood(String food) {
		this.food = food;
	}
	public abstract String sound(String sound) ;
	public abstract String favouriteFood(String food );
	@Override
	public String toString() {
		return "Animal [animalId=" + animalId + ", animalname=" + animalname + ", animalage=" + animalage + ", sound="
				+ sound + ", food=" + food + "]";
	}
	
	
	
}
