package com.chess.coins;

import ChessImpl.Board;
import ChessImpl.Player;

public class Rook extends Coin{
	
	
	public Rook(String name,Player player,Player opponent,Board board) {
		super(name,player,opponent,board);
	}
	@Override
	public boolean isValid(int x1,int y1,int x2,int y2) {
		boolean inBetween=false,valid=false;
		if((x1==x2)) {
			valid=true;
			for(int i=y1+1 ; i<y2 ; i++) {
				if(!board.isNull(x1,i)) {
					inBetween=true;
					break;
				}
			}
			for(int i=y1-1 ; i>y2 ; i--) {
				if(!board.isNull(x1,i)) {
					inBetween=true;
					break;
				}
			}
		}else if(y1==y2) {
			valid=true;
			for(int i=x1+1 ; i<x2 ; i++) {
				if(!board.isNull(i,y1)) {
					inBetween=true;
					break;
				}
			}
			for(int i=x1-1 ; i>x2 ; i--) {
				if(!board.isNull(i,y1)) {
					inBetween=true;
					break;
				}
			}
		}
		if(valid && !inBetween && board.isNull(x2, y2))
			return true;
		if(valid && !inBetween && !board.isNull(x2, y2) && board.isOpponent(x2, y2, opponent.getWhite())) {
			Coin coin = board.getCoin(x2, y2);
			opponent.cutCoin(coin);
			return true;
		}
		return false;
	}
	
	public void reverse() {
		player.putCoin(this);
	
	}
}
