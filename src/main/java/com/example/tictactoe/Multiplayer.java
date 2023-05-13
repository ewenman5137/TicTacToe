package com.example.tictactoe;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Multiplayer {
    Player APlayer1 = new Player("Player 1",true);

    Player APlayer2 = new Player("Player 2",false);
    String whoStart="Random";

    @FXML
    void enterInCustomMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GridMatch.fxml"));
        Parent root = loader.load();

        // Obtenir le contrôleur de la page de jeu
        GridMatch gridMatch = loader.getController();
        Party party = new Party(APlayer1, APlayer2);
        switch (whoStart){
            case("Random"):
                Random rand = new Random();
                int whoStart = rand.nextInt(100);
                System.out.println(whoStart);
                if(whoStart%2==0) {
                    APlayer1.setRound(false);
                    APlayer2.setRound(true);
                }else{
                    APlayer1.setRound(true);
                    APlayer2.setRound(false);
                }
                break;
            case("Player 1"):
                APlayer1.setRound(true);
                APlayer2.setRound(false);
                break;
            case("Player 2"):
                APlayer1.setRound(false);
                APlayer2.setRound(true);
                break;
        }
        gridMatch.setParty(party);

        // Créer une nouvelle scène avec la page de jeu
        Scene scene = new Scene(root);

        // Obtenir la fenêtre actuelle et définir la scène
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Page de Jeu");
        stage.setWidth(700);
        stage.setHeight(900);
        stage.setScene(scene);
    }

    @FXML
    private Label labelPlayer1;

    @FXML
    private Label labelPlayer2;

    @FXML
    private Button boutonPrincipaleEntrer;

    @FXML
    private Button buttonCreationPlayer1;

    @FXML
    private Button buttonRandom;

    @FXML
    private Button buttonPlayer1;

    @FXML
    private Button buttonPlayer2;

    @FXML
    private TextField textFieldNamePlayer1;

    @FXML
    private TextField textFieldNamePlayer2;


    @FXML
    void createPlayer1(ActionEvent event) {
        labelPlayer1.setText(textFieldNamePlayer1.getText());
        APlayer1.setName(textFieldNamePlayer1.getText());

    }
    @FXML
    void createPlayer2(ActionEvent event) {
        labelPlayer2.setText(textFieldNamePlayer2.getText());
        APlayer2.setName(textFieldNamePlayer2.getText());
    }



    @FXML
    void whoIsRandom(ActionEvent event) {
        buttonRandom.setDisable(true);
        buttonPlayer1.setDisable(false);
        buttonPlayer2.setDisable(false);
        whoStart="Random";
    }
    @FXML
    void whoIsPlayer1(ActionEvent event) {
        buttonRandom.setDisable(false);
        buttonPlayer1.setDisable(true);
        buttonPlayer2.setDisable(false);
        whoStart="Player 1";
    }
    @FXML
    void whoIsPlayer2(ActionEvent event) {
        buttonRandom.setDisable(false);
        buttonPlayer1.setDisable(false);
        buttonPlayer2.setDisable(true);
        whoStart="Player 2";
    }
}
