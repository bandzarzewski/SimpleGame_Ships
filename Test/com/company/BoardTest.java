package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board();
    }

    @Test
    public void shouldAddSubmarine() throws Exception {
        board.addShip(0, 0, new Submarine());
        assertEquals(1, board.getShipsCount());
    }

    @Test
    public void shouldAddSubmarineOnField () throws Exception {
        board.addShip(0, 0, new Submarine());
        Field field = board.getField(0, 0);
        assertEquals(State.SHIP, field.getState());
    }

    //assert
    @Test(expected = IllegalMoveException.class)
    public void shouldFailToAddOutsideX() throws Exception {
//        try {
        board.addShip(-1, 0, new Submarine());
//            fail(); // assertFalse(result);
//        } catch (IllegalMoveException ex){}

    }

    @Test(expected = IllegalMoveException.class)
    public void shouldNotBeAbleToAddFiveShips() throws Exception {
        board.addShip(1, 1, new Submarine());
        board.addShip(3, 3, new Submarine());
        board.addShip(5, 5, new Submarine());
        board.addShip(7, 7, new Submarine());

        board.addShip(9, 9, new Submarine());
    }

    @Test(expected = IllegalMoveException.class)
    public void shouldNotBeAbleToAddTwoBattleShips() throws Exception {
        board.addShip(0, 0,new Battleship() );
        board.addShip(6, 0,new Battleship() );

    }
}