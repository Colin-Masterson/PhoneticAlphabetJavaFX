package com.example.phoneticalphabetjavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class PhoneticAlphabet extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(0,30,30,30));

        //top
        HBox statsBox = new HBox();
        statsBox.setSpacing(130);
        //display points
        Label points = new Label("Points: 0");
        //display time
        Label time = new Label("Time: 00:00:00");
        statsBox.getChildren().addAll(points, time);

        //center
        //will display a random letter
        Label guessLetter = new Label();

        //Bottom
        HBox inputBox = new HBox();
        inputBox.setSpacing(55);
        //input for user guess
        TextField input = new TextField();
        //submit guess
        Button submit = new Button("Submit");
        inputBox.getChildren().addAll(input, submit);

        layout.setTop(statsBox);
        layout.setCenter(guessLetter);
        layout.setBottom(inputBox);

        Scene scene = new Scene(layout, 320, 240);
        stage.setTitle("Learn the Phonetic Alphabet");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}