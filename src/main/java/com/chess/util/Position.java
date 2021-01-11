package com.chess.util;

import com.chess.coins.Coin;
import com.chess.core.Board;

public class Position {
	public int rowPos,colPos;
	
	public Position(String position) throws ChessException{
		if( !isPositionValid(position) ) {
			throw new ChessException("Position is invalid");
		} 
		this.rowPos = (Integer.parseInt(position.substring(1,2))-1);
		this.colPos = (int)position.charAt(0)-'A';
	}
	
	private static boolean isPositionValid(String position) {

		if( position.length()!=2 ) {
			return false;
		}
		
		if( !position.matches("[A-F]{1}[1-8]{1}") ) {
			return false;
		}
			
		return true;
	}
	
	
}
