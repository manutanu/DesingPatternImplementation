package org.designpattern.structural.staticProxy;

public class DriverClass {

	public static void main(String[] args) {
		Image image = ImageFactory.getImage("Mritunjay.jpg");
		image.setCoordinates(10 , -10);
		System.out.println(image.getCoordinates());
		image.render();

	}

}
