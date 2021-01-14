package com.chess.coins;

import com.chess.core.Board;
import com.chess.core.Player;
import com.chess.util.Position;

public class Bishop extends Coin{

	public Bishop(String name,Player player){
		super(name,player);
		canJump = false;
	}
	
	public boolean isValid(Position fromPos,Position toPos, Board board) {
		int rowDif = Math.abs(fromPos.rowPos-toPos.rowPos);
		int colDif = Math.abs(fromPos.colPos-toPos.colPos);
		int rowStartPos = Math.min(fromPos.rowPos, toPos.rowPos);
		int colStartPos = Math.min(fromPos.colPos,toPos.colPos);
		int rowEndPos = fromPos.rowPos+toPos.rowPos-rowStartPos;
		int colEndPos = fromPos.colPos+toPos.colPos-colStartPos;
		
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
		boolean isDestinationValid =  board.isOpponent(toPos, coinOwner)||board.isNull(toPos.rowPos,toPos.colPos);
		
		if( valid && !inBetween && isDestinationValid )
			return true;
		
		return false;		
	}
}
