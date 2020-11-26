package com.chess.coins;

import ChessImpl.Board;
import ChessImpl.Player;

public class Horse extends Coin{
	
	public Horse(String name,Player player){
		super(name,player);
		canJump = true;
	}
	
	public boolean isValid(int fromRowPos,int fromColPos,int toRowPos,int toColPos, Board board) {
		boolean valid=false;
		
		if( Math.abs(fromRowPos-toRowPos)==2 &&  Math.abs(fromColPos-toColPos)==1  ) {
			valid=true;
		}else if( Math.abs(fromRowPos-toRowPos)==1 &&  Math.abs(fromColPos-toColPos)==2 ) {
			valid=true;
		}
		
		if( valid ) {
			return true;
		}
		return false;
		
	}
	
}
