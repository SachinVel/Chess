package com.chess.coins;

import com.chess.util.Position;

import ChessImpl.Board;
import ChessImpl.Player;

public class Queen extends Coin{
	Rook rook;
	Bishop bishop;
	
	public Queen(String name,Player player){
		super(name,player);
		this.rook = new Rook("temp",player);
		this.bishop = new Bishop("temp",player);
		canJump = false;
	}
	
	@Override
	public boolean isValid(int fromRowPos,int fromColPos,int toRowPos,int toColPos,Board board) {
		
		boolean valid = false;
		
		valid = rook.isValid(fromRowPos, fromColPos, toRowPos, toColPos,board);
		
		if(!valid)
			valid = bishop.isValid(fromRowPos, fromColPos, toRowPos, toColPos,board);
		
		return valid;
			
	}
}
