package com.company;

public interface Ship {

    int getDecksCount();
    void hit();
    boolean isSunk();
    void setOnField(Field field, int decNo);


}
