package org.designpattern.creational.builderpattern;

public class MainDriver {

	public static void main(String[] args) {
		VehicleBuilder builder = new CarBuilder();
		VehicleEngineer engineer = new VehicleEngineer();
		Car swift = engineer.makeSwift(builder);
		System.out.println(swift.toString());
		Car xuv = engineer.makeXUV(builder);
		System.out.println(xuv.toString());
		Car tractor = engineer.makeTractor(builder);
		System.out.println(tractor.toString());
	}

}
