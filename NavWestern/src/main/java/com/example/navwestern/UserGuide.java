/**
 *
 * this file is the controller for the user guide screen
 *
 *
 * UserGuide.java
 * @author  Michael Salton
 * @version 2.077
 * @since   2022-11-08
 */

package com.example.navwestern;

import javafx.event.ActionEvent;


import java.io.IOException;

public class UserGuide {

    /**
     * loads user create poi screen on button click
     *
     * @param  e    ActionEvent
     */
    public void CreatePOIButtonOnAction(ActionEvent e) throws IOException {
        Main m = new Main();
        m.changeScene("user_create_poi.fxml");
    }

    /**
     * loads home screen on button click
     *
     * @param  e    ActionEvent
     */
    public void HomeButtonOnAction(ActionEvent e) throws IOException {
        Main m = new Main();
        m.changeScene("home_page.fxml");
    }

    /**
     * does nothing
     *
     * @param  e    ActionEvent
     */
    public void UserGuideButtonOnAction(ActionEvent e) throws IOException {

    }


}
