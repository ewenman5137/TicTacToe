package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class HelloController {
    @FXML
    private Button bouton0;

    @FXML
    private Button bouton1;

    @FXML
    private Button bouton2;

    @FXML
    private Button bouton3;

    @FXML
    private Button bouton4;

    @FXML
    private Button bouton5;

    @FXML
    private Button bouton6;

    @FXML
    private Button bouton7;

    @FXML
    private Button bouton8;
    @FXML
    private Label title;
    private int x=0;


    @FXML
    void onClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        if(clickedButton.getText().equals("")){
            if (x%2==0){
                clickedButton.setText("X");
            }
            else{
                clickedButton.setText("O");
            }
            x++;
        }

        verifieEtatGrille();
    }
    private void verifieEtatGrille() {
        if (bouton0.getText().equals(bouton1.getText()) && (bouton1.getText().equals(bouton2.getText()) && !(bouton0.getText().equals("")))) {
            System.out.println("Victoire de la part du joueur " + bouton0.getText());
        }

        if (bouton3.getText().equals(bouton4.getText()) && (bouton4.getText().equals(bouton5.getText()) && !(bouton3.getText().equals("")))) {
            System.out.println("Victoire de la part du joueur " + bouton3.getText());
        }
        if (bouton6.getText().equals(bouton7.getText()) && (bouton7.getText().equals(bouton8.getText()) && !(bouton6.getText().equals("")))) {
            System.out.println("Victoire de la part du joueur " + bouton6.getText());
        }
        if (bouton0.getText().equals(bouton3.getText()) && (bouton3.getText().equals(bouton6.getText()) && !(bouton0.getText().equals("")))) {
            System.out.println("Victoire de la part du joueur " + bouton0.getText());
        }
        if (bouton1.getText().equals(bouton4.getText()) && (bouton4.getText().equals(bouton7.getText()) && !(bouton1.getText().equals("")))) {
            System.out.println("Victoire de la part du joueur " + bouton1.getText());
        }
        if (bouton2.getText().equals(bouton5.getText()) && (bouton5.getText().equals(bouton8.getText()) && !(bouton2.getText().equals("")))) {
            System.out.println("Victoire de la part du joueur " + bouton2.getText());
        }
        if (bouton0.getText().equals(bouton4.getText()) && (bouton4.getText().equals(bouton8.getText()) && !(bouton0.getText().equals("")))) {
            System.out.println("Victoire de la part du joueur " + bouton0.getText());
        }
        if (bouton2.getText().equals(bouton4.getText()) && (bouton4.getText().equals(bouton6.getText()) && !(bouton2.getText().equals("")))) {
            System.out.println("Victoire de la part du joueur " + bouton2.getText());
        }
    }
}