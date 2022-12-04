package com.example.navwestern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.navwestern.Login.user;

public class UserCreatePOI implements Initializable{
    @FXML
    private Button homeButton, createPOIButton;
    @FXML
    private ChoiceBox<String> selectPOIBuildingBox, selectPOIFloorBox;
    @FXML
    private ImageView imageView;
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
    private double x;
    private double y;
    @FXML
    private AnchorPane stack;
    @FXML
    private CheckBox toggle;
    @FXML
    private Button addPOI;
    @FXML
    private TextField description, name, type;
    @FXML
    private Label nameLabel, descriptionLabel, toggleLabel;
    Button button = new Button();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectPOIBuildingBox.getItems().addAll("Middlesex College","University College","Amit Chakma Engineering Building");
        selectPOIFloorBox.getItems().addAll("First Floor","Second Floor","Third Floor", "Fourth Floor", "Fifth Floor");
    }
    public void HomeButtonOnAction(ActionEvent e) throws IOException {
        Main m = new Main();
        m.changeScene("home_page.fxml");
    }
    public void CreatePOIButtonOnAction(ActionEvent e) throws IOException {
    }
    public String getBuilding() {
        return selectPOIBuildingBox.getSelectionModel().getSelectedItem();
    }
    public String getFloor() {
        return selectPOIFloorBox.getSelectionModel().getSelectedItem();
    }
    public void mouse(MouseEvent e) {
        if (toggle.isSelected()) {
            name.setVisible(true);
            name.managedProperty().bind(name.visibleProperty());
            description.setVisible(true);
            description.managedProperty().bind(description.visibleProperty());
            nameLabel.setVisible(true);
            nameLabel.managedProperty().bind(nameLabel.visibleProperty());
            descriptionLabel.setVisible(true);
            descriptionLabel.managedProperty().bind(descriptionLabel.visibleProperty());
            addPOI.setVisible(true);
            addPOI.managedProperty().bind(addPOI.visibleProperty());

            x = e.getX();
            y = e.getY();
            button.setTranslateX(x);
            button.setTranslateY(y);

            stack.getChildren().add(button);
        }
    }
    @FXML
    public void toggleOnAction() {
        if(!toggle.isSelected()) {
            stack.getChildren().remove(button);
        }
    }
    public void addPOIOnClick() throws IOException {
        name.setVisible(false);
        name.managedProperty().bind(name.visibleProperty());
        description.setVisible(false);
        description.managedProperty().bind(description.visibleProperty());
        nameLabel.setVisible(false);
        nameLabel.managedProperty().bind(nameLabel.visibleProperty());
        descriptionLabel.setVisible(false);
        descriptionLabel.managedProperty().bind(description.visibleProperty());

        POIJson.createNewPOIJson(getBuilding(), getFloor(), name.getText(), "Custom POI", description.getText(), user,x, y);
    }
    public void DisplayMapButtonOnAction(ActionEvent e) {
        toggle.setVisible(true);
        toggle.managedProperty().bind(name.visibleProperty());
        toggleLabel.setVisible(true);
        toggleLabel.managedProperty().bind(name.visibleProperty());
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
}
