package ChessImpl;

import java.util.*;

public class Main {
	
	
	private static Game init() {
		Board board = new Board();
		Player white = new Player(Parameters.WHITEFLAG,Parameters.WHITEKINGPOSITIONX,Parameters.WHITEKINGPOSITIONY);
		Player black = new Player(Parameters.BLACKFLAG,Parameters.BLACKKINGPOSITIONX,Parameters.BLACKKINGPOSITIONY);
		board.initialize(white,black);
		return new Game(board,white,black);
	}
	
	
	public static void main(String[] args) {
		
		//Initialisation
		
		Game game = init();
		
		//variable declaration
		boolean exitFlag = false;
		int ch,x1,y1,x2,y2;
		Scanner s = new Scanner(System.in);
		
		//implementation
		while(!exitFlag) {
				game.displayBoard();
				System.out.println("enter the location of coin : ");
				x1 = s.nextInt();
				y1 = s.nextInt();
				System.out.println("enter the location of move : ");
				x2 = s.nextInt();
				y2 = s.nextInt();
				game.move(x1,y1,x2,y2);
//				if(game.isCheckMate()) {
//					exitFlag=true;
//				}
				System.out.println();
		}
	}
}
