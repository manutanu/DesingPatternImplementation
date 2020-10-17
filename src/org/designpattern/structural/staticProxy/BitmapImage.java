package org.designpattern.structural.staticProxy;

public class BitmapImage implements Image {

	private int x ;
	private int y ;
	private String name;
	
	BitmapImage(String name){
		this.name = name;
		System.out.println("Loaded image with name "+name+" from disk");
	}
	
	@Override
	public int getCoordinates() {
		return x + y;
	}

	@Override
	public void setCoordinates(int x, int y) {
		this.x = x ;
		this.y = y;
	}

	@Override
	public void render() {
		System.out.println("Render loaded image to show in 2d format");
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
