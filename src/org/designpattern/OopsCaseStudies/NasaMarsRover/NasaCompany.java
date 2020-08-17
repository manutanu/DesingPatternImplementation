

import java.util.*;
import java.io.*;

public class NasaCompany{

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk = new StringTokenizer("");
	public static void main(String args[]) throws Exception{
		// craete Surface First 
		stk = new StringTokenizer(bf.readLine());
		int height = Integer.parseInt(stk.nextToken());
		int width = Integer.parseInt(stk.nextToken());
		Surface marsSurface = new Surface(height , width);

		// create Nasa Configuration Printer 
		PrintPlateau configPrinter = new NasaPrintPlateau();

		// inject Print strategy for NASA
		marsSurface.printPlateau = configPrinter;

		// use RoverCluster technology to manage rover clusters
		// crate RoverFactory for create Rovers
		RoverFactory factory = new RoverFactory(marsSurface);
		RoverCluster cluster = new RoverCluster();
		System.out.println("How many rovers you want create for Mars Mission");
		int N = Integer.parseInt(bf.readLine());
		while(N-->0){
			stk = new StringTokenizer(bf.readLine());
			int strtx = Integer.parseInt(stk.nextToken());
			int strty = Integer.parseInt(stk.nextToken());
			char dir = stk.nextToken().charAt(0);
			Rover rr = factory.getRover(strtx , strty , dir);
			String moves = bf.readLine();
			moveParser(moves , rr);
			cluster.addRoverToCluster(rr);
		}
		cluster.forEach(rover -> {System.out.println(rover);});
		marsSurface.printFinalConfiguration(cluster);

	}

	public static void moveParser(String moves , Rover rover){
		for(int i=0;i<moves.length();i++){
			if(moves.charAt(i)  == 'L'){
				rover.rotate('L');
			}else if(moves.charAt(i) == 'R'){
				rover.rotate('R');
			}else if(moves.charAt(i) == 'M'){
				rover.moveForward();
			}
		}
	}
}