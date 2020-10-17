package org.designpattern.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationEventManager {
	
	List<AuthEventListener> listerners ;
	
	AuthenticationEventManager(){
		listerners = new ArrayList<>();
	}
	
	public void subscribe(AuthEventListener listener) {
		listerners.add(listener);
	}
	
	public void unsubscribe(AuthEventListener listener) {
		listerners.remove(listener);
	}
	
	public void notifyListeners(String eventMessage) {
		for(AuthEventListener listener: listerners) {
			listener.udpate(eventMessage);
		}
	}
}
