package com.example.navwestern;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CreateAccount {
    @FXML
    private TextField firstNameTextField, usernameTextField, passwordPasswordField;
    @FXML
    private Button backToLoginButton, createAccountButton;
    @FXML
    private Label logInMessageLabel;

    public void createAccountOnAction() throws IOException {
        Main m = new Main();
        String firstname = firstNameTextField.getText();
        String username = usernameTextField.getText();
        String password = passwordPasswordField.getText();


        LoginJson.createNewUserJson(firstname, username, password);

        m.changeScene("home_page.fxml");
    }



    public void backToLoginOnAction() throws IOException {
        Main m = new Main();
        m.changeScene("login.fxml");



    }
}
