package ChessImpl;

import com.chess.coins.Coin;

public class Player {
	boolean white;
	int pawns = 8;
	int rooks = 2;
	int bishops = 2;
	int horses = 2;
	int queen = 1;
	int king = 1;
	int xKingPosition;
	int yKingPosition;
	
	Player(boolean white,int xKingPosition,int yKingPosition){
		this.white = white;
		this.xKingPosition = xKingPosition;
		this.yKingPosition = yKingPosition;
	}
	
	public void cutCoin(Coin coin) {
		if(coin.getClass().getSimpleName().equals("Pawn"))
			this.pawns--;
		if(coin.getClass().getSimpleName().equals("Rook"))
			this.rooks--;
		if(coin.getClass().getSimpleName().equals("Bishop"))
			this.bishops--;
		if(coin.getClass().getSimpleName().equals("Horse"))
			this.horses--;
		if(coin.getClass().getSimpleName().equals("Queen"))
			this.queen--;
	}
	public void putCoin(Coin coin) {
		if(coin.getClass().getSimpleName().equals("Pawn"))
			this.pawns++;
		if(coin.getClass().getSimpleName().equals("Rook"))
			this.rooks++;
		if(coin.getClass().getSimpleName().equals("Bishop"))
			this.bishops++;
		if(coin.getClass().getSimpleName().equals("Horse"))
			this.horses++;
		if(coin.getClass().getSimpleName().equals("Queen"))
			this.queen++;
	}
	public boolean getWhite() {
		return white;
	}
	
	public int getScore() {
		int score=0;
		score += pawns*1;
		score += rooks*5;
		score += bishops*3;
		score += horses*3;
		score += queen*9;
		return score;
	}
	
	public void setKingPosition(int x,int y) {
		xKingPosition = x;
		yKingPosition = y;
	}
	
	public int getXKingPosition() {
		return xKingPosition;
	}
	
	public int getYKingPosition() {
		return yKingPosition;
	}
	
}
