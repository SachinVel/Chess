package com.chess.coins;

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

public class RookTest {
	private static Rook rook;
	private static Position fromPos, toPos;
	
	@BeforeClass
	public static void globalSetup() throws ChessException{
		Player whitePlayer = new Player(Parameters.WHITEFLAG, new Position(Parameters.WHITE_KING_POSITION));
		rook = new Rook("WR", whitePlayer);
	}
	
	@Test
	public void isValidTest() throws ChessException{
		Board board = Mockito.mock(Board.class);
		
		Mockito.when(board.isNull(Mockito.anyInt(),Mockito.anyInt())).thenReturn(false);
		
		fromPos = new Position("A1");
		toPos = new Position("A3");
		
		assertEquals("Rook move allowed on coin inbetween", false, rook.isValid(fromPos, toPos, board));
		
		Mockito.when(board.isNull(Mockito.anyInt(),Mockito.anyInt())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				int toColPos = invocation.getArgument(1);
				
				if( toColPos==2)
					return false;
				
				return true;
			}
		});
		
		Mockito.when(board.isOpponent(Mockito.any(Position.class), Mockito.any(Player.class))).thenReturn(true);
		
		assertEquals("Rook move disabled on oppenent coin destination", true, rook.isValid(fromPos, toPos, board));
		
		Mockito.when(board.isOpponent(Mockito.any(Position.class), Mockito.any(Player.class))).thenReturn(false);
		
		assertEquals("Rook move allowed on same coin destination", true, rook.isValid(fromPos, toPos, board));
		
	}
}
