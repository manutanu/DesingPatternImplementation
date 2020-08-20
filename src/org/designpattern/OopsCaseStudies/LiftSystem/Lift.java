package org.designpattern.OopsCaseStudies.LiftSystem;

import java.util.PriorityQueue;
import java.util.Queue;

class Lift extends Thread{

	int liftId ;
	int currentfloor ;
	Queue<MovementCommand> upward;
	Queue<MovementCommand> downward;
	int maxcapacity ;
	int currentcapacity ;
	LiftState state;

	Lift(int maxCapacity){
		downward = new PriorityQueue<MovementCommand>((MovementCommand i1 , MovementCommand i2) -> {
			if(i1.toFloor < i2.toFloor){
				return -1;
			}else if(i1.toFloor > i2.toFloor){
				return 1;
			}else{
				return 0;
			}
		});
		
		upward = new PriorityQueue<MovementCommand>((MovementCommand i1 , MovementCommand i2) -> {
			if(i1.toFloor < i2.toFloor){
				return 1;
			}else if(i1.toFloor > i2.toFloor){
				return -1;
			}else{
				return 0;
			}
		});
		
		this.maxcapacity = maxCapacity;
		this.currentfloor = 0;
		this.currentcapacity = 0;
		state = LiftState.STAND;
	}

	public void addPerson(){

	}


	public void run() {
		try{
			while(true) {
				Thread.sleep(1000);
				processQueue();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void processQueue(){
		switch(state){
			case UP :{
				int nextfloor = upward.remove().toFloor;
				currentcapacity--;
				currentfloor = nextfloor;
				if(upward.isEmpty()) {
					if(!downward.isEmpty()) {
						state = LiftState.STAND;
					}else {
						state = LiftState.DOWN;
					}
				}
			}
			case DOWN :{
				int nextfloor = downward.remove().toFloor;
				currentcapacity--;
				currentfloor = nextfloor;
				if(downward.isEmpty()) {
					if(!upward.isEmpty()) {
						state = LiftState.STAND;
					}else {
						state = LiftState.UP;
					}
				}
			}
			case STAND :{
				//this should depend upon request is closer
				if(!upward.isEmpty()) {
					state = LiftState.UP;
					
				}else {
					if(!downward.isEmpty()) {
						state = LiftState.DOWN;
					}
				}
			}
		}
	}
}