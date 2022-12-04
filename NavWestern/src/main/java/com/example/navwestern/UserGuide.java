package com.example.navwestern;

import javafx.event.ActionEvent;


import java.io.IOException;

public class UserGuide {

    public void CreatePOIButtonOnAction(ActionEvent e) throws IOException {
        Main m = new Main();
        m.changeScene("user_create_poi.fxml");
    }

    public void HomeButtonOnAction(ActionEvent e) throws IOException {
        Main m = new Main();
        m.changeScene("home_page.fxml");
    }

    public void UserGuideButtonOnAction(ActionEvent e) throws IOException {

    }


}
