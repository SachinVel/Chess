package com.chess.core;

import java.util.*;

import com.chess.util.Parameters;

public class Main {
	
	
	private static Game init() {
		Board board = new Board();
		Player white = new Player(Parameters.WHITEFLAG,Parameters.WHITEKINGPOSITIONX,Parameters.WHITEKINGPOSITIONY);
		Player black = new Player(Parameters.BLACKFLAG,Parameters.BLACKKINGPOSITIONX,Parameters.BLACKKINGPOSITIONY);
		board.initialize(white,black);
		return new Game(board,white,black);
	}
	
	
	public static void main(String[] args) {
		
		
		try (Scanner scanner = new Scanner(System.in)){
			Game game = init();
			
			boolean exitFlag = false;
			String fromPos,toPos;

			while(!exitFlag) {
					game.display();
					System.out.println("enter coin location : ");
					fromPos = scanner.next();
					System.out.println("enter move location : ");
					toPos = scanner.next();
					game.move(fromPos,toPos);
//					if(game.isCheckMate()) {
//						exitFlag=true;
//					}
					System.out.println();
			}
		}catch (Exception e) {
			
			System.out.println("Violated chess rule : "+e.getMessage());
			e.printStackTrace();
		}
		
	}
}
