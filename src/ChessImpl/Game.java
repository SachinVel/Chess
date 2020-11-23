package ChessImpl;

public class Game {
	Board board;
	Player white;
	Player black;
	boolean turn = true;
	
	Game(Board board,Player white,Player black){
		this.board = board;
		this.white = white;
		this.black = black;
	}
	
	public void display() {
		System.out.println("Black score : "+black.getScore());
		System.out.println("White Score : "+white.getScore());
		board.displayBoard();
		displayTurn();
		
	}
	
	
	
	private void displayTurn() {
		if(turn)
			System.out.println("White's turn...");
		else
			System.out.println("Black's turn...");
	}
	
	public int getWhiteScore() {
		return white.getScore();
	}
	
	public int getBlackScore() {
		return black.getScore();
	}
	
	public void move(int x1,int y1,int x2,int y2 ) {
		
		boolean valid=false;
		x1--;y1--;x2--;y2--;
		if( (x1<0 ||x1>7) || (x2<0||x2>7) || ( y1<0||y1>7 ) || (y2<0||y2>7) ) {
			System.out.println("enter valid location");
			return;
		}
		
		if(board.isNull(x1, y1)) {
			valid = false;
		}
		else if(turn && board.getCoin(x1, y1).getPlayer().getWhite()) {
			valid = board.move(x1, y1, x2, y2,turn);
		}
		else if( !turn && !board.getCoin(x1, y1).getPlayer().getWhite()) {
			valid = board.move(x1,y1,x2,y2,turn);
		}
		
		if(valid)
			turn =!turn;
		else {
			System.out.println("Invalid move");
		}
	}
	
//	public boolean isCheckMate() {
//		return board.isCheckMate(turn);
//	}
}
