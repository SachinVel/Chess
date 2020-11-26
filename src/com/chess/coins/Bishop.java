package com.chess.coins;

import ChessImpl.Board;
import ChessImpl.Player;

public class Bishop extends Coin{

	public Bishop(String name,Player player){
		super(name,player);
		canJump = false;
	}
	
	public boolean isValid(int fromRowPos,int fromColPos,int toRowPos,int toColPos, Board board) {
		int rowDif = Math.abs(fromRowPos-toRowPos);
		int colDif = Math.abs(fromColPos-toColPos);
		int rowStartPos = Math.min(fromRowPos, toRowPos);
		int colStartPos = Math.min(fromColPos,toColPos);
		int rowEndPos = fromRowPos+toRowPos-rowStartPos;
		int colEndPos = fromColPos+toColPos-colStartPos;
		
		boolean valid=false,inBetween=false;
		if( rowDif==colDif ){
			valid = true;
			for(int currentRowPos=rowStartPos+1,currentColPos=colStartPos+1 ; currentRowPos<rowEndPos&&currentColPos<colEndPos ; currentRowPos++,currentColPos++ ) {
				if(!board.isNull(currentRowPos,currentColPos)) {
					inBetween=true;
					break;
				}
			}
		}
		if(valid && !inBetween )
			return true;
		
		return false;		
	}
}
