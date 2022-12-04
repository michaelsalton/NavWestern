package com.example.navwestern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

import static com.example.navwestern.Login.user;
import static com.example.navwestern.LoginJson.userIsAdmin;

public class HomePage implements Initializable {
    @FXML
    private Button homeButton, createPOIButton, devModeButton, displayButton, nextButton, previousButton, searchButton;
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
    private TextField searchText;
    @FXML
    private Text poiName, poiDescription;
    @FXML
    private ListView emptySearch;
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
    Image CampusMap = new Image(getClass().getResourceAsStream("/img/CampusMap.png"));
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectBuildingBox.getItems().addAll("Middlesex College","University College","Amit Chakma Engineering Building");
        imageView.setImage(CampusMap);
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
    public void onSearchEnter() {
        ListView<String> searchResults = new ListView<String>();
        searchResults.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        searchResults.setTranslateX(10);
        searchResults.setTranslateY(125);
        searchResults.setMaxHeight(175);
        searchResults.setMaxWidth(230);

        Stack resultsStack;
        resultsStack = POIJson.searchPOI(searchText.getText());

        for (int i = 0; i < resultsStack.size()+1; i ++) {
            searchResults.getItems().add(resultsStack.pop().toString());
        }
        stack.getChildren().add(searchResults);
    }
    public void DisplayMapButtonOnAction(ActionEvent e) {
        String building = getBuilding();
        switch (building) {
            case "Middlesex College":
                imageView.setImage(MC1);
                floor = "First Floor";
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
        uncheckLaterToggles();
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
                imageView.setImage(UC3);
                floor = "Third Floor";
            } else if (floor.equals("Third Floor")) {
                imageView.setImage(UC4);
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
        uncheckLaterToggles();
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
        if (userIsAdmin) {
            Main m = new Main();
            m.changeScene("developer_tools.fxml");
        }
    }
    public void AccessibilityOnAction(ActionEvent e) throws IOException {
        if (accessibilityBox.isSelected()) {
            buttonsArray = POIJson.togglePOI(getBuilding(), floor, "Accessibility");
            for (int i = 0; i < buttonsArray.length; i++){
                stack.getChildren().add(buttonsArray[i]);
            }
        }
        else for (int i = 0; i < buttonsArray.length; i++) {
            stack.getChildren().remove(buttonsArray[i]);
            }
    }
    public void ClassroomsOnAction(ActionEvent e) throws IOException {
        if (classroomsBox.isSelected()) {
            buttonsArray = POIJson.togglePOI(getBuilding(), floor, "Classroom");
            for (int i = 0; i < buttonsArray.length; i++){
                stack.getChildren().add(buttonsArray[i]);
            }
        }
        else for (int i = 0; i < buttonsArray.length; i++) {
            stack.getChildren().remove(buttonsArray[i]);
        }
    }
    public void LabsOnAction(ActionEvent e) throws IOException {
        if (labsBox.isSelected()) {
            buttonsArray = POIJson.togglePOI(getBuilding(), floor, "Lab");
            for (int i = 0; i < buttonsArray.length; i++) {
                stack.getChildren().add(buttonsArray[i]);
            }
        }
        else for (int i = 0; i < buttonsArray.length; i++) {
                stack.getChildren().remove(buttonsArray[i]);
            }
    }
    public void OfficesOnAction(ActionEvent e) throws IOException {
        if (officesBox.isSelected()) {
            buttonsArray = POIJson.togglePOI(getBuilding(), floor, "Office");
            for (int i = 0; i < buttonsArray.length; i++){
                stack.getChildren().add(buttonsArray[i]);
            }
        }
        else for (int i = 0; i < buttonsArray.length; i++) {
            stack.getChildren().remove(buttonsArray[i]);
        }
    }
    public void WashroomsOnAction(ActionEvent e) throws IOException {
        if (washroomsBox.isSelected()) {
            buttonsArray = POIJson.togglePOI(getBuilding(), floor, "Washroom");
            for (int i = 0; i < buttonsArray.length; i++){
                stack.getChildren().add(buttonsArray[i]);
            }
        }
        else for (int i = 0; i < buttonsArray.length; i++) {
            stack.getChildren().remove(buttonsArray[i]);
        }
    }
    public void RestaurantsOnAction(ActionEvent e) throws IOException {
        if (restaurantsBox.isSelected()) {
            buttonsArray = POIJson.togglePOI(getBuilding(), floor, "Restaurant");
            for (int i = 0; i < buttonsArray.length; i++){
                stack.getChildren().add(buttonsArray[i]);
            }
        }
        else for (int i = 0; i < buttonsArray.length; i++) {
            stack.getChildren().remove(buttonsArray[i]);
        }
    }
    public void CustomOnAction(ActionEvent e)  throws IOException {
        if (customPOIBox.isSelected()) {
            buttonsArray = POIJson.toggleCustomPOI(getBuilding(), floor, "Custom POI", user);
            for (int i = 0; i < buttonsArray.length; i++){
                stack.getChildren().add(buttonsArray[i]);
            }
        }
        else for (int i = 0; i < buttonsArray.length; i++) {
            stack.getChildren().remove(buttonsArray[i]);
        }
    }
    public void FavouritesOnAction(ActionEvent e) throws IOException {
        if (favouritesBox.isSelected()) {
            buttonsArray = POIJson.togglePOI(getBuilding(), floor, "Favourite");
            for (int i = 0; i < buttonsArray.length; i++){
                stack.getChildren().add(buttonsArray[i]);
            }
        }
        else for (int i = 0; i < buttonsArray.length; i++) {
            stack.getChildren().remove(buttonsArray[i]);
        }
    }
    public void uncheckLaterToggles() {
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