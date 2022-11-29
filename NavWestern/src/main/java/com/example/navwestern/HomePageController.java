package com.example.navwestern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable{
    @FXML
    private Button homeButton, createPOIButton;
    @FXML
    private ChoiceBox<String> selectBuildingBox;
    @FXML ChoiceBox<String> selectFloorBox;
    @FXML
    private ImageView imageView;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectBuildingBox.getItems().addAll("Middlesex College","University College","Amit Chakma Engineering Building");
        selectFloorBox.getItems().addAll("First Floor","Second Floor","Third Floor");
    }
    @FXML
    public void getBuilding(MouseEvent event) {
        String building = selectBuildingBox.getSelectionModel().getSelectedItem();
    }
    public void getFloor(MouseEvent event) {
        String building = selectFloorBox.getSelectionModel().getSelectedItem();
    }
    public void HomeButtonOnAction(ActionEvent e) throws IOException {
    }
    public void CreatePOIButtonOnAction(ActionEvent e) throws IOException {
        Main m = new Main();
        m.changeScene("userCreatePOI.fxml");
    }
    Image mc1 = new Image(getClass().getResourceAsStream("MC-BF-1.png"));

    public void displayImage() {
        imageView.setImage(mc1);
    }
}

