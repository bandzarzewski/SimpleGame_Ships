package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void shouldAddSubmarine() throws Exception {
        Board board = new Board();
        boolean result = board.addShip(0,0,new Submarine());
        assertTrue(result);
    }

    @Test
    public void shouldFailToAddOutsideX() throws Exception{
        Board board = new Board();
        boolean result = board.addShip(-1,0,new Submarine());
        assertFalse(result);
    }

    @Test
    public void shouldFailToAddOutsideY() throws Exception{
        Board board = new Board();
        boolean result = board.addShip(0,9,new Submarine());
        assertTrue(result);
    }
}