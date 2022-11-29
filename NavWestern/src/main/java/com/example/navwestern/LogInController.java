package com.example.navwestern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController {
    @FXML
    private Button cancelButton, logInButton, developerLogInButton;
    @FXML
    private Label logInMessageLabel;
    @FXML
    private TextField userNameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    public void CancelButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    public void LogInButtonOnAction(ActionEvent e) throws IOException {
        Main m = new Main();
        if (userNameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false) {
            logInMessageLabel.setText("Login");
            m.changeScene("home_page.fxml");
        } else {
            logInMessageLabel.setText("Please enter username and password");
        }
    }
    public void DeveloperLogInButtonOnAction(ActionEvent e) throws IOException {
        Main m = new Main();
        m.changeScene("developer_login.fxml");
    }
}
