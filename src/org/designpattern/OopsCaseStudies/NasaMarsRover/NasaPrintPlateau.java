package org.designpattern.OopsCaseStudies.NasaMarsRover;


import java.util.*;

class NasaPrintPlateau implements PrintPlateau {


	public void printSurfaceConfiguration(RoverCluster rovers , Surface surface){
		// later TODO clone the object using prototype design pattern and then modify that
		ArrayList<Rovers> roversList = rovers.getRovers();
		for(int i=0;i<roversList.size();i++){
			surface.surfaceGrid[roversList.get(i).getCurrentX()][roversList.get(i).getCurrentY()] = i+1;
		}

		for(int i=1;i< surface.height;i++){
			for(int j=1;j < surface.width ;j++){
				System.out.print(surface.surfaceGrid[i][j] + " ");
			}
			System.out.println("");
		}

	}

}