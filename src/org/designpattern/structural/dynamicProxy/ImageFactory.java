package org.designpattern.structural.dynamicProxy;

import java.lang.reflect.Proxy;

public class ImageFactory {
	
	public static Image getImage(String name) {
		System.out.println(ImageFactory.class.getClassLoader());
		return (Image)Proxy.newProxyInstance(ImageFactory.class.getClassLoader() , new Class[] {Image.class} , new ImageInvocationHandler(name));
	}
}
