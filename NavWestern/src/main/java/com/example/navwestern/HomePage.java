package com.example.navwestern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePage implements Initializable {
    @FXML
    private Button homeButton, createPOIButton, devModeButton, displayButton;
    @FXML
    private ChoiceBox<String> selectBuildingBox, selectFloorBox;
    @FXML
    private CheckBox accessibilityBox, labsBox;
    @FXML
    private ImageView imageView;
    @FXML
    private AnchorPane stack;
    Button[] buttonsArray = {};

    Image MC1 = new Image(getClass().getResourceAsStream("/img/MC1.png"));
    Image MC2 = new Image(getClass().getResourceAsStream("/img/MC2.png"));
    Image MC3 = new Image(getClass().getResourceAsStream("/img/MC3.png"));
    Image MC4 = new Image(getClass().getResourceAsStream("/img/MC4.png"));
    Image MC5 = new Image(getClass().getResourceAsStream("/img/MC5.png"));
    Image UC1 = new Image(getClass().getResourceAsStream("/img/UC1.png"));
    Image UC2 = new Image(getClass().getResourceAsStream("/img/UC2.png"));
    Image UC3 = new Image(getClass().getResourceAsStream("/img/UC3.png"));
    Image UC4 = new Image(getClass().getResourceAsStream("/img/UC1.png"));
    Image ACEB1 = new Image(getClass().getResourceAsStream("/img/ACEB1.png"));
    Image ACEB2 = new Image(getClass().getResourceAsStream("/img/ACEB2.png"));
    Image ACEB3 = new Image(getClass().getResourceAsStream("/img/ACEB3.png"));
    Image ACEB4 = new Image(getClass().getResourceAsStream("/img/ACEB4.png"));
    Image ACEB5 = new Image(getClass().getResourceAsStream("/img/ACEB5.png"));
    Image ucfifthfloor = new Image(getClass().getResourceAsStream("/img/ucfifthfloor.png"));
    Image marker = new Image(getClass().getResourceAsStream("/img/marker.png"));
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectBuildingBox.getItems().addAll("Middlesex College","University College","Amit Chakma Engineering Building");
        selectFloorBox.getItems().addAll("First Floor","Second Floor","Third Floor", "Fourth Floor", "Fifth Floor");
    }
    public String getBuilding() {
        return selectBuildingBox.getSelectionModel().getSelectedItem();
    }
    public String getFloor() {
        return selectFloorBox.getSelectionModel().getSelectedItem();
    }
    public void showDisplayButton() {
        if (!getBuilding().isBlank() && !getFloor().isBlank()) {
            displayButton.setVisible(true);
            displayButton.managedProperty().bind(displayButton.visibleProperty());
        }
    }
    public void DisplayMapButtonOnAction(ActionEvent e) {
        String building = getBuilding();
        String floor = getFloor();
        switch (building) {
            case "Middlesex College":
                switch (floor) {
                    case "First Floor":
                        imageView.setImage(MC1);
                        break;
                    case "Second Floor":
                        imageView.setImage(MC2);
                        break;
                    case "Third Floor":
                        imageView.setImage(MC3);
                        break;
                    case "Fourth Floor":
                        imageView.setImage(MC4);
                        break;
                    case "Fifth Floor":
                        imageView.setImage(MC5);
                        break;
                }
            break;
            case "University College":
                switch (floor) {
                    case "First Floor":
                        imageView.setImage(UC1);
                        break;
                    case "Second Floor":
                        imageView.setImage(UC2);
                        break;
                    case "Third Floor":
                        imageView.setImage(UC3);
                        break;
                    case "Fourth Floor":
                        imageView.setImage(UC4);
                        break;
                    case "Fifth Floor":
                        imageView.setImage(ucfifthfloor);
                        break;
                }
            break;
            case "Amit Chakma Engineering Building":
                switch (floor) {
                    case "First Floor":
                        imageView.setImage(ACEB1);
                        break;
                    case "Second Floor":
                        imageView.setImage(ACEB2);
                        break;
                    case "Third Floor":
                        imageView.setImage(ACEB3);
                        break;
                    case "Fourth Floor":
                        imageView.setImage(ACEB4);
                        break;
                    case "Fifth Floor":
                        imageView.setImage(ACEB5);
                        break;
                }
            break;
        }
    }
    public void HomeButtonOnAction(ActionEvent e) throws IOException {
    }
    public void CreatePOIButtonOnAction(ActionEvent e) throws IOException {
        Main m = new Main();
        m.changeScene("user_create_poi.fxml");
    }
    public void DevModeButtonOnAction(ActionEvent e) throws IOException {
        Main m = new Main();
        m.changeScene("developer_login.fxml");
    }
    public void AccessibilityOnAction(ActionEvent e) {
    }

    public void ClassroomsOnAction(ActionEvent e) {
    }
    public void LabsOnAction(ActionEvent e) throws IOException {
        buttonsArray = poiTable.togglePOI(getBuilding(), getFloor(), "Labs");
        if (labsBox.isSelected()) {
            for (int i = 0; i < buttonsArray.length; i++){
                stack.getChildren().add(buttonsArray[i]);
            }
        }
        else for (int i = 0; i < buttonsArray.length; i++){
            stack.getChildren().remove(buttonsArray[i]);
        }
    }

    public void OfficesOnAction(ActionEvent e) {
    }

    public void WashroomsOnAction(ActionEvent e) {
    }

    public void RestaurantsOnAction(ActionEvent e){
    }

    public void CustomOnAction(ActionEvent e)  throws IOException {
        buttonsArray = poiTable.togglePOI(getBuilding(), getFloor(), "Custom POI");
        if (labsBox.isSelected()) {
            for (int i = 0; i < buttonsArray.length; i++){
                stack.getChildren().add(buttonsArray[i]);
            }
        }
        else for (int i = 0; i < buttonsArray.length; i++){
            stack.getChildren().remove(buttonsArray[i]);
        }
    }

    public void FavouritesOnAction(ActionEvent e) {
    }

}