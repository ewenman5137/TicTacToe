package com.example.tictactoe;

public class Bot {
    private String name;
    private boolean round;
    public Bot(String name, boolean round) {
        this.name=name;
        this.round=round;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
    public boolean getRound(){
        return round;
    }
}
