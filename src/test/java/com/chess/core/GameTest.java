package com.chess.core;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.chess.util.ChessException;
 
public class GameTest {
	private static Game game;
	private static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private static PrintStream originalOut = System.out;

    @BeforeClass
    public static void setup() throws ChessException{
    	game = new Game();
    	System.setOut(new PrintStream(outContent));
    }
 
    @Before
    public void setupThis() {
    	outContent.reset();
    }
 
    @Test
    public void initialBoardPositionTest() throws FileNotFoundException, IOException{
        game.board.displayBoard();
    	
        String initialBoardPositionTxtLocation = "target/test-classes/initial-board-position.txt";

        InputStream inputStream = new FileInputStream(new File(initialBoardPositionTxtLocation));
        StringWriter writer = new StringWriter();
        
        IOUtils.copy(inputStream, writer);  
        
        String originalValue = outContent.toString();
        String expectedValue = writer.toString();
        
        Assert.assertEquals("Initial board position is not proper", expectedValue,originalValue);
        
    }
    
    @Test(expected = ChessException.class)
    public void invalidColMove() throws ChessException {
    	String fromPos = "G1";
    	String toPos = "H4";
    	game.move(fromPos, toPos);
    }
    
    @Test(expected = ChessException.class)
    public void invalidRowMove() throws ChessException {
    	String fromPos = "A9";
    	String toPos = "B9";
    	game.move(fromPos, toPos);
    }
    
    @Test(expected = ChessException.class)
    public void NoCoinMove() throws ChessException {
    	String fromPos = "A3";
    	String toPos = "A4";
    	game.move(fromPos, toPos);
    }
 
    @After
    public void tearThis() {
    }
 
    @AfterClass
    public static void tear() {
    }
}