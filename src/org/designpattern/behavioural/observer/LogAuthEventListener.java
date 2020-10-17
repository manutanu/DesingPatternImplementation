package org.designpattern.behavioural.observer;

public class LogAuthEventListener implements AuthEventListener {

	@Override
	public void udpate(String eventData) {
		System.out.println("Adding log event as " + eventData);
	}



}
