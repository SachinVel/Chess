package ChessImpl;

public class Bishop extends Coins{

	Bishop(String name,Player player ,Player opponent,Board board){
		super(name,player,opponent,board);
	}
	
	public boolean isValid(int x1,int y1,int x2,int y2) {
		int i,j;
		int xDif = Math.abs(x1-x2);
		int yDif = Math.abs(y1-y2);
		boolean valid=false,inBetween=false;
		if( xDif==yDif ){
			valid = true;
			for( i=x1+1,j=y1+1 ; i<x2&&j<y2 ; i++,j++ ) {
				if(!board.isNull(i,j)) {
					inBetween=true;
					break;
				}
			}
			for( i=x1-1,j=y1-1 ; i>x2&&j>y2 ; i--,j-- ) {
				if(!board.isNull(i,j)) {
					inBetween=true;
					break;
				}
			}
			for( i=x1+1,j=y1-1 ; i<x2&&j>y2 ; i++,j-- ) {
				if(!board.isNull(i,j)) {
					inBetween=true;
					break;
				}
			}
			for( i=x1-1,j=y1+1 ; i>x2&&j<y2 ; i--,j++ ) {
				if(!board.isNull(i,j)) {
					inBetween=true;
					break;
				}
			}
		}
		if(valid && !inBetween && board.isNull(x2, y2))
			return true;
		if( valid && !inBetween && !board.isNull(x2, y2) && board.isOpponent(x2, y2, opponent.getWhite())) {
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
