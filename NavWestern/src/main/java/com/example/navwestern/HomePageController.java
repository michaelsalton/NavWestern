package com.example.navwestern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {
    @FXML
    private Button homeButton, createPOIButton, devModeButton;
    @FXML
    private ChoiceBox<String> selectBuildingBox;
    @FXML ChoiceBox<String> selectFloorBox;
    @FXML
    private ImageView imageView;
    public HomePageController() throws FileNotFoundException {
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectBuildingBox.getItems().addAll("Middlesex College","University College","Amit Chakma Engineering Building");
        selectFloorBox.getItems().addAll("First Floor","Second Floor","Third Floor");
    }
    @FXML
    public void getBuilding(MouseEvent event) throws FileNotFoundException {
        String building = selectBuildingBox.getSelectionModel().getSelectedItem();
        displayImage();
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
    public void DevModeButtonOnAction(ActionEvent e) throws IOException {
        Main m = new Main();
        m.changeScene("developer_login.fxml");
    }
    public void displayImage() throws FileNotFoundException {
        Image image = new Image(getClass().getResourceAsStream("/img/MC1.png"));
        imageView.setImage(image);
    }
}