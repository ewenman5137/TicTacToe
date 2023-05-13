package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;


public class GridMatch {
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
    private int x=0;
    Image croixToExitPageLiens = new Image("file:E:\\test_projet\\TicTacToe\\src\\main\\java\\com\\example\\tictactoe\\fermer-la-croix.png");
    ImageView croixToExitPage = new ImageView(croixToExitPageLiens);

    private Party party;

    public void setParty(Party party) {
        this.party = party;
        namePlayer1.setText(party.getNamePlayer1());
        namePlayer2.setText(party.getNamePlayer2());
        scorePlayer1.setText(""+ party.getScorePlayer1());
        scorePlayer2.setText(""+ party.getScorePlayer2());
        croixToExitPage.setFitHeight(25);
        croixToExitPage.setFitWidth(25);
        if(party.getRoundPlayer1()){
            backgroundPPPlayer1.setStyle("-fx-border-color: Blue");
            backgroundPPPlayer2.setStyle("-fx-border-color: black");
        }
        else{
            backgroundPPPlayer1.setStyle("-fx-border-color: black");
            backgroundPPPlayer2.setStyle("-fx-border-color: Blue");
        }

    }

    @FXML
    void onClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        if (clickedButton.getText().equals("")) {
            if (party.getRoundPlayer1()) {
                party.tour();
                backgroundPPPlayer2.setStyle("-fx-border-color: Blue");
                backgroundPPPlayer1.setStyle("-fx-border-color: black");
                clickedButton.setText("X");
                Image croixLien = new Image("file:E:\\test_projet\\TicTacToe\\src\\main\\java\\com\\example\\tictactoe\\signe-de-la-croix.png");
                ImageView croix = new ImageView(croixLien);
                croix.setFitHeight(60);
                croix.setFitWidth(60);
                clickedButton.setGraphic(croix);
                clickedButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                //annoceLeTour.setText("C'est au tour de : " + partie.getNameJoueur1());
            } else if (x>=9) {
                System.out.println("fin de partie");
                x=0;

            } else {
                party.tour();
                backgroundPPPlayer2.setStyle("-fx-border-color: black");
                backgroundPPPlayer1.setStyle("-fx-border-color: Blue");
                Image circleLiens = new Image("file:E:\\test_projet\\TicTacToe\\src\\main\\java\\com\\example\\tictactoe\\cercle.png");
                ImageView circle = new ImageView(circleLiens);
                circle.setFitHeight(60);
                circle.setFitWidth(60);
                clickedButton.setGraphic(circle);
                clickedButton.setText("O");
                clickedButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                //annoceLeTour.setText("C'est au tour de : " + partie.getNameJoueur2());
            }
            verifieEtatGrille();
            x++;
        }
    }
    public void partyNull(){
        Button[] listNameButton = {button0, button1, button2, button3, button4, button5, button6, button7, button8};
        for (int i = 0; i < 9; i++) {
            if(listNameButton[i].getText()==""){
                listNameButton[i].setDisable(true);
            }
        }
    }
        public void endOfMatch(String whoIsWin, Button bouton_1, Button bouton_2, Button bouton_3){
            System.out.println("Le bouton qui a gagner est : "+whoIsWin);
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
                        break;
                    case "O":
                        party.player2Win();
                        setParty(party);
                        for (int i = 0; i < 9; i++) {
                            if(listNameButton[i].getText()==""){
                                listNameButton[i].setDisable(true);
                            }
                        }
                        break;
                    default:
                        break;
                }

            }


    private void verifieEtatGrille() {
        if (button0.getText().equals(button1.getText()) && button1.getText().equals(button2.getText()) && !(button0.getText().equals(""))&&!(button0.getText().equals("Fin"))){
            endOfMatch(""+ button0.getText(), button0, button1, button2);
        }
        if (button3.getText().equals(button4.getText()) && (button4.getText().equals(button5.getText()) && !(button3.getText().equals(""))&&!(button0.getText().equals("Fin")))) {
            endOfMatch(""+ button3.getText(), button3, button4, button5);
        }
        if (button6.getText().equals(button7.getText()) && (button7.getText().equals(button8.getText()) && !(button6.getText().equals(""))&&!(button0.getText().equals("Fin")))) {
            endOfMatch(""+ button6.getText(), button6, button7, button8);
        }
        if (button0.getText().equals(button3.getText()) && (button3.getText().equals(button6.getText()) && !(button0.getText().equals(""))&&!(button0.getText().equals("Fin")))) {
            endOfMatch(""+ button0.getText(), button3, button6, button0);
        }
        if (button1.getText().equals(button4.getText()) && (button4.getText().equals(button7.getText()) && !(button1.getText().equals(""))&&!(button0.getText().equals("Fin")))) {
            endOfMatch(""+ button1.getText(), button4, button1, button7);
        }
        if (button2.getText().equals(button5.getText()) && (button5.getText().equals(button8.getText()) && !(button2.getText().equals(""))&&!(button0.getText().equals("Fin")))) {
            endOfMatch(""+ button2.getText(), button2, button5, button8);
        }
        if (button0.getText().equals(button4.getText()) && (button4.getText().equals(button8.getText()) && !(button0.getText().equals(""))&&!(button0.getText().equals("Fin")))) {
            endOfMatch(""+ button0.getText(), button0, button4, button8);
        }
        if (button2.getText().equals(button4.getText()) && (button4.getText().equals(button6.getText()) && !(button2.getText().equals(""))&&!(button0.getText().equals("Fin")))) {
            endOfMatch(""+ button2.getText(), button2, button4, button6);
        }
    }

    //=============================



    @FXML
    void backToHome(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("Home.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Home");
        stage.setScene(scene);
    }

    @FXML
    void exitTheMatch(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("Multiplayer.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Multiplayer");
        stage.setScene(scene);
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
    }

}