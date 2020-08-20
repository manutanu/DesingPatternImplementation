package org.designpattern.OopsCaseStudies.LiftSystem;

import java.util.StringTokenizer;

public class MovementCommand extends Commands {
	
	int fromFloor;
	int toFloor;
	
	@Override
	public void processCommandArguments(String commandString) {
		StringTokenizer stk = new StringTokenizer(commandString);
		this.fromFloor = Integer.parseInt(stk.nextToken());
		this.toFloor = Integer.parseInt(stk.nextToken());
	}
	

}
