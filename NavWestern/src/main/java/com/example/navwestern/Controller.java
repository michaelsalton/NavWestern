package com.example.navwestern;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private ChoiceBox<String> selectBuildingBox;

    private final String[] buildings = {"Middlesex College","University College","Amit Chakma Engineering Building"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        selectBuildingBox.getItems().addAll(buildings);

    }
}