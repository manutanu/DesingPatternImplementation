package org.designpattern.creational.builderpattern;

public class Car {
	private int noOfWheels;
	private String vehicleType;
	private int vehicleCapac;
	private boolean trolly;
	public int getNoOfWheels() {
		return noOfWheels;
	}
	public void setNoOfWheels(int noOfWheels) {
		this.noOfWheels = noOfWheels;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public int getVehicleCapac() {
		return vehicleCapac;
	}
	public void setVehicleCapac(int vehicleCapac) {
		this.vehicleCapac = vehicleCapac;
	}
	public boolean isTrolly() {
		return trolly;
	}
	public void setTrolly(boolean trolly) {
		this.trolly = trolly;
	}
	@Override
	public String toString() {
		return "Car [noOfWheels=" + noOfWheels + ", vehicleType=" + vehicleType + ", vehicleCapac=" + vehicleCapac
				+ ", trolly=" + trolly + "]";
	}
	
	
	
}
