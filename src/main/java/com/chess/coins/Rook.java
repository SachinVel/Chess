package com.chess.coins;

import com.chess.core.Board;
import com.chess.core.Player;
import com.chess.util.Position;

public class Rook extends Coin{
	
	
	public Rook(String name,Player player) {
		super(name,player);
		canJump = false;
	}
	
	@Override
	public boolean isValid(Position fromPos,Position toPos,Board board) {
		boolean inBetween=false,valid=false;
		if((fromPos.rowPos==toPos.rowPos)) {
			valid=true;
			int startColPos = Math.min(fromPos.colPos,toPos.colPos);
			int endColPos = fromPos.colPos+toPos.colPos-startColPos;
			for(int currentColPos=startColPos+1 ; currentColPos<endColPos ; currentColPos++) {
				if(!board.isNull(fromPos.rowPos,currentColPos)) {
					inBetween=true;
					break;
				}
			}
		}else if(fromPos.colPos==toPos.colPos) {
			valid=true;
			int startRowPos = Math.min(fromPos.rowPos,toPos.rowPos);
			int endRowPos = fromPos.rowPos+toPos.rowPos-startRowPos;
			
			for(int currentRowPos=startRowPos+1 ; currentRowPos<endRowPos ; currentRowPos++) {
				if(!board.isNull(currentRowPos,fromPos.colPos)) {
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
