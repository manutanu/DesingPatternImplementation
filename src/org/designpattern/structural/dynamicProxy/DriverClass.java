package org.designpattern.structural.dynamicProxy;

public class DriverClass {

	public static void main(String[] args) {
		Image image = ImageFactory.getImage("Mritunjay.jpeg");
		image.setCoordinates(10, 11);
		System.out.println(image.getCoordinates());
		image.render();

	}

}
