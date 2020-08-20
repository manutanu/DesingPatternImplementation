package com.businessgame.cells;

import com.businessgame.Bank;
import com.businessgame.CellType;
import com.businessgame.HotelState;
import com.businessgame.players.Player;

public class Hotel extends Cell{
	
	private Player ownedBy;
	private HotelState currentState;
	private int rentValue;
	private int buyValue;
	
	public Hotel(int spotIndex) {
		this.setSpot(spotIndex);
		this.currentState = HotelState.SILVER;
		this.rentValue = 50;
		this.buyValue = 200;
		this.setCellType(CellType.HOTEL);
		this.ownedBy = null;
	}
	
	
	public Player getOwnedBy() {
		return ownedBy;
	}

	public void setOwnedBy(Player ownedBy) {
		this.ownedBy = ownedBy;
	}

	public HotelState getCurrentState() {
		return currentState;
	}
	public void setCurrentState(HotelState currentState) {
		this.currentState = currentState;
	}
	public int getRentValue() {
		return rentValue;
	}
	public void setRentValue(int rentValue) {
		this.rentValue = rentValue;
	}
	public int getBuyValue() {
		return buyValue;
	}
	public void setBuyValue(int buyValue) {
		this.buyValue = buyValue;
	}
	
	public void deductCurrentRentOrBuyValue(Player player , Bank bank) {
		
		if(this.ownedBy != null && this.ownedBy != player) { // this hotel is owned by someone but not current player
			payRent(player , bank);
		}else if(this.ownedBy == null){ // not owned by anyone currently
			buyHotel(player , bank);
		}else { // owned by the requested person
			this.upgradeHotel(player , bank);
		}
	}
	
	public void buyHotel(Player player , Bank bank) {
		if(player.getAmoutMoney() < this.buyValue) {
			System.out.println("You can buy it dont have enough money!");
		}else {
			this.ownedBy = player;
			deductMoneyFromPlayerAndAddToBank(player , bank);
		}
		
	}
	
	public void deductMoneyFromPlayerAndAddToBank(Player player , Bank bank) {
		player.setAmoutMoney(player.getAmoutMoney() - this.buyValue);
		player.setAsssets(player.getAsssets() + this.buyValue);
		bank.addMoney(this.buyValue);
	}
	
	public void payRent(Player player , Bank bank) {
		if(player.getAmoutMoney() < this.rentValue) { 
			System.out.println("You dont have enough money to rent GameOver!");
			player.setCanPlay(false);
		}else {
			player.setAmoutMoney(player.getAmoutMoney() - this.rentValue);
			bank.addMoney(this.rentValue);
		}
	}

	public void upgradeHotel(Player player , Bank bank) {
		switch(this.currentState){
			case SILVER:{
				int upgradeValue = 100; 
				if(player.getAmoutMoney() < upgradeValue) {
					System.out.println("You dont have money to upgrade");
					return;
				}
				this.currentState = HotelState.GOLD;
				this.rentValue = 150;
				this.buyValue = 300;
				player.setAmoutMoney(player.getAmoutMoney() - upgradeValue);
				player.setAsssets(player.getAsssets() + upgradeValue);
				bank.addMoney(upgradeValue);
				break;
			}
			case GOLD:{
				int upgradeValue = 200;
				if(player.getAmoutMoney() < upgradeValue) {
					System.out.println("You dont have money to upgrade");
					return;
				}
				this.currentState = HotelState.PLATINUM;
				this.rentValue = 300;
				this.buyValue = 500;
				player.setAmoutMoney(player.getAmoutMoney() - upgradeValue);
				player.setAsssets(player.getAsssets() + upgradeValue);
				bank.addMoney(upgradeValue);
				break;
			}
			case PLATINUM:{
				System.out.println("Already upgraded enjoy");
				break;
			}
		}
	}
	
	
//	public boolean ownedBy(Player player) {
//		for(Player play: this.getOwnedBy()){
//			if(play.getPersonId() == player.getPersonId()) {
//				return true;
//			}
//		};
//		
//		return false;
//	}
//	

}
