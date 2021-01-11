package com.chess.core;

import java.util.*;

import com.chess.util.Parameters;

public class Main {
	
	public static void main(String[] args) {
		
		
		try (Scanner scanner = new Scanner(System.in)){
			
			Game game = new Game();
			
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
