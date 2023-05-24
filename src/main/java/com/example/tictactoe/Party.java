package com.example.tictactoe;

public class Party{
    private final Player player1;
    private final Player player2;
    private int scorePlayer1;
    private int scorePlayer2;
    public Party(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.scorePlayer1 = player1.getScore();
        this.scorePlayer2 = player2.getScore();
    }

    // Autres méthodes et variables
    public void tour(){
        System.out.println("etat player 1 : "+player1.getRound());
        player1.setRound(player2.getRound());
        player2.setRound(!player1.getRound());
        System.out.println("etat après player 1 : "+player1.getRound());
    }

    public Player getPlayer1() {
        return player1;
    }
    public Player getPlayer2() {
        return player2;
    }


    public int getScorePlayer1() {
        return scorePlayer1;
    }
    public int getScorePlayer2() {
        return scorePlayer2;
    }

    public void player1Win() {
        scorePlayer1++;
    }

    public void player2Win() {
        scorePlayer2++;
    }

    @Override
    public String toString() {
        return "This party content : \n"+player1+"\n"+player2;
    }
}