package com.example.tictactoe;

public class Player {
    private String name;
    private int score;
    private boolean round;
    private Boolean bot;
    public Player(String name,Boolean round){
        this.name =name;
        this.round=round;
        bot=false;
        score=0;
    }
    public Player(String name,Boolean round,Boolean bot){
        this(name,round);
        this.bot =bot;
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
