package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
    private ImageView logoImage;

    @FXML
    private ImageView cinemaImage;

    @FXML
    public void initialize() {
        // Aqui você pode inicializar elementos, caso precise.
    }

    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (isValidLogin(email, password)) {
            // Lógica para mudar para a próxima tela ou exibir mensagem de sucesso
            showAlert("Login bem-sucedido!", "Bem-vindo ao eventON!");
        } else {
            showAlert("Erro de login", "Email ou senha incorretos.");
        }
    }

    @FXML
    private void handleRegisterLinkAction(ActionEvent event) {
        // Lógica para abrir a tela de cadastro
        showAlert("Redirecionando", "Vamos para a tela de cadastro.");
    }

    private boolean isValidLogin(String email, String password) {
        // Aqui você pode implementar a lógica de validação de login,
        // como consultar um banco de dados ou verificar com dados mock.
        return email.equals("usuario@exemplo.com") && password.equals("senha123"); // Exemplo simples
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
