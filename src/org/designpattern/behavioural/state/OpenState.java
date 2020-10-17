package org.designpattern.behavioural.state;

public class OpenState extends MobileState {
	
	OpenState(Mobile mobile){
		super(mobile);
	}
	
	@Override
	public void shutDown() {
		System.out.println("Phone is openend but Shutting Down");
		this.mobile.changeMobileState(this.mobile.getSwitchOffState());
	}

	@Override
	public void lockPhone() {
		System.out.println("Phone is Locked ");
		this.mobile.changeMobileState(this.mobile.getLockedState());
	}

	@Override
	public void unlockPhone() {
		System.out.println("Phone is already unlocked");
	}

}
