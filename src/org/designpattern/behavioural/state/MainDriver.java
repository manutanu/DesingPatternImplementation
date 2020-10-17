package org.designpattern.behavioural.state;

public class MainDriver {

	public static void main(String[] args) {
		
		Mobile mobile = new Mobile();
		
		mobile.lockPhone();
		
		mobile.unlockPhone();
		
		mobile.lockPhone();
		
		mobile.switchOffPhone();
		
		mobile.lockPhone();
		
		mobile.unlockPhone();

	}

}
