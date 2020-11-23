package ChessImpl;

import com.chess.coins.Bishop;
import com.chess.coins.Coin;
import com.chess.coins.Horse;
import com.chess.coins.King;
import com.chess.coins.Pawn;
import com.chess.coins.Queen;
import com.chess.coins.Rook;

public class Board {
	Coin coins[][] = new Coin[8][8];
	Coin whiteKing;
	Coin blackKing;
	
	public void initialize(Player white,Player black) {
		
		//Pawn initialization
		for(int i=0 ; i<8 ; i++ ) {
			Coin coin = new Pawn("WP",Parameters.FIRSTMOVE,white,black,this);
			coins[1][i] = coin;
		}
		for(int i=0 ; i<8 ; i++) {
			Coin coin = new Pawn("BP",Parameters.FIRSTMOVE,black,white,this);
			coins[6][i] = coin;
		}
//		
		//Rook initialization
		Coin whiteRook1 = new Rook("WR",white,black,this);
		Coin whiteRook2 = new Rook("WR",white,black,this);
		Coin blackRook1 = new Rook("BR",black,white,this);
		Coin blackRook2 = new Rook("BR",black,white,this);
		coins[0][0] = whiteRook1;
		coins[0][7] = whiteRook2;
		coins[7][0] = blackRook1;
		coins[7][7] = blackRook2;
		
		//Bishop initialization
		Coin whiteBishop1 = new Bishop("WB",white,black,this);
		Coin whiteBishop2 = new Bishop("WB",white,black,this);
		Coin blackBishop1 = new Bishop("BB",black,white,this);
		Coin blackBishop2 = new Bishop("BB",black,white,this);
		coins[0][2] = whiteBishop1;
		coins[0][5] = whiteBishop2;
		coins[7][2] = blackBishop1;
		coins[7][5] = blackBishop2;
		
		//Horse initialization
		
		Coin whiteHorse1 = new Horse("WH",white,black,this);
		Coin whiteHorse2 = new Horse("WH",white,black,this);
		Coin blackHorse1 = new Horse("BH",black,white,this);
		Coin blackHorse2 = new Horse("BH",black,white,this);
		coins[0][1] = whiteHorse1;
		coins[0][6] = whiteHorse2;
		coins[7][1] = blackHorse1;
		coins[7][6] = blackHorse2;
		
		//Queen initialization
		
		Coin whiteQueen  = new Queen("WQ",white,black,this);
		Coin blackQueen  = new Queen("BQ",black,white,this);
		coins[0][3] = whiteQueen;
		coins[7][4] = blackQueen;
		
		//King initialization
		Coin whiteKing = new King("WK",white,black,this);
		Coin blackKing = new King("BK",black,white,this);
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
	
	public boolean move(int x1,int y1,int x2,int y2,boolean turn) {	
		
		if( x1==x2 && y1==y2 )
			return false;
		
		Coin coin = coins[x1][y1];
		Coin temp;
		
		if(turn && !whiteKing.isSafe()) {
			
			if(coin.isValid(x1,y1,x2,y2)) {
				temp = coins[x2][y2];
				coins[x2][y2] = coin;
				if(whiteKing.isSafe()) {
					coins[x1][y1] = null;
					return true;
				}else {
					coins[x1][y1]=coin;
					coins[x2][y2]=temp;
					if(temp!=null)temp.reverse();
					return false;
				}
			}
			
		}else if(!turn && !blackKing.isSafe()) {
			
			if(coin.isValid(x1,y1,x2,y2)) {
				temp = coins[x2][y2];
				coins[x2][y2] = coin;
				if( blackKing.isSafe() ) {
					coins[x1][y1] = null;
					return true;
				}else {
					coins[x1][y1]=coin;
					coins[x2][y2]=temp;
					if(temp!=null)temp.reverse();
					return false;
				}
			}
		}else if(coin.isValid(x1,y1,x2,y2)) {
			temp = coins[x2][y2];
			coins[x2][y2] = coin;
			coins[x1][y1]=null;
			if((turn && !whiteKing.isSafe()) || (!turn && !blackKing.isSafe())) {
				
				coins[x1][y1]=coin;
				coins[x2][y2]=temp;
				if(temp!=null)temp.reverse();
				return false;
			}
			return true;
		}
			return false;
	}
	
	public boolean isNull(int x,int y) {
		if(coins[x][y]==null)
			return true;
		else
			return false;
	}
	
	public boolean isOpponent(int x,int y,boolean opponent) {
		Coin coin = coins[x][y];
		if(coin.getPlayer().getWhite() == opponent) {
			return true;
		}
		return false;
	}
	
	public Coin getCoin(int x,int y) {
		return coins[x][y];
	}
	
//	public boolean isCheckMate(boolean turn) {
//		boolean isCheckMate;
//		if(turn) {
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
