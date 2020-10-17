package org.designpattern.structural.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;



public class ImageInvocationHandler implements InvocationHandler {

	private static Method getCoordinates;
	private static Method setCoordinates;
	private static Method render;
	private BitmapImage bitImage ;
	private String name;
	private int xcache ;
	private int ycache;
	
	ImageInvocationHandler(String name){
		this.name = name;
	}
	
	static {
		try {
			getCoordinates = Image.class.getMethod("getCoordinates" , new Class[] {});
			setCoordinates = Image.class.getMethod("setCoordinates" , new Class[] {int.class , int.class });
			render = Image.class.getMethod("render" , new Class[] {});
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(method.equals(getCoordinates)) {
			return handleGetCoordinates();
		}else if(method.equals(setCoordinates)) {
			handleSetCoordinates((int)args[0], (int)args[1]);
		}else if(method.equals(render)){
			handleRender();
		}
		return null;
	}
	
	
	public int handleGetCoordinates() {
		System.out.println("logs dynamic proxy ---------- Get coordinates method called ------------");
		if(bitImage != null) {
			return bitImage.getX() + bitImage.getY();
		}else {
			return xcache + ycache;
		}
	}
	
	
	public void handleSetCoordinates(int x, int y) {
		System.out.println("logs ---------- Set coordinates method called ------------");
		if(bitImage != null) {
			bitImage.setX(x);
			bitImage.setY(y);
		}else {
			xcache = x;
			ycache = y;
		}
	}


	public void handleRender() {
		System.out.println("logs ---------- Render method called on image ------------");
		if(bitImage != null) {
			bitImage.render();
		}else {
			bitImage = new BitmapImage(name);
			bitImage.setX(xcache);
			bitImage.setY(ycache);
			bitImage.render();
		}
		
	}
	
}
