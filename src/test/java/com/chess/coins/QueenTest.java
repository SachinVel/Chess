package com.chess.coins;

import org.junit.BeforeClass;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.chess.core.Board;
import com.chess.core.Player;
import com.chess.util.ChessException;
import com.chess.util.Parameters;
import com.chess.util.Position;


public class QueenTest {
	private static Position fromPos, toPos;
	private static Coin queen;
	@BeforeClass
	public static void globalTestSetup() throws ChessException{
		Player whitePlayer = new Player(Parameters.WHITEFLAG, new Position(Parameters.WHITE_KING_POSITION));
		queen = new Queen("WQ", whitePlayer);
	}
	
	@Test
	public void isValid() throws ChessException{
		Board board = Mockito.mock(Board.class);
		
		fromPos = new Position("A3");
		toPos = new Position("A6");
		
		Mockito.when(board.isNull(Mockito.anyInt(),Mockito.anyInt())).thenReturn(false);
		
		assertEquals("Queen's move allowed on coin inbetween", false, queen.isValid(fromPos, toPos, board));
		
		Mockito.when(board.isNull(Mockito.anyInt(),Mockito.anyInt())).then(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				int rowPos = invocation.getArgument(0);
				System.out.println("col : "+rowPos);
				if( rowPos==5 ) {
					return false;
				}
				return true;
			}
		});
		
		Mockito.when(board.isOpponent(Mockito.any(Position.class), Mockito.any(Player.class))).thenReturn(true);
		
		assertEquals("Queen move disabled on opponent coin destination", true, queen.isValid(fromPos, toPos, board));
		
		Mockito.when(board.isOpponent(Mockito.any(Position.class), Mockito.any(Player.class))).thenReturn(false);
		
		assertEquals("Queen move allowed on same coin destination", false, queen.isValid(fromPos, toPos, board));
		
		Mockito.when(board.isNull(Mockito.anyInt(),Mockito.anyInt())).thenReturn(true);
		
		assertEquals("Queen's plus move disabled", true, queen.isValid(fromPos, toPos, board));
		
		toPos = new Position("D6");
		
		assertEquals("Queen's cross move disabled", true, queen.isValid(fromPos, toPos, board));
		
		fromPos = new Position("A4");
		
		assertEquals("Queen's invalid move allowed", false, queen.isValid(fromPos, toPos, board));
		
	}
}
