package com.example.tictactoe;

public class Partie {
    private Joueur joueur1;
    private Joueur joueur2;
    private int scoreJoueur1;
    private int scoreJoueur2;

    public Partie(Joueur joueur1,Joueur joueur2){
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.scoreJoueur1 = joueur1.getScore();
        this.scoreJoueur2 = joueur2.getScore();
    }

    // Autres méthodes et variables

    public int getScoreJoueur1() {
        return scoreJoueur1;
    }
    public int getScoreJoueur2() {
        return scoreJoueur2;
    }

    public void Joueur1Gagne() {
        scoreJoueur1++;
    }

    public void Joueur2Gagne() {
        scoreJoueur2++;
    }
    public String getNameJoueur1(){
        return joueur1.getName();
    }
    public String getNameJoueur2(){
        return joueur2.getName();
    }
}

