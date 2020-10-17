package org.designpattern.creational.builderpattern;

public class CarBuilder implements VehicleBuilder {
	
	private Car car;
	
	@Override
	public void reset() {
		car = new Car();
	}
	
	@Override
	public void setVehicleWheels(int numOfWheels) {
		car.setNoOfWheels(numOfWheels);
	}

	@Override
	public void setVehicleType(String vehicleType) {
		car.setVehicleType(vehicleType);
		
	}

	@Override
	public void setVehicleCapacity(int vehicleCapa) {
		car.setVehicleCapac(vehicleCapa);
		
	}

	@Override
	public void setTrolly(boolean isTrolly) {
		car.setTrolly(isTrolly);
		
	}

	@Override
	public Car getVehicle() {
		return car;
	}


}
