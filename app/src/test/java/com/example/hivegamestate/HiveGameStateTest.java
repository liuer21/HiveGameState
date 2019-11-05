package com.example.hivegamestate;

import org.junit.Test;
import static org.junit.Assert.*;

public class HiveGameStateTest {

    @Test
    public void toString1() {

    }

    @Test
    public void placePiece() {
        HiveGameState hgs = new HiveGameState();
        HiveGameState.piece test = hgs.bugList.get(0);
        hgs.placePiece(0, test, 5, 5);
        assertEquals(test, hgs.getBoard()[5][5]);
    }

    @Test
    public void movePiece() {
        HiveGameState hgs = new HiveGameState();
        HiveGameState.piece test = hgs.bugList.get(0);
        hgs.getBoard()[6][6] = test;
        hgs.movePiece(0, test, 6, 6, 7, 7);
        assertEquals(test, hgs.getBoard()[7][7]);
    }

    @Test
    public void undo() {
    }

    @Test
    public void quit() {  // May not be in final game
        HiveGameState hgs = new HiveGameState();
        int test = hgs.getTurn();
        boolean quitTest = hgs.quit(test);
        assertTrue(quitTest);
    }

    @Test
    public void zoom() { // May not be in final game
        HiveGameState hgs = new HiveGameState();
        int test = hgs.getTurn();
        boolean zoomTest = hgs.quit(test);
        assertTrue(zoomTest);
    }

    @Test
    public void getTurn() {
        HiveGameState hgs = new HiveGameState();
        int test = hgs.getTurn();
        assertEquals(test, 1); // Starting value is 1
    }

    @Test
    public void setTurn() {
        HiveGameState hgs = new HiveGameState();
        int newTurn = 0;
        hgs.setTurn(newTurn);
        assertEquals(newTurn, 0);
    }
}