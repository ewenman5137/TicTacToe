package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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


    static String[] listNameImagePP={"baleine.png","grenouille.png","lelephant.png","bird.png","perroquet.png","singe.png","tortue.png"};
    static String[] listNameImageSigneCroix={"fermer-la-croix.png","croitDessin.png","croitRond.png","croixContour.png","croixRouge.png","croixRougeAndWhite.png","traverser.png"};
    static int x=0;
    static int y=0;

    @FXML
    void rightPPPlayer1(ActionEvent event) {
        if(x==listNameImagePP.length-1){
            x = 0;
        }else{
            x++;
        }
        System.out.println(x);
        ppPlayer1.setImage(new Image(listNameImagePP[x]));
    }
    @FXML
    void leftPPPlayer1(ActionEvent event) {
        if(x==0){
            x = listNameImagePP.length-1;
        }else{
            x--;
        }
        ppPlayer1.setImage(new Image(listNameImagePP[x]));
        System.out.println(x);
    }


    @FXML
    void leftSymbolPlayer1(ActionEvent event) {
        if(y==0){
            y = listNameImageSigneCroix.length-1;
        }else{
            y--;
        }
        symbolPlayer1.setImage(new Image(listNameImageSigneCroix[y]));
    }



    @FXML
    void rightSymbolPlayer1(ActionEvent event) {
        if(y==listNameImageSigneCroix.length-1){
            y = 0;
        }else{
            y++;
        }
        symbolPlayer1.setImage(new Image(listNameImageSigneCroix[y]));
    }
    public static String getImage(){
        return listNameImagePP[x];
    }
    public static String getSigne(){
        return listNameImageSigneCroix[y];
    }
    @FXML
    void goToTheMatch(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("Multi.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
