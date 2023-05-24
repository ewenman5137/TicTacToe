package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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

    static String[] listNameImagePP={"baleine.png","grenouille.png","lelephant.png","bird.png","perroquet.png","singe.png","tortue.png"};
    static String[] listNameImageSigneCroix={"fermer-la-croix.png","croitDessin.png","croitRond.png","croixContour.png","croixRouge.png","croixRougeAndWhite.png","traverser.png"};
    static String[] listNameImageSigneRond={"cercle.png","cercleCyan.png","cercleNinja.png","vide.png"};
    static int indexPlayer1PP=0;
    static int indexPlayer2PP=0;
    static int indexPlayer1Signe=0;
    static int indexPlayer2Signe=1;

    @FXML
    void leftPPPlayer1(ActionEvent event) {
        if(indexPlayer1PP==0){
            indexPlayer1PP = listNameImagePP.length-1;
        }else{
            indexPlayer1PP--;
        }
        ppPlayer1.setImage(new Image(listNameImagePP[indexPlayer1PP]));
    }

    @FXML
    void leftPPPlayer2(ActionEvent event) {
        if(indexPlayer2PP==0){
            indexPlayer2PP = listNameImagePP.length-1;
        }else{
            indexPlayer2PP--;
        }
        ppPlayer2.setImage(new Image(listNameImagePP[indexPlayer2PP]));
    }

    @FXML
    void leftSymbolPlayer1(ActionEvent event) {
        if(indexPlayer1Signe==0){
            indexPlayer1Signe = listNameImageSigneCroix.length-1;
        }else{
            indexPlayer1Signe--;
        }
        symbolPlayer1.setImage(new Image(listNameImageSigneCroix[indexPlayer1Signe]));
    }

    @FXML
    void leftSymbolPlayer2(ActionEvent event) {
        if(indexPlayer2Signe==0){
            indexPlayer2Signe = listNameImageSigneRond.length-1;
        }else{
            indexPlayer2Signe--;
        }
        symbolPlayer2.setImage(new Image(listNameImageSigneRond[indexPlayer2Signe]));
    }

    @FXML
    void restartTheGrid(ActionEvent event) {
        System.out.println("test hello");
    }

    @FXML
    void rightPPPlayer1(ActionEvent event) {
        if(indexPlayer1PP==listNameImagePP.length-1){
            indexPlayer1PP = 0;
        }else{
            indexPlayer1PP++;
        }
        System.out.println(indexPlayer1PP);
        ppPlayer1.setImage(new Image(listNameImagePP[indexPlayer1PP]));
    }

    @FXML
    void rightPPPlayer2(ActionEvent event) {
        if(indexPlayer2PP==listNameImagePP.length-1){
            indexPlayer2PP = 0;
        }else{
            indexPlayer2PP++;
        }
        ppPlayer2.setImage(new Image(listNameImagePP[indexPlayer2PP]));
    }

    @FXML
    void rightSymbolPlayer1(ActionEvent event) {
        if(indexPlayer1Signe==listNameImageSigneCroix.length-1){
            indexPlayer1Signe = 0;
        }else{
            indexPlayer1Signe++;
        }
        symbolPlayer1.setImage(new Image(listNameImageSigneCroix[indexPlayer1Signe]));
    }

    @FXML
    void rightSymbolePlayer2(ActionEvent event) {
        if(indexPlayer2Signe==listNameImageSigneRond.length-1){
            indexPlayer2Signe = 0;
        }else{
            indexPlayer2Signe++;
        }
        symbolPlayer2.setImage(new Image(listNameImageSigneRond[indexPlayer2Signe]));
    }
    public static String getImagePPPlayer1(){
        return listNameImagePP[indexPlayer1PP];
    }
    public static String getImagePPPlayer2(){
        return listNameImagePP[indexPlayer2PP];
    }public static String getSignePlayer1(){
        return listNameImageSigneCroix[indexPlayer1Signe];
    }
    public static String getSignePlayer2(){
        return listNameImageSigneRond[indexPlayer2Signe];
    }

    @FXML
    void goToTheMatch(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("Multi.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
