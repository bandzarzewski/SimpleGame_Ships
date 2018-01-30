package com.company;

public class Main {

    public static void main(String[] args) {
        char[][] board = new char[10][10];
        fillBoard(board);
        printLetters(board);
        printBoard(board);

    }

    private static void fillBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = getRandomShip(Math.random());
            }
        }
    }

    static void printBoard(char[][] board) {
        for (int i = 0; i < 10; i++) {
            int numberToPrint = i + 1;
            if (numberToPrint < 10) {
                System.out.print(' ');
            }
            System.out.print(numberToPrint);
            for (int j = 0; j < 10; j++) {
                char shipValue = board[i][j];
                System.out.print(shipValue);
            }
            System.out.print('\n');
        }
    }

    static void printLetters(char[][] board) {
        System.out.print("   ");
        for (int i = 0; i < 10; i++) {
            System.out.print((char) ('A' + i));
        }
        System.out.print('\n');
    }

    private static char getRandomShip(double random) {
        if (Math.random() < 0.2) {
            return 'O';
        } else {
            return ' ';
        }
    }
}
