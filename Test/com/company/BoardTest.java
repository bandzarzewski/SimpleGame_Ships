package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    Board board = new Board();

    @Test
    public void shouldAddSubmarine() throws Exception {
        board.addShip(0,0,new Submarine());
        assertEquals(1,board.getShipsCount());
    }

    //assert
    @Test(expected = IllegalMoveException.class)
    public void shouldFailToAddOutsideX() throws Exception{
//        try {
            board.addShip(-1, 0, new Submarine());
//            fail(); // assertFalse(result);
//        } catch (IllegalMoveException ex){}

    }

    @Test(expected = IllegalMoveException.class)
    public void shouldFailToAddOutsideY() throws Exception{
        board.addShip(0,9,new Submarine());
    }
}