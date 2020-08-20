package com.businessgame.gamePrinter;

import java.util.List;

import com.businessgame.Bank;
import com.businessgame.Game;
import com.businessgame.players.Player;

public class BasicGamePrinter implements GamePrinter{

	@Override
	public void printGame(Game game, Bank bank) {
		int bankamount = bank.getBankStore();
		List<Player>  players = game.getPlayerList();
		for(int i=0;i<players.size();i++) {
			System.out.println("Player "+(i+1) + " money left "+(players.get(i).getAmoutMoney()+players.get(i).getAsssets())+" Assets "+players.get(i).getAsssets());
			bankamount -= players.get(i).getAsssets();
		}
		System.out.println("Bank money left "+ bankamount);
	}

}
