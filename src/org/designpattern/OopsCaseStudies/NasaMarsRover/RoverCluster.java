import java.util.*;

class RoverCluster{

	List<Rover> roverCluster ;

	RoverCluster(){
		roverCluster = new ArrayList<>();
	}

	public void addRoverToCluster(Rover rover){
		roverCluster.add(rover);
	}

	public List<Rover> getRovers(){
		return roverCluster;
	}

}