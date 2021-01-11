package com.chess.coins;

import com.chess.core.Board;
import com.chess.core.Player;
import com.chess.util.Position;

public abstract class Coin {
	protected String name;
	boolean canJump;
	Player coinOwner;
	
	Coin(String name,Player player){
		this.name = name;
		this.coinOwner = player;
	}
	
	public boolean isSafe() {
		return true;
	}
	public String getName() {
		return name;
	}
	
	public Player getCoinOwner() {
		return coinOwner;
	}
	
	abstract public boolean isValid(Position fromPos,Position toPos, Board board);
	
	public void reverse() {
		return;
	}
	
	public boolean isCheckMate() {
		return false;
	}
	
	
}
