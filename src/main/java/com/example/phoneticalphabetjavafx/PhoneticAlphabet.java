package com.example.phoneticalphabetjavafx;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;





public class PhoneticAlphabet extends Application {
    private final AlphabetData alphabetData = new AlphabetData();
    private int totalPoints = 0;
    private int seconds = 0;

    @Override
    public void start(Stage stage){
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(0,30,30,30));

        //top
        HBox statsBox = new HBox();
        statsBox.setSpacing(150);
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
        inputBox.setSpacing(55);
        //input for user guess
        TextField input = new TextField();
        //submit guess
        Button submit = new Button("Submit");
        submit.setOnAction(actionEvent -> {
            if(alphabetData.isCorrect(input.getText())){
                    this.totalPoints = totalPoints + 10;
                    points.setText("Points: " + totalPoints);

                    alphabetData.getRandom();
                    guessLetter.setText(alphabetData.getCurrentLetter());
                    input.requestFocus();
            }
            else {

                alphabetData.getRandom();
                guessLetter.setText(alphabetData.getCurrentLetter());
                input.requestFocus();
            }

        });
        inputBox.getChildren().addAll(input, submit);

        layout.setTop(statsBox);
        layout.setCenter(guessLetter);
        layout.setBottom(inputBox);


        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {

            seconds++;
            time.setText("Time: " + seconds);


        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        new AnimationTimer(){
            @Override
            public void handle(long l) {
                if(seconds >=30){
                    timeline.stop();
                    guessLetter.setText("Fin");
                }
            }
        }.start();



        Scene scene = new Scene(layout, 320, 240);
        stage.setTitle("Learn the Phonetic Alphabet");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}