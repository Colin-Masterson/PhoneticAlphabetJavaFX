package com.example.phoneticalphabetjavafx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class GameOverLayout {

    public BorderPane getGameOverLayout(int score) {
        BorderPane gameOverLayout = new BorderPane();
        gameOverLayout.setPadding(new Insets(0, 30, 30, 30));

        Label gameOver = new Label("Game Over");
        Label finalScore = new Label("Final Score: " + score + "!");
        gameOver.setFont(new Font("Ariel", 40));
        finalScore.setFont(new Font("Ariel", 20));

        VBox gameOverDetails = new VBox();
        gameOverDetails.setSpacing(10);
        gameOverDetails.getChildren().addAll(gameOver, finalScore);
        gameOverDetails.setAlignment(Pos.CENTER);

        gameOverLayout.setCenter(gameOverDetails);


        return gameOverLayout;
    }
}
