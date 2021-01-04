package com.chess.coins;

import com.chess.core.Board;
import com.chess.core.Player;

public class Rook extends Coin{
	
	
	public Rook(String name,Player player) {
		super(name,player);
		canJump = false;
	}
	
	@Override
	public boolean isValid(int fromRowPos,int fromColPos,int toRowPos,int toColPos,Board board) {
		boolean inBetween=false,valid=false;
		if((fromRowPos==toRowPos)) {
			valid=true;
			int startColPos = Math.min(fromColPos,toColPos);
			int endColPos = fromColPos+toColPos-startColPos;
			for(int currentColPos=startColPos+1 ; currentColPos<endColPos ; currentColPos++) {
				if(!board.isNull(fromRowPos,currentColPos)) {
					inBetween=true;
					break;
				}
			}
		}else if(fromColPos==toColPos) {
			valid=true;
			int startRowPos = Math.min(fromRowPos,toRowPos);
			int endRowPos = fromRowPos+toRowPos-startRowPos;
			
			for(int currentRowPos=startRowPos+1 ; currentRowPos<endRowPos ; currentRowPos++) {
				if(!board.isNull(currentRowPos,fromColPos)) {
					inBetween=true;
					break;
				}
			}
		}
		if( valid && !inBetween )
			return true;
		return false;
	}
}
