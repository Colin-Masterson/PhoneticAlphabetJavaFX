package com.example.phoneticalphabetjavafx;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class GameLayout {
    public BorderPane getGameLayout(Label time, Label points, TextField input, Label guessLetter){
        BorderPane layout = new BorderPane();


        layout.setPadding(new Insets(0, 30, 30, 30));

        //top
        HBox statsBox = new HBox();
        statsBox.setSpacing(162);


        statsBox.getChildren().addAll(points, time);




        //Bottom
        HBox inputBox = new HBox();


        inputBox.getChildren().add(input);
        inputBox.setAlignment(Pos.CENTER);

        layout.setTop(statsBox);
        layout.setCenter(guessLetter);
        layout.setBottom(inputBox);

        return layout;
    }
}
