package com.businessgame.cells;

import com.businessgame.Bank;
import com.businessgame.CellType;
import com.businessgame.players.Player;

public class Jail extends Cell{
	
	int deductValue ;
	
	public Jail(int spotIndex){
		this.setSpot(spotIndex);
		this.setCellType(CellType.JAIL);
		this.deductValue = 150;
	}

	public int getDeductValue() {
		return deductValue;
	}

	public void setDeductValue(int deductValue) {
		this.deductValue = deductValue;
	}
	
	public void deductFine(Player player , Bank bank) {
		if(player.getAmoutMoney() < this.deductValue) {
			player.setCanPlay(false);
			System.out.println("You cant pay the fine you are busted!");
		}else {
			player.setAmoutMoney(player.getAmoutMoney() - this.deductValue);
			bank.addMoney(this.deductValue);
		}
	}

}
