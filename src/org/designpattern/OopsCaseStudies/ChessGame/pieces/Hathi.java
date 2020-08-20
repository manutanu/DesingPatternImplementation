package org.designpattern.OopsCaseStudies.ChessGame.pieces;

import org.designpattern.OopsCaseStudies.ChessGame.Board;
import org.designpattern.OopsCaseStudies.ChessGame.Spot;
import org.designpattern.OopsCaseStudies.ChessGame.Team;
import org.designpattern.OopsCaseStudies.ChessGame.TeamType;

public class Hathi extends Piece {
	
	public Hathi(int x , int y , TeamType team) {
		this.setX(x);
		this.setY(y);
		this.setFromTeam(team);
		this.setPieceName("Hathi");
	}

	@Override
	public void move(Spot destination, Board board, Team opposition, Team ownTeam) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
//	private boolean isValidMove(Spot destination) {
//		
//	}
	
}
