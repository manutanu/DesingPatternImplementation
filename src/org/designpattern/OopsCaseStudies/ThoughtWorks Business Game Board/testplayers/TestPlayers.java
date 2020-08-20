package com.businessgame.testplayers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.businessgame.Game;
import com.businessgame.players.Player;

class TestPlayers {
	
	Player player;
	
	@BeforeEach
	public void init() {
		player = new Player();
	}
	
	@Test
	public void testMakeMove() {
		
	}
}
