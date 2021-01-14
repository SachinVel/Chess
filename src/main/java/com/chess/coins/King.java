package com.chess.coins;

import com.chess.core.Board;
import com.chess.core.Player;
import com.chess.util.Position;

public class King extends Coin{
	
	public King(String name,Player player){
		super(name,player);
		canJump = false;
	}
	
	public boolean isValid(Position fromPos,Position toPos,Board board) {
		boolean isDestinationValid = board.isNull(toPos) || board.isOpponent(toPos, coinOwner);
		if( Math.abs(fromPos.rowPos-toPos.rowPos)<=1 && Math.abs(fromPos.colPos-toPos.colPos)<=1 && isDestinationValid) {
			coinOwner.setKingPosition(toPos);
			return true;
		}
		return false;
	}
	
}
