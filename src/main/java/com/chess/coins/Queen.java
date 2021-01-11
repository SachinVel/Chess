package com.chess.coins;

import com.chess.core.Board;
import com.chess.core.Player;
import com.chess.util.Position;

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
	public boolean isValid(Position fromPos,Position toPos,Board board) {
		
		boolean valid = false;
		
		valid = rook.isValid(fromPos, toPos, board);
		
		if(!valid)
			valid = bishop.isValid(fromPos, toPos,board);
		
		return valid;
			
	}
}
