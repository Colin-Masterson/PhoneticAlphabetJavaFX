package com.example.phoneticalphabetjavafx;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


public class PhoneticAlphabet extends Application {
    private final AlphabetData alphabetData = new AlphabetData();
    private int totalPoints = 0;
    private int seconds = 0;

    private final Stage alphabetWindow = new Stage();


    @Override
    public void start(Stage stage) {
        /*Start Screen*/
        BorderPane startLayout = new BorderPane();
        startLayout.setPadding(new Insets(0, 30, 30, 30));
        Label instructions = new Label("The aim of this application is to help you learn the Phonetic Alphabet");
        Label instructions2 = new Label("Press Show Alphabet below to view the Phonetic Alphabet");
        Label instructions3 = new Label("When you are ready close the Alphabet window and start the game");
        Button showAlphabet = new Button("Show Alphabet");
        Button startGame = new Button("Start");
        VBox instructionBox = new VBox();
        HBox buttonBox = new HBox();
        instructionBox.setSpacing(10);
        instructionBox.setAlignment(Pos.CENTER);
        instructionBox.getChildren().addAll(instructions, instructions2, instructions3);
        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(showAlphabet, startGame);

        startLayout.setCenter(instructionBox);
        startLayout.setBottom(buttonBox);

        /* Alphabet List*/
        BorderPane alphabetLayout = new BorderPane();
        alphabetLayout.setPadding(new Insets(0, 30, 30, 30));
        VBox alphabet = new VBox();
        alphabet.setAlignment(Pos.CENTER);
        for (String key : alphabetData.getAlphabet().keySet()) {
            String answer = alphabetData.getAlphabet().get(key);
            alphabet.getChildren().add(new Label(key + " -- " + answer));
        }
        HBox alphabetButtons = new HBox();
        Button closeAlphabet = new Button("Close");

        alphabetButtons.getChildren().add(closeAlphabet);
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
            startGame.setDisable(false);
            // alphabetWindow.hide();
        });
        alphabetWindow.initStyle(StageStyle.UTILITY);



        /*Main Game Screen*/
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(0, 30, 30, 30));

        //top
        HBox statsBox = new HBox();
        statsBox.setSpacing(162);
        //display points
        Label points = new Label("Points: " + totalPoints);
        //display time
        Label time = new Label("Time: 0");
        statsBox.getChildren().addAll(points, time);

        //center
        //will display a random letter
        Label guessLetter = new Label(alphabetData.getCurrentLetter());
        guessLetter.setFont(new Font("Ariel", 50));

        //Bottom
        HBox inputBox = new HBox();

        //input for user guess
        TextField input = new TextField();


        inputBox.getChildren().add(input);
        inputBox.setAlignment(Pos.CENTER);

        layout.setTop(statsBox);
        layout.setCenter(guessLetter);
        layout.setBottom(inputBox);


        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {

            seconds++;
            time.setText("Time: " + seconds);


        }));
        timeline.setCycleCount(Animation.INDEFINITE);


        new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (seconds >= 30) {
                    timeline.stop();
                    guessLetter.setText("Fin");
                }
            }
        }.start();

        /* Button actions */


        Scene gameScreen = new Scene(layout, 320, 240);

        gameScreen.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                if (alphabetData.isCorrect(input.getText())) {
                    totalPoints = totalPoints + 10;
                    points.setText("Points: " + totalPoints);


                }
                alphabetData.getRandom();
                guessLetter.setText(alphabetData.getCurrentLetter());
                input.setText("");
                input.requestFocus();
            }
        });

        startGame.setOnAction(e -> {

            stage.setScene(gameScreen);
            timeline.play();
        });

        showAlphabet.setOnAction(e -> {
            startGame.setDisable(true);
            alphabetWindow.show();
        });

        closeAlphabet.setOnAction(e -> {
            startGame.setDisable(false);
            alphabetWindow.hide();
        });

        Scene startScreen = new Scene(startLayout, 450, 240);

        stage.setTitle("Learn the Phonetic Alphabet");
        stage.setResizable(false);
        stage.setScene(startScreen);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}