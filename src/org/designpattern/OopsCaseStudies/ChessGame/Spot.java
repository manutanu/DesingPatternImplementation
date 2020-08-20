package org.designpattern.OopsCaseStudies.ChessGame;

import org.designpattern.OopsCaseStudies.ChessGame.pieces.Piece;

public class Spot {
	private int x ;
	private int y ;
	
	private Piece occupiedBy;
	
	public Spot(int x , int y) {
		this.x = x;
		this.y = y;
		this.occupiedBy = null;
	}
	
	public Spot(int x , int y , Piece occ) {
		this.x = x;
		this.y = y;
		this.occupiedBy = occ;
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

	public Piece getOccupiedBy() {
		return occupiedBy;
	}

	public void setOccupiedBy(Piece occupiedBy) {
		this.occupiedBy = occupiedBy;
	}
	
	public void removePiece() {
		this.occupiedBy = null;
	}
}
