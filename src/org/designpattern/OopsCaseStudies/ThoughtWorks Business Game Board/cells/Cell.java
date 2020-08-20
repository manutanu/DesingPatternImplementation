package com.businessgame.cells;

import com.businessgame.CellType;

public abstract class Cell {
	
	private int spot;
	private CellType cellType;
	
	public int getSpot() {
		return spot;
	}
	public void setSpot(int spot) {
		this.spot = spot;
	}
	public CellType getCellType() {
		return cellType;
	}
	public void setCellType(CellType cellType) {
		this.cellType = cellType;
	}
	
	
	
}
