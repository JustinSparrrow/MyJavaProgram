package org.example.lab10_5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Label messageLabel;

    @FXML
    protected void handleRegisterButtonAction(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registration Status");

        if (username.length() < 4) {
            alert.setHeaderText(null);
            alert.setContentText("Username must be at least 4 characters long");
            alert.showAndWait();
        } else if (!password.equals(confirmPassword)) {
            alert.setHeaderText(null);
            alert.setContentText("Passwords do not match");
            alert.showAndWait();
        } else {
            alert.setHeaderText(null);
            alert.setContentText("Registration successful!");
            alert.showAndWait();
            // Here you can add code to actually register the user
        }
    }
}