package org.designpattern.behavioural.state;

public abstract class MobileState {
	
	Mobile mobile;
	
	MobileState(Mobile mobile){
		this.mobile = mobile;
	}
	
	public abstract void shutDown();
	public abstract void lockPhone();
	public abstract void unlockPhone();
	
}
