package org.designpattern.structural.staticProxy;

public class ImageFactory {
	
	public static Image getImage(String name) {
		return new ImageProxy(name);
	}
}
