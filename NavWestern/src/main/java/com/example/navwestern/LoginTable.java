package com.example.navwestern;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LoginTable {

    static File FILE = new File("src/main/userAccounts.json");
    static JSONArray credentialArray = new JSONArray();
    public static String LoggedInUser = null;

    public static String LoggedInFirstname = null;


    public static void parseJSON() {
        /** Create parse object. */
        JSONParser parser = new JSONParser();
        // Parse the file and put data in buildings JSONArray.
        try{
            Object obj = parser.parse(new FileReader(FILE));
            credentialArray = (JSONArray) obj;
        }catch (ParseException | IOException e){
            e.printStackTrace();
        }
    }

    public static boolean usernameExists(String username) {
        parseJSON();
        for(int i = 0; i < credentialArray.size(); i++){
            if(credentialArray.get(i) instanceof JSONObject){
                JSONObject jsonobject = (JSONObject) credentialArray.get(i);
                String key = (String) jsonobject.get("Username");

                if(key.toLowerCase().equals(username.toLowerCase())){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isUser(String username, String hashedPass){
        parseJSON();
        for(int i = 0; i < credentialArray.size(); i++){
            if(credentialArray.get(i) instanceof JSONObject){
                JSONObject jsonobject = (JSONObject) credentialArray.get(i);
                String key = (String) jsonobject.get("Username");
                if(key.toLowerCase().equals(username.toLowerCase())){
                    String pass = (String) jsonobject.get("Password");
                    if(pass.equals(hashedPass)){
                        LoggedInUser = (String) jsonobject.get("Username");
                        LoggedInFirstname = (String) jsonobject.get("Firstname");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void changeScene(ActionEvent event, String fxmlFile, String title, String username){
        Parent root = null;
        LoggedInUser = username;
        FXMLLoader loader = new FXMLLoader(LoginTable.class.getResource(fxmlFile));
        try{
            root = FXMLLoader.load(LoginTable.class.getResource(fxmlFile));
        } catch(IOException e){
            e.printStackTrace();
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 1280, 800));
        stage.show();

    }



    public static void createNewUserJson(String firstname, String username, String password) {
    }
}
