package ChessImpl;

public class Queen extends Coins{
	Rook rook;
	Bishop bishop;
	
	Queen(String name,Player player,Player opponent , Board board){
		super(name,player,opponent,board);
		this.rook = new Rook("temp",player,opponent,board);
		this.bishop = new Bishop("temp",player,opponent,board);
	}
	
	public boolean isValid(int x1,int y1,int x2,int y2) {
		
		boolean valid = false;
		
		valid = rook.isValid(x1, y1, x2, y2);
		
		if(!valid)
			valid = bishop.isValid(x1, y1, x2, y2);
		
		return valid;
			
	}
	
	public void reverse() {
		player.putCoin(this);
	}
}
