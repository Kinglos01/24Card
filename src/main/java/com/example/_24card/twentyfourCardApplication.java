package com.example._24card;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class twentyfourCardApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(twentyfourCardApplication.class.getResource("24card.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 350);
        scene.getStylesheets().add(getClass().getResource("/com/example/_24card/style.css").toExternalForm());
        stage.setTitle("24 Card the game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();


    }
}