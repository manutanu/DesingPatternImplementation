package com.businessgame;

import java.util.ArrayList;
import java.util.List;

import com.businessgame.cells.Cell;
import com.businessgame.cells.Empty;
import com.businessgame.cells.Hotel;
import com.businessgame.cells.Jail;
import com.businessgame.cells.Lottery;
import com.businessgame.players.Player;

public class GameFactory {
	
	Bank bank ;
	
	public GameFactory() {
		
	}
	
	public List<Player> generatePlayers(int playercount){
		List<Player> playerList = new ArrayList<>();
		for(int i=0;i<playercount ;i++) {
			Player player = new Player();
			player.setAmoutMoney(1000);
			player.setAsssets(0);
			player.setCanPlay(true);
			player.setPersonId(i+1);
			player.setCurrentIndex(-1);
			playerList.add(player);
			
		}
		
		return playerList;
	}
	
	public Game initializeGame(int N , int bankAmount , String boardConfiguration) throws Exception {
		 this.bank = Bank.getBankInstance(bankAmount);
		Game game = new Game(N , this.bank);
		Cell gameboard[] = game.getGameBoard();
		String gameConfig[] = boardConfiguration.split(",");
		for(int i=0;i<gameConfig.length;i++) {
			switch(gameConfig[i]) {
			case "L":{
				gameboard[i] = new Lottery(i);
				break;
			}
			case "J":{
				gameboard[i] = new Jail(i);
				break;
			}
			case "H":{
				gameboard[i] = new Hotel(i);
				break;
			}
			case "E":{
				gameboard[i] = new Empty(i);
				break;
			}
			}
		}
		game.setGameBoard(gameboard);
		return game;
	}
}
