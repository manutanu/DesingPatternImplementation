package org.designpattern.behavioural.state;

public class LockState extends MobileState {
	
	LockState(Mobile mobile){
		super(mobile);
	}
	
	@Override
	public void shutDown() {
		System.out.println("Phone is locked but Shutting Down");
		this.mobile.changeMobileState(this.mobile.getSwitchOffState());
	}

	@Override
	public void lockPhone() {
		System.out.println("Phone is already Locked ");
	}

	@Override
	public void unlockPhone() {
		System.out.println("Phone is unlocked");
		this.mobile.changeMobileState(this.mobile.getOpenState());
	}

}
