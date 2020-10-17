package org.designpattern.behavioural.observer;

public class MainDriverForObserverPattern {
	
	public static void main(String args[]) {
		AuthenticationEventManager authEventManager = new AuthenticationEventManager();
		AuthEventListener emailListener = new SendEmailEventListener();
		AuthEventListener logListeren  = new LogAuthEventListener();
		authEventManager.subscribe(emailListener);
		authEventManager.subscribe(logListeren);
		
		AuthenticationComponent authComponent = new AuthenticationComponent(authEventManager);
		
		authComponent.loginSuccessFull();
		
		authComponent.resettingPassword();
	}
}
