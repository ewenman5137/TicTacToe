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

public class HelloAcceuille {
    @FXML
    private Button boutonPrincipaleEntrer;
    Joueur UnJoueur1 = new Joueur("Joueur 1");

    Joueur UnJoueur2 = new Joueur("Joueur 2");


    @FXML
    void entreDansLeJeu(ActionEvent event) throws IOException {
        // Charger le fichier FXML pour la page de jeu
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();

        // Obtenir le contrôleur de la page de jeu
        HelloController helloController = loader.getController();
        Partie partie = new Partie(UnJoueur1, UnJoueur2);
        helloController.setPartie(partie);

        // Créer une nouvelle scène avec la page de jeu
        Scene scene = new Scene(root);

        // Obtenir la fenêtre actuelle et définir la scène
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
    @FXML
    private Label Joueur1;

    @FXML
    private Label Joueur2;
    @FXML
    private TextField champNomJoueur1;

    @FXML
    private TextField champNomJoueur2;

    @FXML
    private Button creeJoueur1;

    @FXML
    private Button creeJoueur2;

    @FXML
    void CreeJoueur1(ActionEvent event) {
        Joueur1.setText(champNomJoueur1.getText());
        UnJoueur1.setName(champNomJoueur1.getText());

    }

    @FXML
    void CreeJoueur2(ActionEvent event) {
        Joueur2.setText(champNomJoueur2.getText());
        UnJoueur2.setName(champNomJoueur2.getText());
    }
}
