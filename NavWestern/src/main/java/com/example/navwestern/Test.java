package com.example.navwestern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class Test implements Initializable {

    @FXML
    private Circle myCircle;
    private double x;
    private double y;


    @FXML
    private AnchorPane stack;

    @FXML
    public void mouse1(MouseEvent e) {
        System.out.println("mouseeeeclicked");
        //myCircle.setCenterY(y+=10);
        stack.getChildren().add(new Button("Test"));
    }

    public void mouse(MouseEvent ee) {
        System.out.println("mouse cliked");
        x = ee.getX();
        y = ee.getX();
        //y = ee.getY();
        Button button = new Button("Test");
        // button.setLayoutX(x);
        // button.setLayoutX(y);

        AnchorPane.setRightAnchor(button, (1824.0 - x));
        AnchorPane.setTopAnchor(button, (1035.0 - y));
        stack.getChildren().add(button);



        System.out.println(x);
        System.out.println(y);
        //System.out.println(ee.getScreenZ());
        //System.out.println(ee.getX());

        System.out.println(ee.getY());
        System.out.println(ee);
        }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
