package com.businessgame.cells;

import com.businessgame.CellType;

public class Empty extends Cell{
	
	public Empty(int index) {
		this.setSpot(index);
		this.setCellType(CellType.EMPTY);
	}

}
