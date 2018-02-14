package com.company;

public abstract class WarShip implements Ship {

    enum Orientation {
        HORIZONTAL, VERTICAL
    }

    private Orientation orientation;
    private int hits;
    private Field[] occupied;


    public WarShip(Orientation orientation) {
        this.orientation = orientation;
        occupied = new Field[getDecksCount()];
    }

    public void setOnField(Field field, int decNo) {
        field.setShip(this);
        field.setState(State.SHIP);
        occupied[decNo] = field;
    }

    public Orientation getOrientation() {
        return orientation;
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


    public Submarine() {
        super(Orientation.HORIZONTAL);
    }

    @Override
    public int getDecksCount() {
        return 1;
    }
}

class Destoyer extends WarShip {

    public Destoyer(Orientation orientation) {
        super(orientation);
    }

    @Override
    public int getDecksCount() {
        return 2;
    }
}

class Cruiser extends WarShip {

    public Cruiser(Orientation orientation) {
        super(orientation);
    }

    @Override
    public int getDecksCount() {
        return 3;
    }
}

class Battleship extends WarShip {

    public Battleship(Orientation orientation) {
        super(orientation);
    }

    @Override
    public int getDecksCount() {
        return 4;
    }
}