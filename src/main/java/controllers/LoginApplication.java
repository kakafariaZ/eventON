package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Carrega o arquivo FXML para a tela de login
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

            // Cria uma cena com a interface de login
            Scene scene = new Scene(root);

            // Configura o título da janela e a exibe
            primaryStage.setTitle("Login - eventON");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar o arquivo FXML.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
