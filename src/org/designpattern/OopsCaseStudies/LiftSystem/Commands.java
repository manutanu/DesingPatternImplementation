package org.designpattern.OopsCaseStudies.LiftSystem;

import java.util.Date;
import java.util.List;

public abstract class Commands {
	
	int commandId;
	CommandType commandType;
	Date dispatchDateTime ;
	
	public abstract void processCommandArguments(String commandString);

	public void setCommandDispatchTime() {
		this.dispatchDateTime = new Date();
	}
	
	public void setCommandType(CommandType command) {
		this.commandType = command;
	}
	
	public void setCommandId(int id) {
		this.commandId = id;
	}
}
