package org.designpattern.OopsCaseStudies.ChessGame;

public class GamePlay {
	
	public static void main(String args[]) {
		try {
			TeamFactory factory = TeamFactory.getInstance();
			Board gameBoard = factory.getInitializedBoardInstance();
			BoardPrinter  boardPrinter = new BasicBoardPrinter();
			boardPrinter.printBoard(gameBoard);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
