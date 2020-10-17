package org.designpattern.creational.builderpattern;

public interface VehicleBuilder {
	
	public void reset();
	public void setVehicleWheels(int numOfWheels);
	public void setVehicleType(String vehicleType);
	public void setVehicleCapacity(int vehicleCapa);
	public void setTrolly(boolean isTrolly);
	public Car getVehicle();
}
