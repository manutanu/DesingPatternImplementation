enum Direction {
	NORTH , EAST , WEST , SOUTH
}

// create it as Interface and Provider Implementation for different companies
class RoverFactory{

	private Surface surface ;

	RoverFactory(Surface surface){
		this.surface = surface;
	}

	public Rover getRover(int startx , int starty , char direction) throws Exception {
		System.out.println(surface.height + "  "+ surface.width);
		if( (startx > surface.height ) || (starty > surface.width )){
			throw new Exception("Invalid position of the rover");
		}
		NasaRover rover = null;
		if(direction == 'N'){
			rover = new NasaRover(startx , starty , Direction.NORTH); 
		}else if(direction == 'E'){
			rover = new NasaRover(startx , starty , Direction.EAST);
		}else if(direction == 'W'){
			rover = new NasaRover(startx , starty , Direction.WEST);
		}else if(direction == 'S'){
			rover = new NasaRover(startx , starty , Direction.SOUTH);
		}else{
			throw new Exception("Invalid Direction");
		}
		return rover;
	}
}