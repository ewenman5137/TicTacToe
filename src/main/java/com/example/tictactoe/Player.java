package com.example.tictactoe;

public class Player {
    private String name;
    private int score;
    private boolean round;
    public Player(String name,Boolean round){
        this.name =name;
        this.round=round;
        score=0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
    public void addScore(){
        score++;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean getRound(){
        return round;
    }

    public void setRound(boolean round) {
        this.round = round;
    }

    @Override
    public String toString() {
        return "Hello, I'm "+name+" and my score is : "+score+" and "+(round?"It's my tourn":"It's not my tourn");
    }

}
