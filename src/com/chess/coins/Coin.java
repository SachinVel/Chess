package com.chess.coins;

import com.chess.util.Position;

import ChessImpl.Board;
import ChessImpl.Player;

public class Coin {
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
	
	public boolean isValid(int fromRowPos,int fromColPos,int toRowPos,int toColPos, Board board) {
		return false;
	}
	
	public void reverse() {
		return;
	}
	
	public boolean isCheckMate() {
		return false;
	}
	
	
}
