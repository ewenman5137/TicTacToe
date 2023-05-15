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
    private Label labelPlayer1;

    @FXML
    private TextField textFieldNamePlayer1;

    Player APlayer1 = new Player("Player 1",true);
    Player APlayer2 = new Player("Player 2",false);
    //Bot ABot = new Bot("Jean",false);
    String levelOfBot="Easy";
    @FXML
    void createPlayer1(ActionEvent event) {
        labelPlayer1.setText(textFieldNamePlayer1.getText());
        APlayer1.setName(textFieldNamePlayer1.getText());
    }

    @FXML
    void enterInCustomMenuSingle(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomSingle.fxml"));
        Parent root = loader.load();
        Party party = new Party(APlayer1, APlayer2);
        switch (levelOfBot){
            case("Easy"):
                System.out.println("Okay Jean is coming");
                APlayer2.setName("Jean__Bot");
                break;
            case("Expert"):
                System.out.println("Okay Robert is coming");
                APlayer2.setName("Robert__Bot");
                break;
        }
        GridMatch gridMatch = loader.getController();
        gridMatch.setParty(party);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Page de Jeu");
        stage.setWidth(700);
        stage.setHeight(900);
        stage.setScene(scene);
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
}
