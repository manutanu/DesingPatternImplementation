package org.designpattern.behavioural.observer;

public class AuthenticationComponent {
	
	AuthenticationEventManager authEventManager ;
	
	public AuthenticationComponent(AuthenticationEventManager authEventManager) {
		this.authEventManager = authEventManager;
	}
	
	public void loginSuccessFull() {
		authEventManager.notifyListeners(" Mritunjay has logged in ");
	}
	
	public void resettingPassword() {
		authEventManager.notifyListeners(" Mritunjay has requested for password reset ");
	}
}
