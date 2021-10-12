package com.example.m4m5;

import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class GuessingGame extends Application {

    private Text message, inputFieldLabel, result;
    private TextField numberInputField;
    private Button submitButton, playButton;
    private int target = 0;

    @Override
    public void start(Stage stage) {

        GridPane pane = new GridPane();
        pane.setStyle("-fx-background-color: pink");
        pane.setVgap(3);

        message = new Text("Welcome to the Hi-Lo Guessing Game!");
        message.setFont(Font.font(24));
        message.setFill(Color.TEAL);
        pane.getChildren().add(message);

        playButton = new Button("Let's Play!");
        playButton.setTextFill(Color.TEAL);
        playButton.setOnAction(this::handlePlayButton);
        pane.add(playButton, 0, 1);

        inputFieldLabel = new Text("Enter your guess from 1 - 100: ");
        inputFieldLabel.setFont(Font.font(16));
        inputFieldLabel.setFill(Color.INDIANRED);
        pane.add(inputFieldLabel, 0, 2);

        numberInputField = new TextField();
        submitButton = new Button("Submit Guess");
        submitButton.setTextFill(Color.INDIANRED);
        submitButton.setOnAction(this::processTextField);
        TilePane numberPane = new TilePane(numberInputField, submitButton);
        numberInputField.setOnAction(this::processTextField);
        pane.add(numberPane, 0, 3);

        result = new Text("");
        result.setFont(Font.font(18));
        result.setFill(Color.TEAL);
        pane.add(result, 0, 4);

        Scene scene = new Scene(pane, 500, 300, Color.LAVENDERBLUSH);
        stage.setTitle("Guess the Number!");
        stage.setScene(scene);
        stage.show();
    }

    private void handlePlayButton(ActionEvent event) {
        target = ((int) (Math.random()*(101 - 1))) + 1;
        System.out.println(target);
    }

    private void processTextField(ActionEvent event) {

        if (target < 1) {
            result.setText("Click on 'Let's Play!' button to start game.");
        } else {
            try {
                int userInputText = Integer.parseInt(numberInputField.getText());

                if (userInputText < target) {
                    result.setText("Your guess is too low.");
                } else if (userInputText > target) {
                    result.setText("Your guess is too high.");
                } else {
                    result.setText("Congratulations! You guessed correctly! " +
                            "\nClick on 'Let's Play!' if you want to play again.");
                    result.setFont(Font.font("Copperplate Gothic Bold",24));
                }

            } catch(NumberFormatException exception) {
                result.setText("Error - input is not a number.");
            }
            numberInputField.clear();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}