package org.designpattern.OopsCaseStudies.LiftSystem;

import java.text.DecimalFormat;
import java.util.List;


public class CreateLiftCommand extends Commands {
	
	public CreateLiftCommand(int id) {
		this.commandId = id;
		this.commandType = CommandType.CREATE_LIFT;
	}
	
	@Override
	public void processCommandArguments(String commandString) {
		// TODO Auto-generated method stub
		
	}

}
