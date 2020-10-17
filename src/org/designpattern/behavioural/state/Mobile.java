package org.designpattern.behavioural.state;

public class Mobile {
	
	MobileState locked;
	MobileState open;
	MobileState switchOff;
	
	MobileState currentState;
	
	Mobile(){
		locked = new LockState(this);
		open = new OpenState(this);
		switchOff = new SwitchOffState(this);
		
		currentState = new LockState(this);
	}
	
	public void switchOffPhone() {
		this.currentState.shutDown();
	}
	
	public void lockPhone() {
		this.currentState.lockPhone();
	}
	
	public void unlockPhone() {
		this.currentState.unlockPhone();
	}
	
	public void changeMobileState(MobileState newState) {
		this.currentState = newState;
	}
	
	public MobileState getSwitchOffState() {
		return switchOff;
	}
	
	public MobileState getLockedState() {
		return locked;
	}
	
	public MobileState getOpenState() {
		return open;
	}
	
}
