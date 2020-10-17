package org.designpattern.behavioural.state;

public class SwitchOffState extends MobileState {
	
	SwitchOffState(Mobile mobile){
		super(mobile);
	}
	
	@Override
	public void shutDown() {
		System.out.println("Phone is already switchedoff");
	}

	@Override
	public void lockPhone() {
		System.out.println("Phone is switchedOff so cant lock it ");
	}

	@Override
	public void unlockPhone() {
		System.out.println("Phone is switchedOff so cant unlock it ");
	}

}
