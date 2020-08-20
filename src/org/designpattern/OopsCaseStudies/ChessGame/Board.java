package org.designpattern.OopsCaseStudies.ChessGame;

import org.designpattern.OopsCaseStudies.ChessGame.pieces.Piece;

public class Board {
	
	private Spot[][] board = new Spot[8][8];
	
	public Board() {
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				board[i][j] = new Spot(i , j);
			}
		}
	}
	
	public Spot[][] getBoard() {
		return board;
	}

	public void setBoard(Spot[][] board) {
		this.board = board;
	}
	
	public void initializeSpot(int x , int y , Piece piece) {
		board[x][y] = new Spot(x , y , piece);
	}
	
}
