package com.example.phoneticalphabetjavafx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StartLayout {

    public BorderPane getStartLayout(Button btnAlphabet, Button btnStart){

        BorderPane startLayout = new BorderPane();
        startLayout.setPadding(new Insets(0, 30, 30, 30));
        Label instructions = new Label("The aim of this application is to help you learn the Phonetic Alphabet");
        Label instructions2 = new Label("Press Show Alphabet below to view the Phonetic Alphabet");
        Label instructions3 = new Label("When you are ready close the Alphabet window and start the game");
        VBox instructionBox = new VBox();
        HBox buttonBox = new HBox();
        instructionBox.setSpacing(10);
        instructionBox.setAlignment(Pos.CENTER);
        instructionBox.getChildren().addAll(instructions, instructions2, instructions3);
        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(btnAlphabet, btnStart);

        startLayout.setCenter(instructionBox);
        startLayout.setBottom(buttonBox);

        return startLayout;
    }
}
