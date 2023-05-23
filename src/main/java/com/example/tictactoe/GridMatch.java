package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;


public class GridMatch{
    @FXML
    private Pane backgroundPPPlayer1;

    @FXML
    private Pane backgroundPPPlayer2;

    @FXML
    private Button buttonExit;

    @FXML
    private Button button0;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button buttonBackToHome;

    @FXML
    private Button buttonRestart;

    @FXML
    private Label namePlayer1;

    @FXML
    private Label namePlayer2;

    @FXML
    private ImageView ppPlayer1;

    @FXML
    private ImageView ppPlayer2;

    @FXML
    private Label scorePlayer1;

    @FXML
    private Label scorePlayer2;

    @FXML
    private Label roundAndEndMatch;
    private int x=0;
    Image croixToExitPageLiens = new Image("fermer-la-croix.png");
    ImageView croixToExitPage = new ImageView(croixToExitPageLiens);
    private static Party party;

    @FXML
    void returnToHome(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("Home.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Home");
        stage.setScene(scene);

    }

    public void StartParty(Player player1, Player player2){
        party =new Party(player1,player2);
        setParty(party);
    }
    public void setParty(Party party){
        namePlayer1.setText(party.getNamePlayer1());
        namePlayer2.setText(party.getNamePlayer2());
        scorePlayer1.setText(""+ party.getScorePlayer1());
        scorePlayer2.setText(""+ party.getScorePlayer2());
        croixToExitPage.setFitHeight(25);
        croixToExitPage.setFitWidth(25);
        if(party.getRoundPlayer1()){
            backgroundPPPlayer1.setStyle("-fx-border-color: blue");
            backgroundPPPlayer2.setStyle("-fx-border-color: black");
            roundAndEndMatch.setText("it's the turn of "+party.getNamePlayer1());
        }
        else{
            backgroundPPPlayer1.setStyle("-fx-border-color: black");
            backgroundPPPlayer2.setStyle("-fx-border-color: Blue");
            roundAndEndMatch.setText("it's the turn of "+party.getNamePlayer2());
        }
    }

    @FXML
    void onClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        if (clickedButton.getText().equals("")) {
            System.out.println(party.getRoundPlayer1());
            if(x<=9){
                if (party.getRoundPlayer1()) {
                    addXOnButton(clickedButton);
                    if(verifieEtatGrille()){
                        giveButtonWin();
                    }
                    if(party.getBot()&&!verifieEtatGrille()){
                        moveOfBot();
                        if(verifieEtatGrille()){
                            giveButtonWin();
                        }
                    }
                }else{
                    addOOnButton(clickedButton);
                    if(verifieEtatGrille()){
                        giveButtonWin();
                    }
                }
                x++;
            }
            else{
                if(verifieEtatGrille()){
                    partyNull();
                }
            }


        }
    }
public void moveOfBot(){
        if(party.getRoundPlayer2()){
            if(party.getNamePlayer2().equals("Jean")){
                moveOfEasy();
            }else{
                moveOfExpert();
            }
        }
}
    public void moveOfEasy(){
        if(party.getRoundPlayer2()){
            Button[] listNameButton = {button0, button1, button2, button3, button4, button5, button6, button7, button8};
            for (int i = 0; i < 9; i++) {
                if(listNameButton[i].getText()==""){
                    System.out.println(listNameButton[i]);
                    addOOnButton(listNameButton[i]);
                    break;
                }
            }
        }

    }
    public void moveOfExpert(){

    }
    public void addXOnButton(Button button){
        backgroundPPPlayer1.setStyle("-fx-border-color: black");
        backgroundPPPlayer2.setStyle("-fx-border-color: Blue");
        button.setText("X");
        ImageView croix = new ImageView(new Image("fermer-la-croix.png"));
        croix.setFitHeight(60);
        croix.setFitWidth(60);
        button.setGraphic(croix);
        button.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        roundAndEndMatch.setText("it's the turn of "+party.getNamePlayer1());
        party.tour();
    }
    public void addOOnButton(Button button){
        backgroundPPPlayer1.setStyle("-fx-border-color: Blue");
        backgroundPPPlayer2.setStyle("-fx-border-color: Black");
        ImageView circle = new ImageView(new Image("vide.png"));
        circle.setFitHeight(60);
        circle.setFitWidth(60);
        button.setGraphic(circle);
        button.setText("O");
        button.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        roundAndEndMatch.setText("it's the turn of "+party.getNamePlayer2());
        party.tour();
    }

    public void partyNull(){
        Button[] listNameButton = {button0, button1, button2, button3, button4, button5, button6, button7, button8};
        for (int i = 0; i < 9; i++) {
            if(listNameButton[i].getText()!=""){
                listNameButton[i].setDisable(true);
            }
        }
        roundAndEndMatch.setText("it's a match null");
    }
        public void endOfMatch(String whoIsWin, Button bouton_1, Button bouton_2, Button bouton_3){
            Button[] listNameButton = {button0, button1, button2, button3, button4, button5, button6, button7, button8};
                bouton_1.setStyle("-fx-background-color: green;");
                bouton_2.setStyle("-fx-background-color: green;");
                bouton_3.setStyle("-fx-background-color: green;");
                switch (whoIsWin) {
                    case "X":
                        party.player1Win();
                        setParty(party);
                        for (int i = 0; i < 9; i++) {
                            if(listNameButton[i].getText()==""){
                                listNameButton[i].setDisable(true);
                            }
                        }
                        roundAndEndMatch.setText("Felicitation "+party.getNamePlayer1());
                        break;
                    case "O":
                        party.player2Win();
                        setParty(party);
                        for (int i = 0; i < 9; i++) {
                            if(listNameButton[i].getText()==""){
                                listNameButton[i].setDisable(true);
                            }
                        }
                        roundAndEndMatch.setText("Felicitation "+party.getNamePlayer2());
                        break;
                    default:
                        break;
                }

            }

    private boolean verifieEtatGrille() {
        int[][] winConditions = new int[][] {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // lignes
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // colonnes
                {0, 4, 8}, {2, 4, 6}              // diagonales
        };
        Button[] listNameButton = {button0, button1, button2, button3, button4, button5, button6, button7, button8};
        for (int i=0;i<winConditions.length;i++) {
            if (listNameButton[winConditions[i][0]].getText().equals(listNameButton[winConditions[i][1]].getText()) && listNameButton[winConditions[i][0]].getText().equals(listNameButton[winConditions[i][2]].getText()) && !listNameButton[winConditions[i][2]].getText().equals("")) {
                return true;
            }
        }
        return false;
    }

    private boolean giveButtonWin() {
        int[][] winConditions = new int[][] {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // lignes
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // colonnes
                {0, 4, 8}, {2, 4, 6}              // diagonales
        };
        Button[] listNameButton = {button0, button1, button2, button3, button4, button5, button6, button7, button8};
        for (int i=0;i<winConditions.length;i++) {
            if (listNameButton[winConditions[i][0]].getText().equals(listNameButton[winConditions[i][1]].getText()) && listNameButton[winConditions[i][0]].getText().equals(listNameButton[winConditions[i][2]].getText()) && !listNameButton[winConditions[i][2]].getText().equals("")) {
                endOfMatch(listNameButton[winConditions[i][0]].getText(), listNameButton[winConditions[i][0]], listNameButton[winConditions[i][1]], listNameButton[winConditions[i][2]]);
            }
        }
        return false;
    }

    @FXML
    void restartTheGrid(ActionEvent event) {
        x=0;
        Button[] listNameButton = {button0, button1, button2, button3, button4, button5, button6, button7, button8};
        for (int i = 0; i < 9; i++) {
            listNameButton[i].setText("");
            listNameButton[i].setGraphic(null);
            listNameButton[i].setStyle("-fx-border-color: black");
            listNameButton[i].setDisable(false);
            listNameButton[i].setStyle("-fx-background-color: red");
        }
        setParty(party);
        buttonRestart.setText("Reset");
        moveOfBot();
    }

}