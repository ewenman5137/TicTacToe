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

public class SinglePlayer {
    @FXML
    private Button buttonCreationPlayer1;

    @FXML
    private Button buttonEnterInSingleMenuCustom;

    @FXML
    private Button buttonLevelEasy;

    @FXML
    private Button buttonLevelExpert;

    @FXML
    private Button buttonStartGame; // The Button with "Start Game"

    @FXML
    private Label labelPlayer1;

    @FXML
    private TextField textFieldNamePlayer1;

    private String levelOfBot="Easy";

    @FXML
    private Button buttonHome;

    Player APlayer1 = new Player("Player 1",true,"fermer-la-croix.png");
    Player APlayer2 = new Player("Player 2",false,"vide.png",true);

    public void changeImagePlayer(String imagePlayer1, String imagePlayer2){
        APlayer1.setImage(imagePlayer1);
        APlayer2.setImage(imagePlayer2);
    }
    @FXML
    void returnToHome(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("Home.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Home");
        stage.setScene(scene);

    }


    @FXML
    void createPlayer1(ActionEvent event) {
        labelPlayer1.setText(textFieldNamePlayer1.getText());
        APlayer1.setName(textFieldNamePlayer1.getText());
    }

    @FXML
    void enterInCustomMenuSingle(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("CustomSingle.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL); // rendre la fenêtre modale
        stage.setTitle("Menu Custom Single");
        stage.setWidth(700);
        stage.setHeight(900);
        stage.setScene(scene);
        stage.showAndWait(); // affiche cette fenêtre et attend qu'elle soit fermée
    }

    @FXML
    void levelEasy(ActionEvent event) {
        buttonLevelEasy.setDisable(true);
        buttonLevelExpert.setDisable(false);
        levelOfBot="Easy";
    }

    @FXML
    void levelExpert(ActionEvent event) {
        buttonLevelEasy.setDisable(false);
        buttonLevelExpert.setDisable(true);
        levelOfBot="Expert";
    }

    @FXML
    void enterInGridMatch(ActionEvent event) throws IOException {
        APlayer1.setImage(CustomSingle.getImage());
        APlayer1.setSigne(CustomSingle.getSigne());
        APlayer2.setName(levelOfBot.equals("Expert")?"Robert":"Jean");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GridMatch.fxml"));
        Parent root = loader.load();

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
