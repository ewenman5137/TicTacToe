package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Custom {
    @FXML
private Pane backgroundPPPlayer1;

    @FXML
    private Pane backgroundPPPlayer11;

    @FXML
    private Pane backgroundPPPlayer2;

    @FXML
    private Pane backgroundPPPlayer21;

    @FXML
    private Button buttonGoToGrid;

    @FXML
    private Button buttonLeftPPPlayer1;

    @FXML
    private Button buttonLeftPPPlayer2;

    @FXML
    private Button buttonLeftSymbolPlayer1;

    @FXML
    private Button buttonLeftSymbolPlayer2;

    @FXML
    private Button buttonRightPPPlayer1;

    @FXML
    private Button buttonRightPPPlayer2;

    @FXML
    private Button buttonRightSymbolPlayer1;

    @FXML
    private Button buttonRightSymbolPlayer2;

    @FXML
    private ImageView ppPlayer1;

    @FXML
    private ImageView ppPlayer2;

    @FXML
    private ImageView symbolPlayer1;

    @FXML
    private ImageView symbolPlayer2;



    @FXML
    void leftPPPlayer1(ActionEvent event) {

    }

    @FXML
    void leftPPPlayer2(ActionEvent event) {

    }

    @FXML
    void leftSymbolPlayer1(ActionEvent event) {

    }

    @FXML
    void leftSymbolPlayer2(ActionEvent event) {

    }

    @FXML
    void restartTheGrid(ActionEvent event) {

    }

    @FXML
    void rightPPPlayer1(ActionEvent event) {

    }

    @FXML
    void rightPPPlayer2(ActionEvent event) {

    }

    @FXML
    void rightSymbolPlayer1(ActionEvent event) {

    }

    @FXML
    void rightSymbolePlayer2(ActionEvent event) {

    }
    @FXML
    void goToTheMatch(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("Multi.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
