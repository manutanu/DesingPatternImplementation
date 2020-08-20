package org.designpattern.OopsCaseStudies.ChessGame.pieces;

import org.designpattern.OopsCaseStudies.ChessGame.Board;
import org.designpattern.OopsCaseStudies.ChessGame.Spot;
import org.designpattern.OopsCaseStudies.ChessGame.Team;
import org.designpattern.OopsCaseStudies.ChessGame.TeamType;

public abstract class Piece {
	
	private int pieceId;
	private TeamType fromTeam;
	private int x;
	private int y;
	private boolean alive;
	private String pieceName;
	
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public TeamType getFromTeam() {
		return fromTeam;
	}
	public void setFromTeam(TeamType fromTeam) {
		this.fromTeam = fromTeam;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getPieceId() {
		return pieceId;
	}
	public void setPieceId(int pieceId) {
		this.pieceId = pieceId;
	}
	
	public abstract void move(Spot destination , Board board , Team opposition , Team ownTeam);
	
	public String getPieceName() {
		return pieceName;
	}
	public void setPieceName(String pieceName) {
		this.pieceName = pieceName;
	}
	
}
