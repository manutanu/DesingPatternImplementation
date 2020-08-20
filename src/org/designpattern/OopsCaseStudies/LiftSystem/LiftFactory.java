package org.designpattern.OopsCaseStudies.LiftSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LiftFactory {
	
	public List<Lift> createLifts(List<String> createLiftsCommands){
		List<Lift> liftList = new ArrayList<>();
		createLiftsCommands.forEach(command -> {
			StringTokenizer	stk = new StringTokenizer(command);
			int numberofLifts = Integer.parseInt(stk.nextToken());
			int maxCapacity = Integer.parseInt(stk.nextToken());
			while(numberofLifts-->0) {
				liftList.add(new Lift(maxCapacity));
			}
		});
		return liftList;
	}
}
