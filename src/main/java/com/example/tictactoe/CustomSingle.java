package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomSingle {
    @FXML
    private Pane backgroundPPPlayer1;

    @FXML
    private Pane backgroundPPPlayer11;

    @FXML
    private Button buttonGoToGrid;

    @FXML
    private Button buttonLeftPPPlayer1;

    @FXML
    private Button buttonLeftSymbolPlayer1;

    @FXML
    private Button buttonRightPPPlayer1;

    @FXML
    private Button buttonRightSymbolPlayer1;

    @FXML
    private Label namePlayer;

    @FXML
    private ImageView ppPlayer1;

    @FXML
    private ImageView symbolPlayer1;
    @FXML
    void goToTheMatch(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("GridMatch.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Match");
        stage.setScene(scene);
    }

    @FXML
    void leftPPPlayer1(ActionEvent event) {

    }

    @FXML
    void leftSymbolPlayer1(ActionEvent event) {

    }

    @FXML
    void rightPPPlayer1(ActionEvent event) {

    }

    @FXML
    void rightSymbolPlayer1(ActionEvent event) {

    }
}
