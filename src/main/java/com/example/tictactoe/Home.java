package com.example.tictactoe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Home {

        @FXML
        private Button buttonMultiplayer;

        @FXML
        private Button buttonRules;

        @FXML
        private Button buttonSimplePlayer;
        @FXML
        void enterInSimplePlayer(ActionEvent event) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("SinglePlayer.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Single player");
            stage.setScene(scene);
        }
        @FXML
        void enterInMultiplayer(ActionEvent event) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("Multiplayer.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Multiplayer");
            stage.setScene(scene);
        }

        @FXML
        void enterInRules(ActionEvent event) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(Rules.class.getResource("Rules.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Rules");
            stage.setScene(scene);
        }



}
