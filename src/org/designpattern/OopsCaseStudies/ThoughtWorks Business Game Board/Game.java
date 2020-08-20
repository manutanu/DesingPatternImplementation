package com.businessgame;

import java.util.List;

import com.businessgame.cells.Cell;
import com.businessgame.cells.Empty;
import com.businessgame.players.Player;

public class Game {
	
	Cell gameBoard[] ;
	Bank bank ;
	List<Player> playerList;
	
	Game(int N , Bank bank){
		this.gameBoard = new Cell[N];
		this.bank = bank;
		for(int i=0;i<N;i++) {
			this.gameBoard[i] = new Empty(i);
		}
	}

	public Cell[] getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(Cell[] gameBoard) {
		this.gameBoard = gameBoard;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public List<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}
	
	
}
