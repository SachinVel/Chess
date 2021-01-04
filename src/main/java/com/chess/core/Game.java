package com.chess.core;

import com.chess.util.ChessException;
import com.chess.util.Position;

public class Game {
	Board board;
	Player white;
	Player black;
	boolean isWhiteturn = true;
	
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
		if(isWhiteturn)
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
	
	public void move(String fromPos,String toPos ) throws ChessException{
		
		boolean valid=false;
		
		int fromRowPos = Position.getRowPos(fromPos);
		int fromColPos = Position.getColPos(fromPos);
		int toRowPos = Position.getRowPos(toPos);
		int toColPos = Position.getColPos(toPos);
		
		System.out.println("from : "+fromRowPos+" "+fromColPos);
		if(board.isNull(fromRowPos, fromColPos)) {
			valid = false;
		}
		else if( isWhiteturn == board.getCoin(fromRowPos, fromColPos).getCoinOwner().isWhite()) {
			valid = board.move(fromRowPos, fromColPos, toRowPos, toColPos,isWhiteturn);
		}
		
		if(valid)
			isWhiteturn =!isWhiteturn;
		else {
			throw new ChessException("Invalid Move");
		}
	}
	
//	public boolean isCheckMate() {
//		return board.isCheckMate(turn);
//	}
}
