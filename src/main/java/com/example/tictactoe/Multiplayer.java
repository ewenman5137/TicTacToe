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
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Multiplayer {
    Player APlayer1 = new Player("Player 1",true);

    Player APlayer2 = new Player("Player 2",false);
    String whoStart="Random";
    @FXML
    private Button buttonStartGame;
    @FXML
    private Button buttonHome;

    @FXML
    void returnToHome(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("Home.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Home");
        stage.setScene(scene);

    }

    @FXML
    void enterInCustomMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GridMatch.fxml"));
        Parent root = loader.load();
        loadCustomMenuScene(event);
    }



    private void determineStartingPlayer() {
        switch (whoStart) {
            case "Random":
                Random rand = new Random();
                if (rand.nextInt(100) % 2 == 0) {
                    setPlayerRounds(APlayer1, false, APlayer2, true);
                } else {
                    setPlayerRounds(APlayer1, true, APlayer2, false);
                }
                break;

            case "Player 1":
                setPlayerRounds(APlayer1, true, APlayer2, false);
            break;
            case "Player 2":
                setPlayerRounds(APlayer1, false, APlayer2, true);
            break;
        }
    }

    private void setPlayerRounds(Player player1, boolean player1Round, Player player2, boolean player2Round) {
        player1.setRound(player1Round);
        player2.setRound(player2Round);
    }

    private void loadCustomMenuScene(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("Custom.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL); // rendre la fenêtre modale
        stage.setTitle("Menu Custom");
        stage.setWidth(700);
        stage.setHeight(900);
        stage.setScene(scene);
        stage.showAndWait(); // affiche cette fenêtre et attend qu'elle soit fermée
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
    @FXML
    void enterInGridMatch(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GridMatch.fxml"));
        Parent root = loader.load();

        determineStartingPlayer();

        // Get the controller from the FXMLLoader
        GridMatch gridMatch = loader.getController();
        gridMatch.StartParty(APlayer1,APlayer2);


        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("GridMatch.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("GridMatch");
        stage.setScene(scene);
    }
}
