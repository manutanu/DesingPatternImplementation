package org.designpattern.OopsCaseStudies.ChessGame;

public class SingletonClassObjectCreationException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SingletonClassObjectCreationException() {
		super("Cannot Create more than one Instance of Singleton Class!!");
	}
}
