package com.chess.coins;

import com.chess.util.Position;

import ChessImpl.Board;
import ChessImpl.Player;

public class Pawn extends Coin{
	boolean firstMove;
	
	
	public Pawn(String name,boolean firsMove,Player player){
		super(name,player);
		this.firstMove = firstMove;
		canJump = false;
	}
	
	@Override
	public boolean isValid(int fromRowPos,int fromColPos,int toRowPos,int toColPos,Board board) {
		
		
		if(coinOwner.isWhite()) {
			//first move
			if(!firstMove) {
				if(fromColPos==toColPos && (fromRowPos+2)==toRowPos && board.isNull(toRowPos,toColPos)) {
					firstMove = true;
					return true;
				}
			}
			//normal move
			if( fromColPos == toColPos && (fromRowPos+1)==toRowPos && board.isNull(toRowPos, toColPos)) {
				firstMove = true;
				return true;	
			}
			//cross move
			if((fromRowPos+1)==toRowPos && Math.abs(fromColPos-toColPos)==1 && !board.isNull(toRowPos, toColPos) && board.isOpponent(toRowPos, toColPos, coinOwner)){
				firstMove = true;
				return true;
			}
			
			return false;
		}else {
			if(!firstMove) {
				if(fromColPos==toColPos && (fromRowPos-2)==toRowPos && board.isNull(toRowPos, toColPos)) {
					firstMove = true;
					return true;
				}
			}
			if( fromColPos == toColPos && (fromRowPos-1)==toRowPos && board.isNull(toRowPos, toColPos)) {
				firstMove = true;
				return true;
				
			}
			
			if((fromRowPos-1)==toRowPos &&  Math.abs(fromColPos-toColPos)==1 && !board.isNull(toRowPos, toColPos) && board.isOpponent(toRowPos, toColPos, coinOwner)){
				firstMove = true;
				return true;
			}
			
			return false;
		}
	}
	
}
