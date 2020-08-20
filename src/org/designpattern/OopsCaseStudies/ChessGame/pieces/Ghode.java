package org.designpattern.OopsCaseStudies.ChessGame.pieces;

import org.designpattern.OopsCaseStudies.ChessGame.Board;
import org.designpattern.OopsCaseStudies.ChessGame.Spot;
import org.designpattern.OopsCaseStudies.ChessGame.Team;
import org.designpattern.OopsCaseStudies.ChessGame.TeamType;

public class Ghode extends Piece {
	
	
	

	@Override
	public void move(Spot destination, Board board, Team opposition, Team ownTeam) {
		// TODO Auto-generated method stub
		
	}

	public Ghode(int x , int y , TeamType team) {
		this.setX(x);
		this.setY(y);
		this.setFromTeam(team);
		this.setPieceName("Ghode");
	}
	
	
}
