package com.chess.core;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.chess.coins.Pawn;
import com.chess.util.ChessException;
import com.chess.util.Parameters;
import com.chess.util.Position;

public class PlayerTest {
	private static Player whitePlayer;
	private static Player blackPlayer;
	
	@Before
	public void globalSetup() throws ChessException{
		whitePlayer = new Player(Parameters.WHITEFLAG,new Position(Parameters.WHITE_KING_POSITION));
		blackPlayer = new Player(Parameters.WHITEFLAG,new Position(Parameters.BLACK_KING_POSITION));
	}
	
	@Test
	public void cutCoinTest() {
		Pawn  pawnCoin = new Pawn("WP", true, whitePlayer);
		whitePlayer.cutCoin(pawnCoin);
		assertEquals("cutCoin() does not cut coin",7,whitePlayer.pawns);
	}
	
	@Test
	public void putCoinTest() {
		Pawn  pawnCoin = new Pawn("WP", true, whitePlayer);
		whitePlayer.putCoin(pawnCoin);
		assertEquals("putCoin() does not add coin",9,whitePlayer.pawns);
	}
	
	@Test
	public void getScoreTest() {
		assertEquals("getScore() returns false value",39,whitePlayer.getScore());
	}
	
	@Test
	public void kingPositionTest() throws ChessException {
		whitePlayer.setKingPosition(new Position("B2"));
		assertEquals("kingPoistion is not set properly",1,whitePlayer.getXKingPosition());
	}
	
}
