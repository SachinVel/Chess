package ChessImpl;

public class Pawn extends Coins{
	boolean firstMove;
	
	public Pawn(String name,boolean firsMove,Player player,Player opponent,Board board){
		super(name,player,opponent,board);
		this.firstMove = firstMove;
	}
	
	@Override
	public boolean isValid(int x1,int y1,int x2,int y2) {
		
		
		if(player.getWhite()) {
			//first move
			if(!firstMove) {
				if(y1==y2 && (x1+2)==x2 && board.isNull(x2,y2)) {
					firstMove = true;
					return true;
				}
			}
			//normal move
			if( y1 == y2 && (x1+1)==x2 && board.isNull(x2, y2)) {
				firstMove = true;
				return true;	
			}
			//cross move
			if((x1+1)==x2 && ((y1-1)==y2||(y1+1)==y2) && !board.isNull(x2, y2) && board.isOpponent(x2, y2, opponent.getWhite())){
				firstMove = true;
				Coins coin = board.getCoin(x2, y2);
				opponent.cutCoin(coin);
				return true;
			}
			
			return false;
		}else {
			if(!firstMove) {
				if(y1==y2 && (x1-2)==x2 && board.isNull(x2, y2)) {
					firstMove = true;
					return true;
				}
			}
			if( y1 == y2 && (x1-1)==x2 && board.isNull(x2, y2)) {
				firstMove = true;
				return true;
				
			}
			
			if((x1-1)==x2 && ((y1-1)==y2||(y1+1)==y2) && !board.isNull(x2, y2) && board.isOpponent(x2, y2, opponent.getWhite())){
				firstMove = true;
				Coins coin = board.getCoin(x2, y2);
				opponent.cutCoin(coin);
				return true;
			}
			
			return false;
		}
	}
	
	public void reverse() {
			player.putCoin(this);
		
	}
	
}
