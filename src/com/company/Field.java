package com.company;

public class Field {

    private State state;
    private final int x;
    private final int y;
    private Ship ship;

    public Field(int x, int y,State state) {
        this.state = state;
        this.x = x;
        this.y = y;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public void setState(State state) {
        this.state = state;
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

    public State getState() {
        return state;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Ship getShip() {
        return ship;
    }
}
