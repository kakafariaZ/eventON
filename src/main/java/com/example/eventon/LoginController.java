package com.example.eventon;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink registerLink;

    @FXML
    private void handleLoginButtonAction() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (validateLogin(email, password)) {
            System.out.println("Login bem-sucedido!");
            loadNewScene("/com/example/eventon/welcome.fxml", loginButton);  // Transição para a tela de boas-vindas
        } else {
            System.out.println("Email ou senha incorretos.");
        }
    }

    @FXML
    private void handleRegisterLinkAction() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/eventon/cadastro.fxml"));
            Stage stage = (Stage) registerLink.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean validateLogin(String email, String password) {
        // Lógica simples de validação de login (exemplo)
        return "user@email.com".equals(email) && "1234".equals(password);
    }

    private void loadNewScene(String fxmlFile, Button button) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
            Stage stage = (Stage) button.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
