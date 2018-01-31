package com.company;

public class Main {

    public static void main(String[] args) {
        State[][] board = new State[10][10];
        fillBoard(board);
        printLetters();
        printBoard(board);

    }

    private static void fillBoard(State[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = getRandomShip(Math.random());
            }
        }
    }

    static void printBoard(State[][] board) {
        for (int i = 0; i < 10; i++) {
            int numberToPrint = i + 1;
            if (numberToPrint < 10) {
                System.out.print(' ');
            }
            System.out.print(numberToPrint);
            for (int j = 0; j < 10; j++) {
                char shipValue = stateToChar(board[i][j]);
                System.out.print(shipValue);
            }
            System.out.print('\n');
        }
    }

    private static char stateToChar(State state) {
        char value;
        switch (state) {
            case HIT:
                value = 'O';
                break;
            case EMPTY:
                value = ' ';
                break;
            default:
                value = '*';
        }
        return value;
    }

    static void printLetters() {
        System.out.print("   ");
        for (int i = 0; i < 10; i++) {
            System.out.print((char) ('A' + i));
        }
        System.out.print('\n');
    }

    private static State getRandomShip(double random) {
        if (Math.random() < 0.2) {
            return State.HIT;
        } else {
            return State.MISS;
        }
    }
}
