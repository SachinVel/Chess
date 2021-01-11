package com.chess.core;

import com.chess.coins.Coin;
import com.chess.util.Position;

public class Player {
	boolean isWhite;
	int pawns = 8;
	int rooks = 2;
	int bishops = 2;
	int horses = 2;
	int queen = 1;
	int king = 1;
	Position kingPos;
	
	public Player(boolean white,Position kingPos){
		this.isWhite = white;
		this.kingPos = kingPos;
	}
	
	public void cutCoin(Coin coin) {
		if(coin.getClass().getSimpleName().equals("Pawn"))
			this.pawns--;
		if(coin.getClass().getSimpleName().equals("Rook"))
			this.rooks--;
		if(coin.getClass().getSimpleName().equals("Bishop"))
			this.bishops--;
		if(coin.getClass().getSimpleName().equals("Horse"))
			this.horses--;
		if(coin.getClass().getSimpleName().equals("Queen"))
			this.queen--;
	}
	public void putCoin(Coin coin) {
		if(coin.getClass().getSimpleName().equals("Pawn"))
			this.pawns++;
		if(coin.getClass().getSimpleName().equals("Rook"))
			this.rooks++;
		if(coin.getClass().getSimpleName().equals("Bishop"))
			this.bishops++;
		if(coin.getClass().getSimpleName().equals("Horse"))
			this.horses++;
		if(coin.getClass().getSimpleName().equals("Queen"))
			this.queen++;
	}
	public boolean isWhite() {
		return isWhite;
	}
	
	public int getScore() {
		int score=0;
		score += pawns*1;
		score += rooks*5;
		score += bishops*3;
		score += horses*3;
		score += queen*9;
		return score;
	}
	
	public void setKingPosition(Position toPos) {
		kingPos = toPos;
	}
	
	public int getXKingPosition() {
		return kingPos.rowPos;
	}
	
	public int getYKingPosition() {
		return kingPos.colPos;
	}
	
}
