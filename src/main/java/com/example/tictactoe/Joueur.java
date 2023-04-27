package com.example.tictactoe;

public class Joueur {
    private String name;
    private int score;
    public Joueur(String name){
        this.name =name;
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

    @Override
    public String toString() {
        return "Salut, Je suis "+name+" et mon score est de : "+score;
    }

}
