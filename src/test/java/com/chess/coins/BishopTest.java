package com.chess.coins;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.chess.core.Board;
import com.chess.core.Player;
import com.chess.util.ChessException;
import com.chess.util.Parameters;
import com.chess.util.Position;

public class BishopTest {
	private static Bishop bishop;
	private static Position fromPos, toPos;
	
	@BeforeClass
	public static void globalSetup() throws ChessException{
		Player whitePlayer = new Player(Parameters.WHITEFLAG, new Position("D1"));
		bishop = new Bishop("WB", whitePlayer);
	}
	
	@Test
	public void isValidTest() throws ChessException{
		Board board = Mockito.mock(Board.class);
		Mockito.when(board.isNull(Mockito.anyInt(),Mockito.anyInt())).thenReturn(true);
		fromPos = new Position("C1");
		toPos = new Position("E3");
		
		assertEquals("bishop move disabled when it is correct", true, bishop.isValid(fromPos, toPos, board));
		
		Mockito.when(board.isNull(Mockito.anyInt(),Mockito.anyInt())).thenReturn(false);
		
		assertEquals("bishop move allowed when coin is inbetween", false, bishop.isValid(fromPos, toPos, board));
		
		fromPos = new Position("C1");
		toPos = new Position("E4");
		
		assertEquals("bishop invalid move is allowed", false, bishop.isValid(fromPos, toPos, board));
		
		
	}
}
