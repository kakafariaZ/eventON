package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class CadastroController {

    @FXML
    private TextField nomeField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField cpfField;

    @FXML
    private PasswordField senhaField;

    @FXML
    private PasswordField senha2Field;

    @FXML
    private Button cadastrarButton;

    @FXML
    private Hyperlink loginLink;

    @FXML
    private void handleCadastrarButtonAction(ActionEvent event) {
        String nome = nomeField.getText();
        String email = emailField.getText();
        String cpf = cpfField.getText();
        String senha = senhaField.getText();
        String senha2 = senha2Field.getText();

        if (nome.isEmpty() || email.isEmpty() || cpf.isEmpty() || senha.isEmpty() || senha2.isEmpty()) {
            showAlert("Campos vazios", "Por favor, preencha todos os campos.");
        } else if (!senha.equals(senha2)) {
            showAlert("Senhas não coincidem", "A confirmação da senha está incorreta.");
        } else {
            // Lógica para salvar os dados do usuário (pode ser em um banco de dados ou arquivo)
            showAlert("Cadastro realizado", "Usuário cadastrado com sucesso!");
            // Redirecionar para tela de login ou outra ação
        }
    }

    @FXML
    private void handleLoginLinkAction(ActionEvent event) {
        // Lógica para redirecionar o usuário para a tela de login
        showAlert("Redirecionando", "Indo para a tela de login.");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
