package com.company;

public class Board {
    private Field[][] fields = new Field[10][10];

    public Board() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                fields[y][x] = new Field(x, y, State.EMPTY);
            }
        }
    }

    public void fillBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                fields[i][j].setState(getRandomShip(Math.random()));
            }
        }
    }

    private static State getRandomShip(double random) {
        if (Math.random() < 0.2) {
            return State.HIT;
        } else {
            return State.MISS;
        }
    }

    private static void printLetters() {
        System.out.print("  ");
        for (int i = 0; i < 10; i++) {
            System.out.print((char) ('A' + i));
        }
        System.out.print('\n');
    }

    public void printBoard() {
        printLetters();
        for (int i = 0; i < 10; i++) {
            int numberToPrint = i + 1;
            if (numberToPrint < 10) {
                System.out.print(' ');
            }
            System.out.print(numberToPrint);
            for (int j = 0; j < 10; j++) {
                char shipValue = fields[i][j].stateToChar();
                System.out.print(shipValue);
            }
            System.out.print('\n');
        }
    }


    public boolean addShip(int x, int y, Submarine submarine) {
        if (x < 0 || x >= 10 || y < 0 || y >= 10) {
            return false;
        }
        return true;
    }
}
