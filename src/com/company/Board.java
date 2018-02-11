package com.company;

public class Board {
    public static final int SHIP_COUNT_TYPES = 4;
    private Field[][] fields = new Field[10][10];
    private static final int BOARD_SIZE = 10;
    private int shipsCount;
    private int numberOfShipsByDeck[] = new int[SHIP_COUNT_TYPES];// będziemy zapisywać do tablicy ilość statków na planszy

    public Board() {
        for (int y = 0; y < BOARD_SIZE; y++) {
            for (int x = 0; x < BOARD_SIZE; x++) {
                fields[y][x] = new Field(x, y, State.EMPTY);
            }
        }
    }

    public void fillBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
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
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print((char) ('A' + i));
        }
        System.out.print('\n');
    }

    public void printBoard() {
        printLetters();
        for (int i = 0; i < BOARD_SIZE; i++) {
            int numberToPrint = i + 1;
            if (numberToPrint < BOARD_SIZE) {
                System.out.print(' ');
            }
            System.out.print(numberToPrint);
            for (int j = 0; j < BOARD_SIZE; j++) {
                char shipValue = fields[i][j].stateToChar();
                System.out.print(shipValue);
            }
            System.out.print('\n');
        }
    }


    public void addShip(int x, int y, Ship ship) throws IllegalMoveException {


        if (numberOfShipsByDeck[ship.getDecksCount() - 1] == getTotalCountOfShips(ship.getDecksCount())) {
            throw new IllegalMoveException("you have all submarine set! ");
        }

        if (x < 0 || x >= BOARD_SIZE || y < 0 || y >= BOARD_SIZE) {
            throw new IllegalMoveException("Ship set outside board! ");
        }
        ship.setOnField(fields[y][x], 0);

        shipsCount++;
        numberOfShipsByDeck[ship.getDecksCount() - 1]++; // odejmujemy 1 aby mieć po 0 ele.tab liczbe 1-masztowców

    }

    private int getTotalCountOfShips(int decksCount) {
        return SHIP_COUNT_TYPES - decksCount + 1;
    }

    public int getShipsCount() {
        return shipsCount;
    }

    public Field getField(int x, int y) {
        return fields[y][x];
    }
}
