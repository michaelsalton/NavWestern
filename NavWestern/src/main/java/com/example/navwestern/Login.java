package com.example.navwestern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {
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
    public void createAccountOnAction(ActionEvent e) throws IOException {
        Main m = new Main();
        m.changeScene("create_account.fxml");
    }
    public void LogInButtonOnAction(ActionEvent e) throws IOException {
        Main m = new Main();
        String username = userNameTextField.getText();
        String password = passwordPasswordField.getText();
        if (LoginTable.usernameExists(username) && LoginTable.isUser(username, password)) {
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
