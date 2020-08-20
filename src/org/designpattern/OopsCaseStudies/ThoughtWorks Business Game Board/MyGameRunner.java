package com.businessgame;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.businessgame.gamePrinter.BasicGamePrinter;
import com.businessgame.gamePrinter.GamePrinter;
import com.businessgame.players.Player;

public class MyGameRunner {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk = new StringTokenizer("");
	static GamePrinter gamePrinter;
	
	public static void main(String[] args) throws Exception {
		// need to get GameFactory Instance 
		GameFactory gameFactory = new GameFactory();
		gamePrinter = new BasicGamePrinter();
		
		System.out.println("Please Enter game board length and bank amout");
		System.out.println("Input Should be like -> 10 50000 ");
		stk = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int bankamout = Integer.parseInt(stk.nextToken());
		
		System.out.println("Please enter comma seperated game cell configurations");
		System.out.println("Input should be like -> J,H,L,H,E,L,H,L,H,J");
		String gameConfig = bf.readLine();
		
		// generate Game from GameFactory;
		Game game = gameFactory.initializeGame(N, bankamout , gameConfig);
		for(int i=0;i<game.gameBoard.length;i++) {
			System.out.print(game.getGameBoard()[i].getCellType()+" ");
		}
		System.out.println("");
		System.out.println("Enter how many Players will play");
		int playercount = Integer.parseInt(bf.readLine());
		List<Player> playerList = gameFactory.generatePlayers(playercount);
		game.setPlayerList(playerList);
		
		// PrintGameState and player states
		gamePrinter.printGame(game, game.getBank());
		
		playGame(game);

	}
	
	
	public static void playGame(Game game )throws Exception {
		List<Player> playerList = game.getPlayerList();
		System.out.println("Please Enter Dice Configurations");
		boolean flag = true;
		int currentPlayerIndex = 0;
		List<Integer> removedPlayers = new ArrayList<>();
		
		for(int i=0;i<game.getPlayerList().size();i++) {
			removedPlayers.add(game.getPlayerList().get(i).getPersonId());
		}
		while(flag &&  removedPlayers.size() > 1) {
			System.out.println("P"+(currentPlayerIndex +1)+" please enter dice value");
			int diceValue = Integer.parseInt(bf.readLine());
			if(diceValue == -1) {
				System.out.println("Game has aborted");
				gamePrinter.printGame(game, game.getBank());
				return;
			}
				
			int destinationValue = diceValue;
			Player player = playerList.get(currentPlayerIndex);
			System.out.println("currently at "+player.getCurrentIndex());
			player.makeMove(game, destinationValue);
			if(!player.isCanPlay()) {
				System.out.println("You are out !");
				removePlayer(playerList , removedPlayers);
			}else {
				currentPlayerIndex = (currentPlayerIndex + 1) % removedPlayers.size();
			}
			System.out.println("If you want to abort game press -1");
			System.out.println(game.getBank().getBankStore());
		}
		gamePrinter.printGame(game, game.getBank());
	}
	
	
	public static int removePlayer(List<Player> playerlist , List<Integer> removedPlayers){
		for(int i=0;i<removedPlayers.size();i++) {
			for(Player player : playerlist){
				if(player.getPersonId() == removedPlayers.get(i)) {
					return i;
				}
			}
		}
		return -1;
	}

}
//J,H,L,H,E,L,H,L,H,J
//J,H,L,H,E,L,H,L,H,J