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

public class PawnTest {
	private static Pawn whitePawn,blackPawn;
	@BeforeClass
	public static void globalSetup() throws ChessException{
		Player whitePlayer = new Player(Parameters.WHITEFLAG,new Position(Parameters.WHITE_KING_POSITION));
		Player blackPlayer = new Player(Parameters.BLACKFLAG,new Position(Parameters.WHITE_KING_POSITION));
		whitePawn = new Pawn("WP", Parameters.FIRSTMOVE, whitePlayer);
		blackPawn = new Pawn("BP", Parameters.FIRSTMOVE, blackPlayer);
	}
	
	@Test
	public void whitePawnMovementTest() throws ChessException{
		Board board = Mockito.mock(Board.class);
		Mockito.when(board.isNull(Mockito.anyInt(),Mockito.anyInt())).thenReturn(true);
		
		Position fromPos = new Position("A2");
		Position toPos = new Position("A4");
		
		assertEquals("white pawn first move is improper",true, whitePawn.isValid(fromPos, toPos, board));
		
		assertEquals("white pawn double jump not disabled after first move", false, whitePawn.isValid(fromPos, toPos, board));
		
		fromPos = new Position("A2");
		toPos = new Position("A3");
		
		assertEquals("white pawn normal move is improper",true, whitePawn.isValid(fromPos, toPos, board));
		
		fromPos = new Position("A2");
		toPos = new Position("B3");
		
		assertEquals("white pawn cross move allowed on no opponent coin", false, whitePawn.isValid(fromPos, toPos, board));
		
		Mockito.when(board.isNull(Mockito.anyInt(),Mockito.anyInt())).thenReturn(false);
		
		Mockito.when(board.isOpponent(Mockito.any(Position.class), Mockito.any(Player.class))).thenReturn(true);
		
		assertEquals("white pawn cross move is disabled on oppenent coin", true, whitePawn.isValid(fromPos, toPos, board));
		
	}
	
	@Test
	public void blackPawnMovementTest() throws ChessException{
		Board board = Mockito.mock(Board.class);
		Mockito.when(board.isNull(Mockito.anyInt(),Mockito.anyInt())).thenReturn(true);
		
		Position fromPos = new Position("A7");
		Position toPos = new Position("A5");
		
		assertEquals("black pawn first move is improper",true, blackPawn.isValid(fromPos, toPos, board));
		assertEquals("black pawn double jump not disabled after first move", false, blackPawn.isValid(fromPos, toPos, board));
		
		fromPos = new Position("A7");
		toPos = new Position("A6");
		
		assertEquals("black pawn normal move is improper",true, blackPawn.isValid(fromPos, toPos, board));
		
		fromPos = new Position("A7");
		toPos = new Position("B6");
		
		assertEquals("black pawn cross move allowed on no opponent coin", false, blackPawn.isValid(fromPos, toPos, board));
		
		Mockito.when(board.isNull(Mockito.anyInt(),Mockito.anyInt())).thenReturn(false);
		Mockito.when(board.isOpponent(Mockito.any(Position.class), Mockito.any(Player.class))).thenReturn(true);
		
		assertEquals("black pawn cross move is disabled on oppenent coin", true, blackPawn.isValid(fromPos, toPos, board));
		
	}
	
}
