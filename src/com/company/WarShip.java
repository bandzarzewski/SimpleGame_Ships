package com.company;

import java.util.PrimitiveIterator;

public abstract class WarShip implements Ship {

    enum Orientation {
        HORIZONTAL, VERTICAL
    }

    private Orientation orientation;
    private int hits;
    private Field[] occupied;

    public WarShip() {
        occupied = new Field[getDecksCount()];
    }

    public void setOnField(Field field, int decNo) {
        field.setShip(this);
        field.setState(State.SHIP);
        occupied[decNo] = field;
    }


    @Override
    public boolean isSunk() {
        return hits == getDecksCount();
    }

    @Override
    public void hit() {
        hits++;
        if (isSunk()) {
            for (int i = 0; i < occupied.length; i++) {
                occupied[i].setState(State.SUNK);
            }
        }

    }

}

class Submarine extends WarShip {

    @Override
    public int getDecksCount() {
        return 1;
    }
}

class Destoyer extends WarShip {

    @Override
    public int getDecksCount() {
        return 2;
    }
}

class Cruiser extends WarShip {

    @Override
    public int getDecksCount() {
        return 3;
    }
}

class Battleship extends WarShip {

    @Override
    public int getDecksCount() {
        return 4;
    }
}