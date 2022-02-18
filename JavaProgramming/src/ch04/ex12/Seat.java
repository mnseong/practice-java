package ch04.ex12;

import java.util.Scanner;

class Seat {
    private char seatType;
    private String name = "---";
    private int seatNum;
    
    public Seat(char seatType, int seatNum) {
        this.seatType = seatType;
        this.seatNum = seatNum;
    }
    
    void setName(String name) {
        this.name = name;
    }
    
    char getSeatType() {
        return seatType;
    }
    
    String getName() {
        return name;
    }
}