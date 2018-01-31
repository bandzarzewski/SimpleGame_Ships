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
}
