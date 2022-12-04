/**
 *
 * this application is a tool to navigate the Western buildings.
 *
 *
 * Main.java
 * @author  Michael Salton, Taimur Sikander
 * @version 2.077
 * @since   2022-11-08
 */

package com.example.navwestern;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    private static Stage stage;

    /**
     * loads and shows fxml file
     *
     * @param  primaryStage stage holding scene
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("home_page.fxml"));
        primaryStage.setScene(new Scene(root, 850, 480));
        primaryStage.setTitle("NavWestern");
        primaryStage.show();
    }

    /**
     * changes screens
     *
     * @param  fxml fxml file
     */
    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stage.getScene().setRoot(pane);
    }

    /**
     * launches the program
     *
     * @param  args ActionEvent
     */
    public static void main(String[] args) {
        launch();
    }
}