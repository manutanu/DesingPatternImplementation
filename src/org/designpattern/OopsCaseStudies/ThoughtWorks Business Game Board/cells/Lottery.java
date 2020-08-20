package com.businessgame.cells;

import com.businessgame.Bank;
import com.businessgame.CellType;
import com.businessgame.players.Player;

public class Lottery extends Cell{
	
	private int gainAmout ;
	
	public Lottery(int spotValue) {
		this.setSpot(spotValue);
		this.setCellType(CellType.LOTTERY);
		this.gainAmout = 200;
	}
	
	
	
	public int getGainAmout() {
		return gainAmout;
	}



	public void setGainAmout(int gainAmout) {
		this.gainAmout = gainAmout;
	}



	public void getLotteryMoney(Player player  , Bank bank) {
		player.setAmoutMoney(player.getAmoutMoney() + this.gainAmout);
		bank.deductMoney(this.gainAmout);
	}
	
}
