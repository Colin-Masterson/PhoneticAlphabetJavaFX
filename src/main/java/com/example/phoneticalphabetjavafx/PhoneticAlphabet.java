package com.example.phoneticalphabetjavafx;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

import javafx.scene.text.Font;
import javafx.stage.Stage;

import javafx.util.Duration;


public class PhoneticAlphabet extends Application {
    private final AlphabetData alphabetData = new AlphabetData();
    private final StartLayout layout1 = new StartLayout();

    private final GameLayout gameLayout = new GameLayout();

    private int totalPoints = 0;
    private int seconds = 0;

    private Stage alphabetWindow;


    @Override
    public void start(Stage stage) {
        /*Start Screen*/
        Button showAlphabet = new Button("Show Alphabet");
        Button startGame = new Button("Start");
        BorderPane startLayout = layout1.getStartLayout(showAlphabet, startGame);

        /* Alphabet List*/
        Button closeAlphabet = new Button("Close");
        AlphabetListLayout layout2 = new AlphabetListLayout(closeAlphabet, startGame, alphabetData);
        alphabetWindow = layout2.getAlphabetWindow();

        /*Main Game Screen*/
        Label time = new Label("Time: 0");
        Label points = new Label("Points: " + totalPoints);
        TextField input = new TextField();
        Label guessLetter = new Label(alphabetData.getCurrentLetter());
        guessLetter.setFont(new Font("Ariel", 50));
        BorderPane layout = gameLayout.getGameLayout(time, points, input, guessLetter);


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