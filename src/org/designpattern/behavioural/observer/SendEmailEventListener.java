package org.designpattern.behavioural.observer;

public class SendEmailEventListener implements AuthEventListener {

	@Override
	public void udpate(String eventData) {
		System.out.println("Sending email as "+ eventData);
	}



}
