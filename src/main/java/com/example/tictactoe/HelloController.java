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
import javafx.stage.Stage;

import java.io.IOException;


public class HelloController {

    @FXML
    private Button boutonQuitter;

    @FXML
    private Button boutonRejouer;
    @FXML
    private Label annoceLeTour;

    @FXML
    private ImageView image;
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
    @FXML
    private Label nomDuJoueur1;

    @FXML
    private Label nomDuJoueur2;

    @FXML
    private Label scoreDuJoueur1;

    @FXML
    private Label scoreDuJoueur2;
    // Création de l'image

    private int x=0;
    Image croixPourPartirLiens = new Image("file:E:\\test_projet\\TicTacToe\\src\\main\\java\\com\\example\\tictactoe\\fermer-la-croix.png");
    ImageView croixPourPartir = new ImageView(croixPourPartirLiens);


    public void AfficheJoueur1(Joueur joueur){
        nomDuJoueur1.setText(joueur.getName());
    }
    public void AfficheJoueur2(Joueur joueur){
        nomDuJoueur2.setText(joueur.getName());
    }
    private Partie partie;

    public void setPartie(Partie partie) {
        this.partie = partie;
        nomDuJoueur1.setText(partie.getNameJoueur1());
        nomDuJoueur2.setText(partie.getNameJoueur2());
        scoreDuJoueur1.setText(""+partie.getScoreJoueur1());
        scoreDuJoueur2.setText(""+partie.getScoreJoueur2());
        croixPourPartir.setFitHeight(25);
        croixPourPartir.setFitWidth(25);
        boutonQuitter.setGraphic(croixPourPartir);

    }

    @FXML
    void onClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        if (clickedButton.getText().equals("")) {
            if (x % 2 == 0) {
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

            } else {
                Image cercleLien = new Image("file:E:\\test_projet\\TicTacToe\\src\\main\\java\\com\\example\\tictactoe\\cercle.png");
                ImageView cercle = new ImageView(cercleLien);
                cercle.setFitHeight(60);
                cercle.setFitWidth(60);
                clickedButton.setGraphic(cercle);
                clickedButton.setText("O");
                clickedButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                //annoceLeTour.setText("C'est au tour de : " + partie.getNameJoueur2());
            }
            verifieEtatGrille();
            x++;
        }
    }
    public void partiNull(){
        Button listNomBouton[] = {bouton0, bouton1, bouton2, bouton3, bouton4, bouton5, bouton6, bouton7, bouton8};
        for (int i = 0; i < 9; i++) {
            if(listNomBouton[i].getText()==""){
                listNomBouton[i].setDisable(true);
            }
        }
    }
        public void finDeparti(String quiGagne,Button bouton_1,Button bouton_2,Button bouton_3){
            System.out.println("Le bouton qui a gagner est : "+quiGagne);
            Button listNomBouton[] = {bouton0, bouton1, bouton2, bouton3, bouton4, bouton5, bouton6, bouton7, bouton8};
                bouton_1.setStyle("-fx-background-color: green;");
                bouton_2.setStyle("-fx-background-color: green;");
                bouton_3.setStyle("-fx-background-color: green;");
                switch (quiGagne) {
                    case "X":
                        partie.Joueur1Gagne();
                        for (int i = 0; i < 9; i++) {
                            if(listNomBouton[i].getText()==""){
                                listNomBouton[i].setDisable(true);
                            }
                        }
                        break;
                    case "O":
                        partie.Joueur2Gagne();
                        for (int i = 0; i < 9; i++) {
                            if(listNomBouton[i].getText()==""){
                                listNomBouton[i].setDisable(true);
                            }
                        }
                        break;
                    default:
                        break;
                }

            }


    private void verifieEtatGrille() {
        if (bouton0.getText().equals(bouton1.getText()) && bouton1.getText().equals(bouton2.getText()) && !(bouton0.getText().equals(""))&&!(bouton0.getText().equals("Fin"))){
            finDeparti(""+bouton0.getText(),bouton0,bouton1,bouton2);
        }
        if (bouton3.getText().equals(bouton4.getText()) && (bouton4.getText().equals(bouton5.getText()) && !(bouton3.getText().equals(""))&&!(bouton0.getText().equals("Fin")))) {
            finDeparti(""+bouton3.getText(),bouton3,bouton4,bouton5);
        }
        if (bouton6.getText().equals(bouton7.getText()) && (bouton7.getText().equals(bouton8.getText()) && !(bouton6.getText().equals(""))&&!(bouton0.getText().equals("Fin")))) {
            finDeparti(""+bouton6.getText(),bouton6,bouton7,bouton8);
        }
        if (bouton0.getText().equals(bouton3.getText()) && (bouton3.getText().equals(bouton6.getText()) && !(bouton0.getText().equals(""))&&!(bouton0.getText().equals("Fin")))) {
            finDeparti(""+bouton0.getText(),bouton3,bouton6,bouton0);
        }
        if (bouton1.getText().equals(bouton4.getText()) && (bouton4.getText().equals(bouton7.getText()) && !(bouton1.getText().equals(""))&&!(bouton0.getText().equals("Fin")))) {
            finDeparti(""+bouton1.getText(),bouton4,bouton1,bouton7);
        }
        if (bouton2.getText().equals(bouton5.getText()) && (bouton5.getText().equals(bouton8.getText()) && !(bouton2.getText().equals(""))&&!(bouton0.getText().equals("Fin")))) {
            finDeparti(""+bouton2.getText(),bouton2,bouton5,bouton8);
        }
        if (bouton0.getText().equals(bouton4.getText()) && (bouton4.getText().equals(bouton8.getText()) && !(bouton0.getText().equals(""))&&!(bouton0.getText().equals("Fin")))) {
            finDeparti(""+bouton0.getText(),bouton0,bouton4,bouton8);
        }
        if (bouton2.getText().equals(bouton4.getText()) && (bouton4.getText().equals(bouton6.getText()) && !(bouton2.getText().equals(""))&&!(bouton0.getText().equals("Fin")))) {
            finDeparti(""+bouton2.getText(),bouton2,bouton4,bouton6);
        }
    }
    @FXML
    void quitteLaPartie(ActionEvent event) throws IOException {
        Button source = (Button)event.getSource();
        // Charger le fichier FXML pour la page de jeu
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-acceuille.fxml"));
        Parent root = loader.load();

        // Créer une nouvelle scène avec la page de jeu
        Scene scene = new Scene(root);

        // Obtenir la fenêtre actuelle et définir la scène
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Page de Jeu");
        stage.setScene(scene);
    }

    @FXML
    void relanceUnePartie(ActionEvent event) {
        Button listNomBouton[] = {bouton0, bouton1, bouton2, bouton3, bouton4, bouton5, bouton6, bouton7, bouton8};
        for (int i = 0; i < 9; i++) {
            listNomBouton[i].setText("");
            listNomBouton[i].setGraphic(null);
            listNomBouton[i].setStyle("-fx-background-color: none");
            listNomBouton[i].setStyle("-fx-border-color: black");
            listNomBouton[i].setDisable(false);
            setPartie(partie);
        }

    }

}