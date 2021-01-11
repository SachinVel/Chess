package com.chess.core;

import com.chess.util.ChessException;
import com.chess.util.Parameters;
import com.chess.util.Position;

public class Game {
	Board board;
	Player white;
	Player black;
	boolean isWhiteturn = true;
	
	Game() throws ChessException{
		this.board = new Board();
		this.white = new Player(Parameters.WHITEFLAG,new Position(Parameters.WHITE_KING_POSITION));
		this.black = new Player(Parameters.BLACKFLAG,new Position(Parameters.BLACK_KING_POSITION));
		board.initialize(white,black);
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
	
	public void move(String fromPosStr,String toPosStr ) throws ChessException{
		
		boolean valid=false;
		
		Position fromPos = new Position(fromPosStr);
		Position toPos = new Position(toPosStr);
		
		if(board.isNull(fromPos)) {
			valid = false;
		}
		else if( isWhiteturn == board.getCoin(fromPos).getCoinOwner().isWhite()) {
			valid = board.move(fromPos, toPos,isWhiteturn);
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
