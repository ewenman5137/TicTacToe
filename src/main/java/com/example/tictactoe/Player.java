package com.example.tictactoe;

public class Player {
    private String name;
    private int score;
    private boolean round;
    private Boolean bot;
    private String image;
    private String signe;
    public Player(String name,Boolean round,String signe){
        this.name =name;
        this.round=round;
        this.signe=signe;
        bot=false;
        image="baleine.png";
        score=0;
    }
    public Player(String name,Boolean round,String signe,Boolean bot){
        this(name,round,signe);
        this.bot =bot;
    }
    public Player(String name,Boolean round,String signe,String image){
        this(name,round,signe);
        this.image =image;
    }
    public String getName() {
        return name;
    }
    public String getImage(){
            return image;
    }

    public String getSigne() {
        return signe;
    }

    public void setSigne(String signe) {
        this.signe = signe;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getBot() {
        return bot;
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
