package com.example.phoneticalphabetjavafx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AlphabetListLayout {
    private final Stage alphabetWindow;

    public AlphabetListLayout(Button btnClose, Button btnStart, AlphabetData alphabetData){
        alphabetWindow = new Stage();
        getAlphabetList(btnClose,btnStart,alphabetData);
    }

    private void getAlphabetList(Button btnClose, Button btnStart, AlphabetData alphabetData){
        BorderPane alphabetLayout = new BorderPane();
        alphabetLayout.setPadding(new Insets(0, 30, 30, 30));
        VBox alphabet = new VBox();
        alphabet.setAlignment(Pos.CENTER);
        for (String key : alphabetData.getAlphabet().keySet()) {
            String answer = alphabetData.getAlphabet().get(key);
            alphabet.getChildren().add(new Label(key + " -- " + answer));
        }
        HBox alphabetButtons = new HBox();


        alphabetButtons.getChildren().add(btnClose);
        alphabetButtons.setAlignment(Pos.CENTER);

        alphabetLayout.setCenter(alphabet);
        alphabetLayout.setBottom(alphabetButtons);
        Scene alphabetScreen = new Scene(alphabetLayout, 300, 600);
        alphabetWindow.setTitle("Phonetic Alphabet");
        alphabetWindow.setScene(alphabetScreen);
        alphabetWindow.setResizable(false);
        alphabetWindow.setX(400);
        alphabetWindow.setY(100);
        alphabetWindow.setOnCloseRequest(e -> {
            btnStart.setDisable(false);
            // alphabetWindow.hide();
        });
        alphabetWindow.initStyle(StageStyle.UTILITY);

    }

    public Stage getAlphabetWindow() {
        return alphabetWindow;
    }
}
