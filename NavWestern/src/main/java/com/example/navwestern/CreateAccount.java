package com.example.navwestern;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CreateAccount {

    @FXML
    private TextField firstName, username, password;

    @FXML
    private Button backToLoginButton, createAccountButton;

    @FXML
    private Label logInMessageLabel;

    public void createAccountOnAction() throws IOException {
        Main m = new Main();
        m.changeScene("home_page.fxml");

    }

    public void backToLoginOnAction() throws IOException {
        Main m = new Main();
        m.changeScene("login.fxml");


    }
}
