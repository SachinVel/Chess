package com.chess.core;

import com.chess.coins.Bishop;
import com.chess.coins.Coin;
import com.chess.coins.Horse;
import com.chess.coins.King;
import com.chess.coins.Pawn;
import com.chess.coins.Queen;
import com.chess.coins.Rook;
import com.chess.util.ChessException;
import com.chess.util.Parameters;
import com.chess.util.Position;

public class Board {
	
	Coin coins[][] = new Coin[8][8];
	Coin whiteKing;
	Coin blackKing;
	
	public void initialize(Player white,Player black) {
		
		//Pawn initialization
		for(int i=0 ; i<8 ; i++ ) {
			Coin coin = new Pawn("WP",Parameters.FIRSTMOVE,white);
			coins[1][i] = coin;
		}
		for(int i=0 ; i<8 ; i++) {
			Coin coin = new Pawn("BP",Parameters.FIRSTMOVE,black);
			coins[6][i] = coin;
		}
//		
		//Rook initialization
		Coin whiteRook1 = new Rook("WR",white);
		Coin whiteRook2 = new Rook("WR",white);
		Coin blackRook1 = new Rook("BR",black);
		Coin blackRook2 = new Rook("BR",black);
		coins[0][0] = whiteRook1;
		coins[0][7] = whiteRook2;
		coins[7][0] = blackRook1;
		coins[7][7] = blackRook2;
		
		//Bishop initialization
		Coin whiteBishop1 = new Bishop("WB",white);
		Coin whiteBishop2 = new Bishop("WB",white);
		Coin blackBishop1 = new Bishop("BB",black);
		Coin blackBishop2 = new Bishop("BB",black);
		coins[0][2] = whiteBishop1;
		coins[0][5] = whiteBishop2;
		coins[7][2] = blackBishop1;
		coins[7][5] = blackBishop2;
		
		//Horse initialization
		
		Coin whiteHorse1 = new Horse("WH",white);
		Coin whiteHorse2 = new Horse("WH",white);
		Coin blackHorse1 = new Horse("BH",black);
		Coin blackHorse2 = new Horse("BH",black);
		coins[0][1] = whiteHorse1;
		coins[0][6] = whiteHorse2;
		coins[7][1] = blackHorse1;
		coins[7][6] = blackHorse2;
		
		//Queen initialization
		
		Coin whiteQueen  = new Queen("WQ",white);
		Coin blackQueen  = new Queen("BQ",black);
		coins[0][3] = whiteQueen;
		coins[7][4] = blackQueen;
		
		//King initialization
		Coin whiteKing = new King("WK",white);
		Coin blackKing = new King("BK",black);
		coins[0][4] = whiteKing;
		coins[7][3] = blackKing;
		
		this.whiteKing = whiteKing;
		this.blackKing = blackKing;
		
		
	}
	
	public void displayBoard() {
		System.out.println("  A  B  C  D  E  F  G  H ");
		for(int i=7 ; i>=0 ; i-- ) {
			System.out.print(i+1+" ");
			for(int j=0 ; j<=7 ; j++ ) {
				Coin coin = coins[i][j];
				if(coin!=null)
					System.out.print (coin.getName()+" ");
				else
					System.out.print("-- ");
			}
			System.out.println(i+1+" ");
		}
		System.out.println("  A  B  C  D  E  F  G  H ");
	}
	
	public boolean move(Position fromPos,Position toPos,boolean isWhiteTurn) throws ChessException{	
		
		if( fromPos.rowPos==toPos.rowPos && fromPos.colPos==toPos.colPos ) {
			throw new ChessException("cannot move into same location");
		}
		Player opponentPlayer;
		Coin currentCoin = coins[fromPos.rowPos][fromPos.colPos];
		Coin destCoin;
		
		if(currentCoin.isValid(fromPos,toPos,this)) {
			destCoin = coins[toPos.rowPos][toPos.colPos];
			if( destCoin==null ) {
				coins[toPos.rowPos][toPos.colPos] = currentCoin;
				coins[fromPos.rowPos][fromPos.colPos]=null;
				return true;
			}else if( destCoin.getCoinOwner()!=currentCoin.getCoinOwner() ){
				opponentPlayer = destCoin.getCoinOwner();
				opponentPlayer.cutCoin(destCoin);
			}else {
				throw new ChessException("cannot kill own piece");
			}
			
		}
		return false;
	}
	
	public boolean isNull(int curRowInd,int curColInd) {
		if(coins[curRowInd][curColInd]==null)
			return true;
		else
			return false;
	}
	
	public boolean isNull(Position curPos) {
		if(coins[curPos.rowPos][curPos.colPos]==null)
			return true;
		else
			return false;
	}
	
	public boolean isOpponent(Position curPos,Player coinOwner) {
		Coin destCoin = coins[curPos.rowPos][curPos.colPos];
		if(coinOwner.isWhite() != destCoin.getCoinOwner().isWhite()) {
			return true;
		}
		return false;
	}
	
	public Coin getCoin(Position curPos) {
		return coins[curPos.rowPos][curPos.colPos];
	}
	
//	public boolean isCheckMate(boolean isWhiteTurn) {
//		boolean isCheckMate;
//		if(isWhiteTurn) {
//			int whiteXPos = whiteKing.getPlayer().getXKingPosition();
//			int whiteYPos = whiteKing.getPlayer().getYKingPosition();
//			isCheckMate = whiteKing.isCheckMate();
//			whiteKing.getPlayer().setKingPosition(whiteXPos, whiteYPos);
//			return isCheckMate;
//		}
//		
//		else {
//			int blackXPos = blackKing.getPlayer().getXKingPosition();
//			int blackYPos = blackKing.getPlayer().getYKingPosition();
//			isCheckMate = blackKing.isCheckMate();
//			blackKing.getPlayer().setKingPosition(blackXPos, blackYPos);
//			return isCheckMate;
//		}
//	}
}
