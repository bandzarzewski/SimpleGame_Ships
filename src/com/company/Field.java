package com.company;

public class Field {

    private State state;
    private final int x;
    private final int y;

    public Field(State state, int x, int y) {
        this.state = state;
        this.x = x;
        this.y = y;
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
