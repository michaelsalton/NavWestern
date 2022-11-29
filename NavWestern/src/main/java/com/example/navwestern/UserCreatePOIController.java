package com.example.navwestern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class UserCreatePOIController {

    @FXML
    private Button homeButton, createPOIButton;

    public void HomeButtonOnAction(ActionEvent e) throws IOException {
        Main m = new Main();
        m.changeScene("home_page.fxml");

    }

    public void CreatePOIButtonOnAction(ActionEvent e) throws IOException {
        Main m = new Main();
        m.changeScene("userCreatePOI.fxml");
    }





}
