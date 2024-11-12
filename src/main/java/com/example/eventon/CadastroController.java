package com.example.eventon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Parent;
import models.Usuario;
import models.Controller;

import java.io.IOException;

public class CadastroController {

    @FXML
    private TextField login;

    @FXML
    private TextField nome;

    @FXML
    private TextField email;

    @FXML
    private TextField cpf;

    @FXML
    private PasswordField senha;

    @FXML
    private PasswordField senha2;

    @FXML
    private Button registerButton;

    @FXML
    private Hyperlink loginLink;

    private final Controller controller;

    public CadastroController(Controller controller) {
        this.controller = controller; // Inicializa o Controller
    }

    @FXML
    private void cadastrarUsuario(ActionEvent event) {
        // Lógica para cadastro (validação de dados e registro)
        String loginText = login.getText();
        String nomeText = nome.getText();
        String emailText = email.getText();
        String cpfText = cpf.getText();
        String senhaText = senha.getText();
        String senha2Text = senha2.getText();

        // Verificando se as senhas coincidem
        if (!senhaText.equals(senha2Text)) {
            showAlert("Erro", "As senhas não correspondem.", Alert.AlertType.ERROR);
            return;
        }

        // Tentando cadastrar o usuário
        Usuario usuario = controller.cadastrarUsuario(loginText, senhaText, nomeText, cpfText, emailText, false);

        if (usuario != null) {
            showAlert("Cadastro realizado com sucesso!", "Usuário cadastrado.", Alert.AlertType.INFORMATION);
            changeScene("/com/example/eventon/login.fxml"); // Alterna para a tela de Login após o cadastro
        } else {
            showAlert("Erro", "Falha ao cadastrar o usuário.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleLoginLinkAction() {
        changeScene("com/example/eventon/login.fxml"); // Alterna para a tela de Login quando o link é clicado
    }

    private void changeScene(String fxmlFilePath) {
        try {
            // Carrega o novo layout FXML
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFilePath));

            // Acessa a janela (Stage) atual a partir do botão de registro
            Stage stage = (Stage) registerButton.getScene().getWindow();

            // Se o stage for nulo (não encontrado), tenta abrir uma nova janela
            if (stage == null) {
                stage = new Stage();
            }

            // Define o novo layout e exibe a nova cena
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            showAlert("Erro", "Falha ao carregar a tela. Tente novamente.", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
