package com.chess.util;

import com.chess.coins.Coin;

import ChessImpl.Board;

public class Position {
	int rowPos,colPos;
	
	public Position(String position) throws ChessException{
		if( !isPositionValid(position) ) {
			throw new ChessException("Position is invalid");
		} 
		this.rowPos = getRowPos(position);
		this.colPos = getColPos(position);
	}
	
	public static int getRowPos(String position) {
		return (Integer.parseInt(position.substring(1,2))-1);
	}
	
	public static int getColPos(String position) {
		return (int)position.charAt(1)-'A';
	}
	
	private static boolean isPositionValid(String position) {

		if( position.length()!=2 ) {
			return false;
		}
		
		if( !position.matches("[A-Z]{1}[1-8]{1}") ) {
			return false;
		}
			
		return true;
	}
	
	public static Coin getCoinFromPosition(Board board,String position) throws ChessException{
		if( !isPositionValid(position) ) {
			throw new ChessException("Position is invalid");
		}
		int rowPos = getRowPos(position);
		int colPos = getColPos(position);
		return board.getCoin(rowPos, colPos);
	}
}
