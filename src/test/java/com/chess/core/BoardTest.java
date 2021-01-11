package com.chess.core;


import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.chess.coins.Coin;
import com.chess.util.ChessException;
import com.chess.util.Parameters;
import com.chess.util.Position;

public class BoardTest {
	private static Board board;
	private static Player whitePlayer;
	private static Player blackPlayer;
	
	@BeforeClass
	public static void initialiseBoard() throws ChessException{
		whitePlayer = new Player(Parameters.WHITEFLAG,new Position(Parameters.WHITE_KING_POSITION));
		blackPlayer = new Player(Parameters.BLACKFLAG,new Position(Parameters.BLACK_KING_POSITION));
		board = new Board();
		board.initialize(whitePlayer,blackPlayer);
	}
	
	@Test
	public void getCoinTest() throws ChessException{
		Position curPos = new Position("A2");
		Coin coin = board.getCoin(curPos);
		assertEquals("getCoin() position is improper","WP", coin.getName());
	}
	
	@Test 
	public void isOpponentTest() throws ChessException{
		Position blackPawnPos = new Position("A7");
		Position whitePawnPos = new Position("B2");
		Coin whitePawn = board.getCoin(new Position("A2"));
		
		assertEquals("isOpponent() not identifying opponent coin", true,  board.isOpponent(blackPawnPos, whitePawn.getCoinOwner()));
		
		assertEquals("isOpponent() not identifying same coin", false,  board.isOpponent(whitePawnPos, whitePawn.getCoinOwner()));
	}
	
	@Test 
	public void isNullTest() throws ChessException{
		Position noCoinPos = new Position("A3");
		Position coinPos = new Position("A2");
		assertEquals("isNull() not identifying null position",true, board.isNull(noCoinPos));
		assertEquals("isNull() not identifying coin position",false, board.isNull(coinPos));
	}
}
