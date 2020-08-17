enum Direction {
	NORTH , EAST , WEST , SOUTH
}



class NasaRover extends Rover {


	NasaRover(int startx , int starty , Direction dir){
		this.headTowards = dir ;
		this.currentX = startx;
		this.currentY = starty;
	}

	public void moveForward(){
		switch(headTowards){
			case NORTH :
				currentX = currentX - 1;
				break;
			case EAST :
				currentY = currentY + 1;
				break;
			case WEST :
				currentY = currentY - 1;
				break;
			case SOUTH :
				currentX = currentX + 1;
				break;

		}
	}

	public void rotate(char dir){
		switch(dir){
			case 'L':{
				rotateUtilLeft();
				break;
			}
			case 'R':{
				rotateUtilRight();
				break;
			}
		}
	}

	public  void rotateUtilRight(){
		if(headTowards == Direction.NORTH){
			headTowards = Direction.EAST;
		}else if(headTowards == Direction.EAST){
			headTowards = Direction.SOUTH;
		}else if(headTowards == Direction.WEST){
			headTowards = Direction.NORTH;
		}else{
			headTowards = Direction.WEST;
		}
	}


	public void rotateUtilLeft(){
		if(headTowards == Direction.NORTH){
			headTowards = Direction.WEST;
		}else if(headTowards == Direction.EAST){
			headTowards = Direction.NORTH;
		}else if(headTowards == Direction.WEST){
			headTowards = Direction.SOUTH;
		}else{
			headTowards = Direction.EAST;
		}
	}


}