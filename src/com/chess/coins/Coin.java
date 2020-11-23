package com.chess.coins;

import com.chess.util.Position;

import ChessImpl.Board;
import ChessImpl.Player;

public class Coin {
	protected String name;
	protected Player player;
	protected Player opponent;
	protected Board board;
	
	Coin(String name,Player player,Player opponent,Board board){
		this.name = name;
		this.player = player;
		this.opponent = opponent;
		this.board = board;
	}
	
	public boolean isSafe() {
		return true;
	}
	public String getName() {
		return name;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public boolean isValid(int x1,int y1,int x2,int y2) {
		return false;
	}
	
	public void reverse() {
		return;
	}
	
	public boolean isCheckMate() {
		return false;
	}
	
	
}
