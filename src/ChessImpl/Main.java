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
		String fromPos,toPos;
		Scanner scanner = new Scanner(System.in);
		
		//implementation
		while(!exitFlag) {
				game.display();
				System.out.println("enter coin location : ");
				fromPos = scanner.next();
				System.out.println("enter move location : ");
				toPos = scanner.next();
				game.move(x1,y1,x2,y2);
//				if(game.isCheckMate()) {
//					exitFlag=true;
//				}
				System.out.println();
		}
	}
}
