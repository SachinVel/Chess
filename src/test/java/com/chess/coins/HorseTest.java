package com.chess.coins;

import static org.junit.Assert.assertEquals;

import javax.xml.bind.helpers.ParseConversionEventImpl;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.chess.core.Board;
import com.chess.core.Player;
import com.chess.util.ChessException;
import com.chess.util.Parameters;
import com.chess.util.Position;

public class HorseTest {
	private static Horse horse;
	private static Position fromPos, toPos;
	
	@BeforeClass
	public static void globalSetup() throws ChessException{
		Player whitePlayer = new Player(Parameters.WHITEFLAG,new Position( Parameters.WHITE_KING_POSITION));
		horse = new Horse("WH", whitePlayer);
	}
	
	@Test
	public void isValidTest() throws ChessException{
		Board board = Mockito.mock(Board.class);
		
		Mockito.when(board.isNull(Mockito.any(Position.class))).thenReturn(true);
		
		fromPos = new Position("A1");
		toPos = new Position("B3");
		
		assertEquals("horse move disabled on null destination", true, horse.isValid(fromPos, toPos, board));
		
		Mockito.when(board.isNull(Mockito.any(Position.class))).thenReturn(false);
		Mockito.when(board.isOpponent(Mockito.any(Position.class), Mockito.any(Player.class))).thenReturn(false);
		
		assertEquals("horse move allowed on same coin destination", false, horse.isValid(fromPos, toPos, board));
		
		Mockito.when(board.isOpponent(Mockito.any(Position.class), Mockito.any(Player.class))).thenReturn(true);
		
		assertEquals("horse move disabled on opponent coin destination", true, horse.isValid(fromPos, toPos, board));
		
	}
}
