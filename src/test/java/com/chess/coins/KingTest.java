package com.chess.coins;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.chess.core.Board;
import com.chess.core.Player;
import com.chess.util.ChessException;
import com.chess.util.Parameters;
import com.chess.util.Position;

public class KingTest {
	private static King king;
	private static Position fromPos,toPos;
	
	@BeforeClass
	public static void globalSetup() throws ChessException{
		Player whitePlayer = new Player(Parameters.WHITEFLAG, new Position(Parameters.WHITE_KING_POSITION));
		king = new King("WK", whitePlayer);
	}
	
	@Test
	public void isValidTest() throws ChessException{
		Board board = Mockito.mock(Board.class);
		
		fromPos = new Position("A1");
		toPos = new Position("A2");
		
		Mockito.when(board.isNull(Mockito.any(Position.class))).thenReturn(false);
		Mockito.when(board.isOpponent(Mockito.any(Position.class),Mockito.any(Player.class))).thenReturn(true);
		
		assertEquals("King move disable on oppenent coin destination", true, king.isValid(fromPos, toPos, board));
		
		Mockito.when(board.isNull(Mockito.any(Position.class))).thenReturn(true);
		
		assertEquals("King move disable on no coin destination", true, king.isValid(fromPos, toPos, board));
		
		Mockito.when(board.isOpponent(Mockito.any(Position.class),Mockito.any(Player.class))).thenReturn(false);
		Mockito.when(board.isNull(Mockito.any(Position.class))).thenReturn(false);
		
		assertEquals("King move allowed on same coin destination", false, king.isValid(fromPos, toPos, board));
		
		fromPos = new Position("A1");
		toPos = new Position("A5");
		
		assertEquals("King invalid move allowed", false, king.isValid(fromPos, toPos, board));
		
	}
}
