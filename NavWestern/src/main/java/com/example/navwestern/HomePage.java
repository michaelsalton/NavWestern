package com.example.navwestern;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePage implements Initializable {
    @FXML
    private Button homeButton, createPOIButton, devModeButton, displayButton, nextButton, previousButton;
    @FXML
    private ChoiceBox<String> selectBuildingBox, selectFloorBox;
    @FXML
    private CheckBox accessibilityBox, labsBox, classroomsBox, customPOIBox, restaurantsBox, favouritesBox, officesBox,
            washroomsBox;
    @FXML
    private ImageView imageView;
    @FXML
    private AnchorPane stack;
    Button[] buttonsArray = {};
    String floor;
    @FXML
    private Text poiName, poiDescription;

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
    }
    public String getBuilding() {
        return selectBuildingBox.getSelectionModel().getSelectedItem();
    }
    public void showDisplayButton() {
        if (!getBuilding().isBlank()) {
            displayButton.setVisible(true);
            displayButton.managedProperty().bind(displayButton.visibleProperty());
        }
    }
    public void DisplayMapButtonOnAction(ActionEvent e) {
        String building = getBuilding();
        switch (building) {
            case "Middlesex College":
                imageView.setImage(MC1);
                floor = "First Floor";
                System.out.println(imageView);
                break;
            case "University College":
                imageView.setImage(UC1);
                floor = "First Floor";
                break;
            case "Amit Chakma Engineering Building":
                imageView.setImage(ACEB1);
                floor = "First Floor";
                break;
        }
    }
    public void nextOnAction(ActionEvent e) throws NullPointerException{
        clearPOIS();
        if (getBuilding().equals("Middlesex College")) {
            if (floor.equals("First Floor")) {
                floor = "Second Floor";
                imageView.setImage(MC2);
            } else if (floor.equals("Second Floor")) {
                floor = "Third Floor";
                imageView.setImage(MC3);
            } else if (floor.equals("Third Floor")) {
                floor = "Fourth Floor";
                imageView.setImage(MC4);
            } else if (floor.equals("Fourth Floor")) {
                imageView.setImage(MC5);
                floor = "Fifth Floor";
            } else if (floor.equals("Fifth Floor")) {
                imageView.setImage(MC1);
                floor = "First Floor";
            }
        } else if (getBuilding().equals("University College")) {
            if (floor.equals("First Floor")) {
                imageView.setImage(UC2);
                floor = "Second Floor";
            } else if (floor.equals("Second Floor")) {
                imageView.setImage(MC3);
                floor = "Third Floor";
            } else if (floor.equals("Third Floor")) {
                imageView.setImage(MC4);
                floor = "Fourth Floor";
            } else if (floor.equals("Fourth Floor")) {
                imageView.setImage(UC1);
                floor = "First Floor";
            }
        } else if (getBuilding().equals("Amit Chakma Engineering Building")) {
            if (floor.equals("First Floor")) {
                imageView.setImage(ACEB2);
                floor = "Second Floor";
            } else if (floor.equals("Second Floor")) {
                imageView.setImage(ACEB3);
                floor = "Third Floor";
            } else if (floor.equals("Third Floor")) {
                imageView.setImage(ACEB4);
                floor = "Fourth Floor";
            } else if (floor.equals("Fourth Floor")) {
                imageView.setImage(ACEB1);
                floor = "First Floor";
            }
        }
    }
    public void previousOnAction(ActionEvent e) {
        clearPOIS();
        if (getBuilding().equals("Middlesex College")) {
            if (floor.equals("First Floor")) {
                imageView.setImage(MC5);
                floor = "Fifth Floor";
            } else if (floor.equals("Second Floor")) {
                imageView.setImage(MC1);
                floor = "First Floor";
            } else if (floor.equals("Third Floor")) {
                imageView.setImage(MC2);
                floor = "Second Floor";
            } else if (floor.equals("Fourth Floor")) {
                imageView.setImage(MC3);
                floor = "Third Floor";
            } else if (floor.equals("Fifth Floor")) {
                imageView.setImage(MC4);
                floor = "Fourth Floor";
            }
        } else if (getBuilding().equals("University College")) {
            if (floor.equals("First Floor")) {
                imageView.setImage(UC4);
                floor = "Fourth Floor";
            } else if (floor.equals("Second Floor")) {
                imageView.setImage(UC1);
                floor = "First Floor";
            } else if (floor.equals("Third Floor")) {
                imageView.setImage(UC2);
                floor = "Second Floor";
            } else if (floor.equals("Fourth Floor")) {
                imageView.setImage(UC3);
                floor = "Third Floor";
            }
        } else if (getBuilding().equals("Amit Chakma Engineering Building")) {
            if (floor.equals("First Floor")) {
                floor = "Fifth Floor";
                imageView.setImage(ACEB5);
            } else if (floor.equals("Second Floor")) {
                floor = "First Floor";
                imageView.setImage(ACEB1);
            } else if (floor.equals("Third Floor")) {
                floor = "Second Floor";
                imageView.setImage(ACEB2);
            } else if (floor.equals("Fourth Floor")) {
                floor = "Third Floor";
                imageView.setImage(ACEB3);
            } else if (floor.equals("Fifth Floor")) {
                floor = "Fourth Floor";
                imageView.setImage(ACEB4);
            }
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
    public void AccessibilityOnAction(ActionEvent e) throws IOException {
        buttonsArray = poiTable.togglePOI(getBuilding(), floor, "Custom POI");
        if (labsBox.isSelected()) {
            for (int i = 0; i < buttonsArray.length; i++){
                stack.getChildren().add(buttonsArray[i]);
            }
        }
        else for (int i = 0; i < buttonsArray.length; i++){
            stack.getChildren().remove(buttonsArray[i]);
        }
    }
    public void ClassroomsOnAction(ActionEvent e) throws IOException {
        buttonsArray = poiTable.togglePOI(getBuilding(), floor, "Classrooms");
        if (labsBox.isSelected()) {
            for (int i = 0; i < buttonsArray.length; i++){
                stack.getChildren().add(buttonsArray[i]);
            }
        }
        else for (int i = 0; i < buttonsArray.length; i++){
            stack.getChildren().remove(buttonsArray[i]);
        }
    }
    public void LabsOnAction(ActionEvent e) throws IOException {
        buttonsArray = poiTable.togglePOI(getBuilding(), floor, "Labs");
        if (labsBox.isSelected()) {
            for (int i = 0; i < buttonsArray.length; i++) {
                stack.getChildren().add(buttonsArray[i]);
                buttonsArray[i].setOnAction(POIOnClick());
            }
        }
        else for (int i = 0; i < buttonsArray.length; i++) {
            stack.getChildren().remove(buttonsArray[i]);
        }
    }
    private EventHandler<ActionEvent> POIOnClick() {
        poiName.setVisible(true);
        poiDescription.setVisible(true);

        return null;
    }
    public void OfficesOnAction(ActionEvent e) throws IOException {
        buttonsArray = poiTable.togglePOI(getBuilding(), floor, "Offices");
        if (labsBox.isSelected()) {
            for (int i = 0; i < buttonsArray.length; i++){
                stack.getChildren().add(buttonsArray[i]);
            }
        }
        else for (int i = 0; i < buttonsArray.length; i++){
            stack.getChildren().remove(buttonsArray[i]);
        }
    }
    public void WashroomsOnAction(ActionEvent e) throws IOException {
        buttonsArray = poiTable.togglePOI(getBuilding(), floor, "Washrooms");
        if (labsBox.isSelected()) {
            for (int i = 0; i < buttonsArray.length; i++){
                stack.getChildren().add(buttonsArray[i]);
            }
        }
        else for (int i = 0; i < buttonsArray.length; i++){
            stack.getChildren().remove(buttonsArray[i]);
        }
    }
    public void RestaurantsOnAction(ActionEvent e) throws IOException {
        buttonsArray = poiTable.togglePOI(getBuilding(), floor, "Restaurants");
        if (labsBox.isSelected()) {
            for (int i = 0; i < buttonsArray.length; i++){
                stack.getChildren().add(buttonsArray[i]);
            }
        }
        else for (int i = 0; i < buttonsArray.length; i++){
            stack.getChildren().remove(buttonsArray[i]);
        }
    }
    public void CustomOnAction(ActionEvent e)  throws IOException {
        buttonsArray = poiTable.togglePOI(getBuilding(), floor, "Custom POI");
        if (labsBox.isSelected()) {
            for (int i = 0; i < buttonsArray.length; i++){
                stack.getChildren().add(buttonsArray[i]);
            }
        }
        else for (int i = 0; i < buttonsArray.length; i++){
            stack.getChildren().remove(buttonsArray[i]);
        }
    }
    public void FavouritesOnAction(ActionEvent e) throws IOException {
        buttonsArray = poiTable.togglePOI(getBuilding(), floor, "Favourites");
        if (labsBox.isSelected()) {
            for (int i = 0; i < buttonsArray.length; i++){
                stack.getChildren().add(buttonsArray[i]);
            }
        }
        else for (int i = 0; i < buttonsArray.length; i++){
            stack.getChildren().remove(buttonsArray[i]);
        }
    }
    public void clearPOIS() {
        labsBox.setSelected(false);
        classroomsBox.setSelected(false);
        washroomsBox.setSelected(false);
        favouritesBox.setSelected(false);
        customPOIBox.setSelected(false);
        accessibilityBox.setSelected(false);
        officesBox.setSelected(false);
        restaurantsBox.setSelected(false);
        poiName.setVisible(false);
        poiDescription.setVisible(false);
        for (int i = 0; i < buttonsArray.length; i++){
            stack.getChildren().remove(buttonsArray[i]);
        }
    }
}