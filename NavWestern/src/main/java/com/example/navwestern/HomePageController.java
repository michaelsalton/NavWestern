package com.example.navwestern;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable{

    @FXML
    private ChoiceBox<String> selectBuildingBox;

    @FXML ChoiceBox<String> selectFloorBox;

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
}