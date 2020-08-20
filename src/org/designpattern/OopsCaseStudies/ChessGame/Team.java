package org.designpattern.OopsCaseStudies.ChessGame;

import java.util.ArrayList;
import java.util.List;

import org.designpattern.OopsCaseStudies.ChessGame.pieces.Piece;

public class Team {
	
	private TeamType teamColo;
	private List<Piece> totalAlive ;
	private List<Piece> totalDead;
	private Board board;
	
	public Team(TeamType teamColo) {
		totalAlive = new ArrayList<>();
		totalDead = new ArrayList<>();
		this.teamColo = teamColo;
	}
	
	public TeamType getTeamColo() {
		return teamColo;
	}
	public void setTeamColo(TeamType teamColo) {
		this.teamColo = teamColo;
	}
	public List<Piece> getTotalAlive() {
		return totalAlive;
	}
	public void setTotalAlive(List<Piece> totalAlive) {
		this.totalAlive = totalAlive;
	}
	public List<Piece> getTotalDead() {
		return totalDead;
	}
	public void setTotalDead(List<Piece> totalDead) {
		this.totalDead = totalDead;
	}
	
	public void killPiece(Piece piece) {
		
	}
	
}
