/**
 *
 * this file is the controller for the home page
 *
 *
 * HomePage.java
 * @author  Michael Salton
 * @version 2.077
 * @since   2022-11-08
 */

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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;

import static com.example.navwestern.Login.user;
import static com.example.navwestern.LoginJson.userIsAdmin;
import static com.example.navwestern.POIJson.buttonsArray;

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
    private AnchorPane stack, labsPane, classroomsPane;
    Button[] buttonsArray = {}, labsArray = {}, classroomsArray = {}, customPOIArray = {};
    String floor;
    @FXML
    private TextField searchText;
    @FXML
    private Text poiName, poiDescription, welcomeText, floorDisplay;
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
    Image UC4 = new Image(getClass().getResourceAsStream("/img/UC4.png"));
    Image ACEB1 = new Image(getClass().getResourceAsStream("/img/ACEB1.png"));
    Image ACEB2 = new Image(getClass().getResourceAsStream("/img/ACEB2.png"));
    Image ACEB3 = new Image(getClass().getResourceAsStream("/img/ACEB3.png"));
    Image ACEB4 = new Image(getClass().getResourceAsStream("/img/ACEB4.png"));
    Image ACEB5 = new Image(getClass().getResourceAsStream("/img/ACEB5.png"));
    Image ucfifthfloor = new Image(getClass().getResourceAsStream("/img/ucfifthfloor.png"));
    Image marker = new Image(getClass().getResourceAsStream("/img/marker.png"));
    Image CampusMap = new Image(getClass().getResourceAsStream("/img/CampusMap.png"));

    /**
     *intializes the items on the screen on page open
     *
     * @param  url
     * @param  resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectBuildingBox.getItems().addAll("Middlesex College","University College","Amit Chakma Engineering Building");
        imageView.setImage(CampusMap);
        welcomeText.setText("Welcome " + user);
    }

    /**
     * gets the building selected in the drop-down menu
     *
     * @return String   building name
     */
    public String getBuilding() {
        return selectBuildingBox.getSelectionModel().getSelectedItem();
    }

    /**
     * displays the user guide page when the user clicks the button
     *
     * @param  e    ActionEvent.
     */
    public void UserGuideButtonOnAction(ActionEvent e) throws IOException {
        Main m = new Main();
        m.changeScene("user_guide.fxml");

    }

    /**
     * fills the list with search results from the users input
     */
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

    /**
     * this function displays the first floor of the map of whatever building the user selected
     *
     * @param  e    ActionEvent. the on action click event
     */
    public void DisplayMapButtonOnAction(ActionEvent e) {
        previousButton.setVisible(true);
        nextButton.setVisible(true);
        String building = getBuilding();
        switch (building) {
            case "Middlesex College":
                imageView.setImage(MC1);
                floor = "First Floor";
                floorDisplay.setText("First Floor");
                break;
            case "University College":
                imageView.setImage(UC1);
                floor = "First Floor";
                floorDisplay.setText("First Floor");
                break;
            case "Amit Chakma Engineering Building":
                imageView.setImage(ACEB1);
                floor = "First Floor";
                floorDisplay.setText("First Floor");
                break;
        }
    }
    /**
     * displays the appropriate image when the user clicks the next image button
     */
    public void nextOnAction(ActionEvent e) throws NullPointerException{
        uncheckLaterToggles();
        if (getBuilding().equals("Middlesex College")) {
            if (floor.equals("First Floor")) {
                floor = "Second Floor";
                floorDisplay.setText("Second Floor");
                imageView.setImage(MC2);
            } else if (floor.equals("Second Floor")) {
                floor = "Third Floor";
                floorDisplay.setText("Third Floor");
                imageView.setImage(MC3);
            } else if (floor.equals("Third Floor")) {
                floor = "Fourth Floor";
                floorDisplay.setText("Fourth Floor");
                imageView.setImage(MC4);
            } else if (floor.equals("Fourth Floor")) {
                imageView.setImage(MC5);
                floorDisplay.setText("Fifth Floor");
                floor = "Fifth Floor";
            } else if (floor.equals("Fifth Floor")) {
                imageView.setImage(MC1);
                floorDisplay.setText("First Floor");
                floor = "First Floor";
            }
        } else if (getBuilding().equals("University College")) {
            if (floor.equals("First Floor")) {
                imageView.setImage(UC2);
                floorDisplay.setText("Second Floor");
                floor = "Second Floor";
            } else if (floor.equals("Second Floor")) {
                floorDisplay.setText("Third Floor");
                imageView.setImage(UC3);
                floor = "Third Floor";
            } else if (floor.equals("Third Floor")) {
                floorDisplay.setText("Fourth Floor");
                imageView.setImage(UC4);
                floor = "Fourth Floor";
            } else if (floor.equals("Fourth Floor")) {
                imageView.setImage(UC1);
                floorDisplay.setText("First Floor");
                floor = "First Floor";
            }
        } else if (getBuilding().equals("Amit Chakma Engineering Building")) {
            if (floor.equals("First Floor")) {
                imageView.setImage(ACEB2);
                floorDisplay.setText("Second Floor");
                floor = "Second Floor";
            } else if (floor.equals("Second Floor")) {
                imageView.setImage(ACEB3);
                floorDisplay.setText("Third Floor");
                floor = "Third Floor";
            } else if (floor.equals("Third Floor")) {
                imageView.setImage(ACEB4);
                floorDisplay.setText("Fourth Floor");
                floor = "Fourth Floor";
            } else if (floor.equals("Fourth Floor")) {
                imageView.setImage(ACEB5);
                floorDisplay.setText("Fifth Floor");
                floor = "Fifth Floor";
            } else if (floor.equals("Fifth Floor")) {
                imageView.setImage(ACEB1);
                floorDisplay.setText("First Floor");
                floor = "First Floor";
            }
        }
    }
    /**
     * Displays the appropriate image when user clicks previous image button
     */
    public void previousOnAction(ActionEvent e) {
        uncheckLaterToggles();
        if (getBuilding().equals("Middlesex College")) {
            if (floor.equals("First Floor")) {
                floorDisplay.setText("Fifth Floor");
                imageView.setImage(MC5);
                floor = "Fifth Floor";
            } else if (floor.equals("Second Floor")) {
                imageView.setImage(MC1);
                floorDisplay.setText("First Floor");
                floor = "First Floor";
            } else if (floor.equals("Third Floor")) {
                imageView.setImage(MC2);
                floorDisplay.setText("Second Floor");
                floor = "Second Floor";
            } else if (floor.equals("Fourth Floor")) {
                imageView.setImage(MC3);
                floorDisplay.setText("Third Floor");
                floor = "Third Floor";
            } else if (floor.equals("Fifth Floor")) {
                imageView.setImage(MC4);
                floorDisplay.setText("Fourth Floor");
                floor = "Fourth Floor";
            }
        } else if (getBuilding().equals("University College")) {
            if (floor.equals("First Floor")) {
                imageView.setImage(UC4);
                floorDisplay.setText("Fourth Floor");
                floor = "Fourth Floor";
            } else if (floor.equals("Second Floor")) {
                imageView.setImage(UC1);
                floorDisplay.setText("First Floor");
                floor = "First Floor";
            } else if (floor.equals("Third Floor")) {
                imageView.setImage(UC2);
                floorDisplay.setText("Second Floor");
                floor = "Second Floor";
            } else if (floor.equals("Fourth Floor")) {
                imageView.setImage(UC3);
                floorDisplay.setText("Third Floor");
                floor = "Third Floor";
            }
        } else if (getBuilding().equals("Amit Chakma Engineering Building")) {
            if (floor.equals("First Floor")) {
                floorDisplay.setText("Fifth Floor");
                floor = "Fifth Floor";
                imageView.setImage(ACEB5);
            } else if (floor.equals("Second Floor")) {
                floorDisplay.setText("First Floor");
                floor = "First Floor";
                imageView.setImage(ACEB1);
            } else if (floor.equals("Third Floor")) {
                floorDisplay.setText("Second Floor");
                floor = "Second Floor";
                imageView.setImage(ACEB2);
            } else if (floor.equals("Fourth Floor")) {
                floorDisplay.setText("Third Floor");
                floor = "Third Floor";
                imageView.setImage(ACEB3);
            } else if (floor.equals("Fifth Floor")) {
                floorDisplay.setText("Fourth Floor");
                floor = "Fourth Floor";
                imageView.setImage(ACEB4);
            }
        }
    }

    /**
     * opens the home page on click
     *
     * @param  e ActionEvent
     */
    public void HomeButtonOnAction(ActionEvent e) throws IOException {
    }

    /**
     * opens the create POI page on click
     *
     * @param  e    ActionEvent
     */
    public void CreatePOIButtonOnAction(ActionEvent e) throws IOException {
        Main m = new Main();
        m.changeScene("user_create_poi.fxml");
    }

    /**
     *
     * opens the developer mode page on click
     *
     * @param  e    ActionEvent
     */
    public void DevModeButtonOnAction(ActionEvent e) throws IOException {
        if (userIsAdmin) {
            Main m = new Main();
            m.changeScene("developer_tools.fxml");
        }
    }

    /**
     * displays the accessibility poi layer
     *
     * @param  e    ActionEvent
     */
    public void AccessibilityOnAction(ActionEvent e) throws IOException {
        if (accessibilityBox.isSelected()) {
            buttonsArray = POIJson.togglePOI(getBuilding(), floor, "Accessibility");
            for (int i = 0; i < buttonsArray.length; i++){
                stack.getChildren().add(buttonsArray[i]);
            }
        }
        else for (int i = 0; i < buttonsArray.length; i++) {
            stack.getChildren().remove(buttonsArray[i]);
            //removeElement();
        }
    }

    /**
     * displays the classroom poi layer
     *
     * @param  e    ActionEvent
     */
    public void ClassroomsOnAction(ActionEvent e) throws IOException {
        if (classroomsBox.isSelected()) {
            classroomsArray = POIJson.togglePOI(getBuilding(), floor, "Classroom");
            for (int i = 0; i < classroomsArray.length; i++){
                stack.getChildren().add(classroomsArray[i]);
            }
        }
        else for (int i = 0; i < classroomsArray.length; i++) {
            stack.getChildren().remove(classroomsArray[i]);
        }
    }

    /**
     * displays the labs poi layer
     *
     * @param  e    ActionEvent
     */
    public void LabsOnAction(ActionEvent e) throws IOException {
        if (labsBox.isSelected()) {
            labsArray = POIJson.togglePOI(getBuilding(), floor, "Lab");
            for (int i = 0; i < labsArray.length; i++) {
                stack.getChildren().add(labsArray[i]);
            }
        }
        else for (int i = 0; i < labsArray.length; i++) {
            stack.getChildren().remove(labsArray[i]);
        }
    }

    /**
     * displays the offices poi layer
     *
     * @param  e    ActionEvent
     */
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

    /**
     * displays the washrooms poi layer
     *
     * @param  e    ActionEvent
     */
    public void WashroomsOnAction(ActionEvent e) throws IOException {
        if (washroomsBox.isSelected()) {
            buttonsArray = POIJson.togglePOI(getBuilding(), floor, "Washroom");
            for (int i = 0; i < buttonsArray.length; i++){
                stack.getChildren().add(buttonsArray[i]);
            }
        }
        else for (int i = 0; i < buttonsArray.length; i++) {
            stack.getChildren().remove(buttonsArray[i]);
            //removeElement();
        }
    }

    /**
     * displays the restaurants poi layer
     *
     * @param  e    ActionEvent
     */
    public void RestaurantsOnAction(ActionEvent e) throws IOException {
        if (restaurantsBox.isSelected()) {
            buttonsArray = POIJson.togglePOI(getBuilding(), floor, "Restaurant");
            for (int i = 0; i < buttonsArray.length; i++){
                stack.getChildren().add(buttonsArray[i]);
            }
        }
        else for (int i = 0; i < buttonsArray.length; i++) {
            stack.getChildren().remove(buttonsArray[i]);
            //removeElement();
        }
    }

    /**
     * displays the custom poi poi layer
     *
     * @param  e    ActionEvent
     */
    public void CustomOnAction(ActionEvent e)  throws IOException {
        if (customPOIBox.isSelected()) {
            buttonsArray = POIJson.toggleCustomPOI(getBuilding(), floor, "Custom POI", user);
            for (int i = 0; i < buttonsArray.length; i++){
                stack.getChildren().add(buttonsArray[i]);
            }
        }
        else for (int i = 0; i < buttonsArray.length; i++) {
            stack.getChildren().remove(buttonsArray[i]);
            //removeElement();
        }
    }

    /**
     * displays the favourites poi layer
     *
     * @param  e    ActionEvent
     */
    public void FavouritesOnAction(ActionEvent e) throws IOException {
        if (favouritesBox.isSelected()) {
            buttonsArray = POIJson.togglePOI(getBuilding(), floor, "Favourite");
            for (int i = 0; i < buttonsArray.length; i++){
                stack.getChildren().add(buttonsArray[i]);
            }
        }
        else for (int i = 0; i < buttonsArray.length; i++) {
            stack.getChildren().remove(buttonsArray[i]);
            //removeElement();
        }
    }

    /**
     * removes elements from array
     */
    public void removeElement() {
        int removeElement = buttonsArray.length-1;
        Button[] proxyArray = new Button[buttonsArray.length - 1];
        for (int i = 0, k = 0; i < buttonsArray.length; i++) {
            // check if index is crossed, continue without copying
            if (i == removeElement) {
                continue;
            }
            proxyArray[k++] = buttonsArray[i];
        }
        buttonsArray = proxyArray;
    }

    /**
     * unchecks all checkboxes and removes pois from screen
     */
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