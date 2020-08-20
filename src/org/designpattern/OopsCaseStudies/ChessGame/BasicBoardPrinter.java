package org.designpattern.OopsCaseStudies.ChessGame;

import org.designpattern.OopsCaseStudies.ChessGame.pieces.Piece;

public class BasicBoardPrinter implements BoardPrinter {

	@Override
	public void printBoard(Board board) {
		Spot[][] spotBoard = board.getBoard();
		for(int i=0;i<=8;i++) {
			for(int j=0;j<=8;j++) {
				if(i == 0) {
					System.out.print((j-1)+ "   ");
				}else {
					if(j == 0)
						System.out.print((i-1)+"   ");
					else {
						Piece piece = spotBoard[i-1][j-1].getOccupiedBy();
						String spotString = piece != null ? (piece.getFromTeam() == TeamType.WHITE ? "W": "B") + "" + (piece.getPieceName().substring(0,1)+"  ") : "NN  ";
						System.out.print(spotString);
					}
				}
			}
			System.out.println("");
		}
	}

}
