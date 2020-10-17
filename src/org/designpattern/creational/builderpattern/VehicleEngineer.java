package org.designpattern.creational.builderpattern;

public class VehicleEngineer {
	
	
	public Car makeSwift(VehicleBuilder builder) {
		builder.reset();
		builder.setVehicleWheels(4);
		builder.setTrolly(false);
		builder.setVehicleCapacity(5);
		builder.setVehicleType("HUMP_BACK");
		return builder.getVehicle();
	}
	
	public Car makeTractor(VehicleBuilder builder) {
		builder.reset();
		builder.setVehicleWheels(8);
		builder.setTrolly(true);
		builder.setVehicleCapacity(2);
		builder.setVehicleType("HEAVY");
		return builder.getVehicle();
	}
	
	public Car makeXUV(VehicleBuilder builder) {
		builder.reset();
		builder.setVehicleWheels(4);
		builder.setTrolly(false);
		builder.setVehicleCapacity(8);
		builder.setVehicleType("XUV");
		return builder.getVehicle();
	}
}
