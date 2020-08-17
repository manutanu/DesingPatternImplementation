import java.util.*;


class Surface {

	public int height ;
	public int width ;

	public int[][] surfaceGrid ;

	public PrintPlateau printPlateau;

	Surface(int height , int width){
		surfaceGrid = new int[height+1][width+1];
		this.height = height+1 ;
		this.width = width+1;
	}

	public void printFinalConfiguration(RoverCluster rovers){
		printPlateau.printSurfaceConfiguration( rovers , this );
	}	
}