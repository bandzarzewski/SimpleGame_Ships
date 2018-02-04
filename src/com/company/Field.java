package com.company;

import java.lang.ref.PhantomReference;

public class Field {

    private State state;
    private final int x;
    private final int y;
    private Ship ship;

    public Field(State state, int x, int y) {
        this.state = state;
        this.x = x;
        this.y = y;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public char stateToChar() {
        char value;
        switch (state) {
            case EMPTY:
                value = ' ';
                break;
            case HIT:
                value = 'O';
                break;
            default:
                value = '*';
        }
        return value;
    }

    public void setState(State state) {
        this.state = state;
    }
}
