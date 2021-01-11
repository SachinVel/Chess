package com.chess.coins;

import com.chess.core.Board;
import com.chess.core.Player;
import com.chess.util.Position;

public class Pawn extends Coin{
	boolean firstMove;
	
	
	public Pawn(String name,boolean firsMove,Player player){
		super(name,player);
		this.firstMove = firstMove;
		canJump = false;
	}
	
	@Override
	public boolean isValid(Position fromPos,Position toPos,Board board) {
		
		
		if(coinOwner.isWhite()) {
			//first move
			if(!firstMove) {
				if(fromPos.colPos==toPos.colPos && (fromPos.rowPos+2)==toPos.rowPos && board.isNull(toPos.rowPos,toPos.colPos)) {
					firstMove = true;
					return true;
				}
			}
			//normal move
			if( fromPos.colPos == toPos.colPos && (fromPos.rowPos+1)==toPos.rowPos && board.isNull(toPos.rowPos, toPos.colPos)) {
				firstMove = true;
				return true;	
			}
			//cross move
			if((fromPos.rowPos+1)==toPos.rowPos && Math.abs(fromPos.colPos-toPos.colPos)==1 && !board.isNull(toPos.rowPos, toPos.colPos) && board.isOpponent(toPos, coinOwner)){
				firstMove = true;
				return true;
			}
			
			return false;
		}else {
			if(!firstMove) {
				if(fromPos.colPos==toPos.colPos && (fromPos.rowPos-2)==toPos.rowPos && board.isNull(toPos.rowPos, toPos.colPos)) {
					firstMove = true;
					return true;
				}
			}
			if( fromPos.colPos == toPos.colPos && (fromPos.rowPos-1)==toPos.rowPos && board.isNull(toPos.rowPos, toPos.colPos)) {
				firstMove = true;
				return true;
				
			}
			
			if((fromPos.rowPos-1)==toPos.rowPos &&  Math.abs(fromPos.colPos-toPos.colPos)==1 && !board.isNull(toPos.rowPos, toPos.colPos) && board.isOpponent(toPos, coinOwner)){
				firstMove = true;
				return true;
			}
			
			return false;
		}
	}
	
}
