package ChessImpl;

public class Horse extends Coins{
	
	Horse(String name,Player player,Player opponent,Board board){
		super(name,player,opponent,board);
	}
	
	public boolean isValid(int x1,int y1,int x2,int y2) {
		boolean valid=false;
		
		if( (x1+2)==x2 && ( Math.abs(y1-y2)==1 ) ) {
			valid=true;
		}
		if( (x1-2)==x2 && ( Math.abs(y1-y2)==1 ) ) {
			valid=true;
		}
		if( (y1-2)==y2 && ( Math.abs(x1-x2)==1 ) ) {
			valid=true;
		}
		if( (y1+2)==y2 && ( Math.abs(x1-x2)==1 ) ) {
			valid=true;
		}
		if(valid && board.isNull(x2, y2))
			return true;
		else if(valid && !board.isNull(x2, y2) && board.isOpponent(x2, y2, opponent.getWhite())) {
			Coins coin = board.getCoin(x2, y2);
			opponent.cutCoin(coin);
			return true;
		}
		return false;
		
	}
	
	public void reverse() {
		player.putCoin(this);
	
	}
	
}
