package com.businessgame.players;

import com.businessgame.CellType;
import com.businessgame.Game;
import com.businessgame.cells.Hotel;
import com.businessgame.cells.Jail;
import com.businessgame.cells.Lottery;

public class Player {
	
	private int personId;
	private int amoutMoney;
	private int asssets;
	private boolean canPlay;
	private int currentIndex;
	
	public int getCurrentIndex() {
		return currentIndex;
	}
	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public int getAmoutMoney() {
		return amoutMoney;
	}
	public void setAmoutMoney(int amoutMoney) {
		this.amoutMoney = amoutMoney;
	}
	public int getAsssets() {
		return asssets;
	}
	public void setAsssets(int asssets) {
		this.asssets = asssets;
	}
	public boolean isCanPlay() {
		return canPlay;
	}
	public void setCanPlay(boolean canPlay) {
		this.canPlay = canPlay;
	}
	
	
	public void makeMove(Game game , int diceValue) {
		int destinationValue = (diceValue + this.getCurrentIndex()) % game.getGameBoard().length;
		
		if(game.getGameBoard()[destinationValue].getCellType() == CellType.HOTEL) {
			Hotel hotel = (Hotel)game.getGameBoard()[destinationValue];
			hotel.deductCurrentRentOrBuyValue(this, game.getBank());
		}else if(game.getGameBoard()[destinationValue].getCellType() == CellType.JAIL) {
			Jail jail = (Jail)game.getGameBoard()[destinationValue];
			jail.deductFine(this, game.getBank());
		}else if(game.getGameBoard()[destinationValue].getCellType() == CellType.LOTTERY) {
			Lottery lotery = (Lottery)game.getGameBoard()[destinationValue];
			lotery.getLotteryMoney(this , game.getBank());
		}else {
			System.out.println(" You Empty Cell");
		}
		
		this.currentIndex = destinationValue;
	}
}
