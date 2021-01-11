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
		if( Math.abs(fromPos.rowPos-toPos.rowPos)<=1 && Math.abs(fromPos.colPos-toPos.colPos)<=1 ) {
			coinOwner.setKingPosition(toPos);
			return true;
		}
		return false;
	}
	
	
//	public boolean plusCheck(int xPos,int yPos) {
//		for( int i=xPos+1 ; i<=7 ; i++ ) {
//			Coin coin = board.getCoin(i, yPos);
//			if(coin==null)
//				continue;
//			else if( !board.isOpponent(i, yPos, opponent.getWhite()) )
//				break;
//			else if(board.isOpponent(i, yPos, opponent.getWhite()) && (coin.getClass().getSimpleName().equals("Rook")||coin.getClass().getSimpleName().equals("Queen")))
//				return false;
//			else
//				break;
//		}
//		
//		for( int i=xPos-1 ; i>=0 ; i-- ) {
//			Coin coin = board.getCoin(i, yPos);
//			if(coin==null)
//				continue;
//			else if( !board.isOpponent(i, yPos, opponent.getWhite()) )
//				break;
//			else if(board.isOpponent(i, yPos, opponent.getWhite()) && (coin.getClass().getSimpleName().equals("Rook")||coin.getClass().getSimpleName().equals("Queen")))
//				return false;
//			else
//				break;
//		}
//		
//		for( int i=yPos+1 ; i<=7 ; i++ ) {
//			Coin coin = board.getCoin(xPos,i);
//			if(coin==null)
//				continue;
//			else if( !board.isOpponent(xPos,i,opponent.getWhite()) )
//				break;
//			else if(board.isOpponent(xPos,i, opponent.getWhite()) && (coin.getClass().getSimpleName().equals("Rook")||coin.getClass().getSimpleName().equals("Queen")))
//				return false;
//			else
//				break;	
//		}
//		for( int i=yPos-1 ; i>=0 ; i-- ) {
//			Coin coin = board.getCoin(xPos,i);
//			if(coin==null)
//				continue;
//			else if( !board.isOpponent(xPos,i,opponent.getWhite()) )
//				break;
//			else if(board.isOpponent(xPos,i, opponent.getWhite()) && (coin.getClass().getSimpleName().equals("Rook")||coin.getClass().getSimpleName().equals("Queen")))
//				return false;
//			else 
//				break;
//		}
//		return true;
//	}
//	
//	public boolean crossCheck(int xPos,int yPos) {
//		int i,j;
//		for( i=xPos+1,j=yPos+1 ; i<=7&&j<=7 ; i++,j++ ) {
//			Coin coin = board.getCoin(i,j);
//			if(coin==null)
//				continue;
//			else if( !board.isOpponent(i,j,opponent.getWhite()) )
//				break;
//			else if(board.isOpponent(i,j, opponent.getWhite()) && (coin.getClass().getSimpleName().equals("Bishop")||coin.getClass().getSimpleName().equals("Queen")))
//				return false;
//			else
//				break;
//		}
//		for( i=xPos-1,j=yPos-1 ; i>=0&&j>=0 ; i--,j-- ) {
//			Coin coin = board.getCoin(i,j);
//			if(coin==null)
//				continue;
//			else if( !board.isOpponent(i,j,opponent.getWhite()) )
//				break;
//			else if(board.isOpponent(i,j, opponent.getWhite()) && (coin.getClass().getSimpleName().equals("Bishop")||coin.getClass().getSimpleName().equals("Queen")))
//				return false;
//			else
//				break;
//		}
//		for( i=xPos+1,j=yPos-1 ; i<=7&&j>=0 ; i++,j-- ) {
//			Coin coin = board.getCoin(i,j);
//			if(coin==null)
//				continue;
//			else if( !board.isOpponent(i,j,opponent.getWhite()) )
//				break;
//			else if(board.isOpponent(i,j, opponent.getWhite()) && (coin.getClass().getSimpleName().equals("Bishop")||coin.getClass().getSimpleName().equals("Queen")))
//				return false;
//			else
//				break;
//		}
//		for( i=xPos-1,j=yPos+1 ; i>=0&&j<=7 ; i--,j++ ) {
//			Coin coin = board.getCoin(i,j);
//			if(coin==null)
//				continue;
//			else if( !board.isOpponent(i,j,opponent.getWhite()) )
//				break;
//			else if(board.isOpponent(i,j, opponent.getWhite()) && (coin.getClass().getSimpleName().equals("Bishop")||coin.getClass().getSimpleName().equals("Queen")))
//				return false;
//			else
//				break;
//		}
//		return true;
//	}
	
//	public boolean horseCheck(int xPos,int yPos) {
//		int toPos.rowPos,toPos.colPos;
//
//		if( (xPos+2)<=7 ) {
//			toPos.rowPos = xPos+2;
//			if( yPos+1<=7 ){
//				toPos.colPos = yPos+1;
//				if( !board.isNull(toPos.rowPos, toPos.colPos) && board.isOpponent(toPos.rowPos, toPos.colPos, opponent.getWhite()) && board.getCoin(toPos.rowPos, toPos.colPos).getClass().getSimpleName().equals("Horse"))
//					return false;
//			}else if( yPos-1>=0 ) {
//				toPos.colPos = yPos-1;
//				if( !board.isNull(toPos.rowPos, toPos.colPos) && board.isOpponent(toPos.rowPos, toPos.colPos, opponent.getWhite()) && board.getCoin(toPos.rowPos, toPos.colPos).getClass().getSimpleName().equals("Horse"))
//					return false;
//			}
//		}
//		if( (xPos-2)>=0 ) {
//			toPos.rowPos = xPos-2;
//			if( yPos+1<=7 ){
//				toPos.colPos = yPos+1;
//				if( !board.isNull(toPos.rowPos, toPos.colPos) && board.isOpponent(toPos.rowPos, toPos.colPos, opponent.getWhite()) && board.getCoin(toPos.rowPos, toPos.colPos).getClass().getSimpleName().equals("Horse"))
//					return false;
//			}else if( yPos-1>=0 ) {
//				toPos.colPos = yPos-1;
//				if( !board.isNull(toPos.rowPos, toPos.colPos) && board.isOpponent(toPos.rowPos, toPos.colPos, opponent.getWhite()) && board.getCoin(toPos.rowPos, toPos.colPos).getClass().getSimpleName().equals("Horse"))
//					return false;
//			}
//		}
//		if( (yPos+2)<=7 ) {
//			toPos.colPos = yPos+2;
//			if( xPos+1<=7 ){
//				toPos.rowPos = xPos+1;
//				if( !board.isNull(toPos.rowPos, toPos.colPos) && board.isOpponent(toPos.rowPos, toPos.colPos, opponent.getWhite()) && board.getCoin(toPos.rowPos, toPos.colPos).getClass().getSimpleName().equals("Horse"))
//					return false;
//			}else if( xPos-1>=0 ) {
//				toPos.rowPos = xPos-1;
//				if( !board.isNull(toPos.rowPos, toPos.colPos) && board.isOpponent(toPos.rowPos, toPos.colPos, opponent.getWhite()) && board.getCoin(toPos.rowPos, toPos.colPos).getClass().getSimpleName().equals("Horse"))
//					return false;
//			}
//		}
//		if( (yPos-2)>=0 ) {
//			toPos.colPos = yPos-2;
//			if( xPos+1<=7 ){
//				toPos.rowPos = xPos+1;
//				if( !board.isNull(toPos.rowPos, toPos.colPos) && board.isOpponent(toPos.rowPos, toPos.colPos, opponent.getWhite()) && board.getCoin(toPos.rowPos, toPos.colPos).getClass().getSimpleName().equals("Horse"))
//					return false;
//			}else if( xPos-1>=0 ) {
//				toPos.rowPos = xPos-1;
//				if( !board.isNull(toPos.rowPos, toPos.colPos) && board.isOpponent(toPos.rowPos, toPos.colPos, opponent.getWhite()) && board.getCoin(toPos.rowPos, toPos.colPos).getClass().getSimpleName().equals("Horse"))
//					return false;
//			}
//		}
//		return true;
//	}
	
//	public boolean isSafe() {
//		int xPos = player.getXKingPosition();
//		int yPos = player.getYKingPosition();
//		boolean isSafe;
//		
//		//plus check
//		isSafe = this.plusCheck(xPos, yPos);
//		
//		//cross check
//		if(isSafe)
//			isSafe = this.crossCheck(xPos, yPos);
//		
//		if(isSafe)
//			isSafe = this.horseCheck(xPos, yPos);
//			
//		return isSafe;
//				
//	}
	
//	@Override
//	public void reverse() {
//		player.putCoin(this);
//	
//	}
	
//	public boolean isCheckMate() {
//		int xPos = player.getXKingPosition();
//		int yPos = player.getYKingPosition();
//		int toPos.rowPos,toPos.colPos;
//		boolean isSafe=false;
//		isSafe = this.isSafe();
//		if((xPos+1)<=7) {
//			if(board.isNull(xPos+1, yPos) && !isSafe) {
//			this.player.setKingPosition(xPos+1,yPos);
//			isSafe = this.isSafe();
//			}
//			
//			if(yPos+1<=7 && !isSafe && board.isNull(xPos+1, yPos+1)) {
//				this.player.setKingPosition(xPos+1,yPos+1);
//				isSafe = this.isSafe();
//			}
//			
//			if(yPos-1>=0 && !isSafe && board.isNull(xPos+1, yPos-1)) {
//				this.player.setKingPosition(xPos+1,yPos-1);
//				isSafe = this.isSafe();
//			}
//				
//		}
//		if((xPos-1)>=0) {
//			if(board.isNull(xPos-1, yPos) && !isSafe) {
//			this.player.setKingPosition(xPos-1,yPos);
//			isSafe = this.isSafe();
//			}
//			
//			if(yPos+1<=7 && !isSafe && board.isNull(xPos-1, yPos+1)) {
//				this.player.setKingPosition(xPos-1,yPos+1);
//				isSafe = this.isSafe();
//			}
//			
//			if(yPos-1>=0 && !isSafe && board.isNull(xPos-1, yPos-1)) {
//				this.player.setKingPosition(xPos-1,yPos-1);
//				isSafe = this.isSafe();
//			}
//				
//		}
//		
//		if((yPos-1)>=0) {
//			if(board.isNull(xPos, yPos-1) && !isSafe) {
//				this.player.setKingPosition(xPos,yPos-1);
//				isSafe = this.isSafe();
//				}
//		}
//		if((yPos+1)<=7) {
//			if(board.isNull(xPos, yPos+1) && !isSafe) {
//				this.player.setKingPosition(xPos,yPos+1);
//				isSafe = this.isSafe();
//				}
//		}
//		if(!isSafe)
//			return true;
//		else
//			return false;
//	}
	
	
}
