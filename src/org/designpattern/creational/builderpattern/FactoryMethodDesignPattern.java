package org.designpattern.creational.builderpattern;

class Point{
	
	int x ;
	int y ;
	
	private Point(int a , int b ) {
		x = a;
		y = b;
	}
	
	// its a Factory which groups different factoryMethods into one Factory
	public static class Factory{
		
		public static Point getCartesianPoint(int x , int y) {
			return new Point(x , y);
		}
		
		public static Point getPolarizedPoint(int rho , int theta) {
			return new Point(rho , theta);
		}
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
}

public class FactoryMethodDesignPattern {
	// getting Point object using Factory Design Pattern
	public static void main(String args[]) {
		
		Point cartesianPoint = Point.Factory.getCartesianPoint(10 , 12);
		Point polarizPoint = Point.Factory.getPolarizedPoint(2, 4);
		System.out.println(cartesianPoint.toString());
		System.out.println(polarizPoint.toString());
		
	}
}
