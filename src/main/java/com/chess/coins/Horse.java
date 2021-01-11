package com.chess.coins;

import com.chess.core.Board;
import com.chess.core.Player;
import com.chess.util.Position;

public class Horse extends Coin{
	
	public Horse(String name,Player player){
		super(name,player);
		canJump = true;
	}
	
	public boolean isValid(Position fromPos,Position toPos, Board board) {
		boolean valid=false;
		
		if( Math.abs(fromPos.rowPos-toPos.rowPos)==2 &&  Math.abs(fromPos.colPos-toPos.colPos)==1  ) {
			valid=true;
		}else if( Math.abs(fromPos.rowPos-toPos.rowPos)==1 &&  Math.abs(fromPos.colPos-toPos.colPos)==2 ) {
			valid=true;
		}
		
		if( valid && ( board.isOpponent(toPos, coinOwner) || board.isNull(toPos) )) {
			return true;
		}
		return false;
		
	}
	
}
