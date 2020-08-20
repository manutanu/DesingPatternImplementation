package org.designpattern.OopsCaseStudies.ChessGame.pieces;

import java.util.LinkedList;
import java.util.Queue;

import org.designpattern.OopsCaseStudies.ChessGame.Board;
import org.designpattern.OopsCaseStudies.ChessGame.Spot;
import org.designpattern.OopsCaseStudies.ChessGame.Team;
import org.designpattern.OopsCaseStudies.ChessGame.TeamType;

public class Pawn extends Piece {
	
	
	public Pawn(int x , int y , TeamType team) {
		this.setX(x);
		this.setY(y);
		this.setFromTeam(team);
		this.setPieceName("Pawn");
	}

	@Override
	public void move(Spot destination, Board board, Team opposition, Team ownTeam) {
		// TODO Auto-generated method stub
		if(this.getFromTeam() == TeamType.WHITE) { // team which is on 0,0 side
			int xd = destination.getX();
			int yd = destination.getY();
//			if(isValidMove(xd , yd )) {
//				if(destination.getOccupiedBy().getFromTeam() == TeamType.BLACK) {
//					System.out.println("You destroyed one "+ destination.getOccupiedBy() + " Of "+ TeamType.WHITE);
//				}
//			}
			
		}else { // team which is on 7,0 side
			
		}
	}
	
	//doing bfs like search to check if can reach this point and this point should not be my own player's spot
//	private boolean isValidMove(int xs , int ys , int xd , int yd) {
//		if(this.getFromTeam() == TeamType.WHITE) {
//			int movex[] = new int[] {1};
//			int movey[] = new int[] {0};
//			
//			Queue<Integer> queue = new LinkedList<>();
//			
//		}
//		
//	}
	
	
	
}
