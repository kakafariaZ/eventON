package com.example.eventon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Carregue a primeira tela (Login)
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/eventon/login.fxml"));
            primaryStage.setTitle("eventON - Login");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
