package com.example.navwestern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CreateAccount {
    @FXML
    private TextField firstNametextField, usernameTextField, passwordPasswordField;
    @FXML
    private Button backToLoginButton, createAccountButton;
    @FXML
    private Label logInMessageLabel;

    public void createAccountOnAction() throws IOException {
        Main m = new Main();
        String firstname = firstNametextField.getText();
        String username = usernameTextField.getText();
        String password = passwordPasswordField.getText();

        LoginTable.createNewUserJson(firstname, username, password);


        m.changeScene("home_page.fxml");



    }



    public void backToLoginOnAction() throws IOException {
        Main m = new Main();
        m.changeScene("login.fxml");



    }
}
