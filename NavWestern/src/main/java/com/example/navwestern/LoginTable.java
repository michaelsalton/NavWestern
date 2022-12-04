package com.example.navwestern;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LoginTable {
    static File FILE = new File("src/main/userAccounts.json");
    static JSONArray credentialArray = new JSONArray();
    public static String LoggedInUser = null;
    public static String LoggedInFirstname = null;
    public static boolean userIsAdmin = false;
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
                String key = (String) jsonobject.get("username");

                if(key.equalsIgnoreCase(username)){
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
                String key = (String) jsonobject.get("username");
                if(key.equalsIgnoreCase(username)){
                    String pass = (String) jsonobject.get("password");
                    if(pass.equals(hashedPass)){
                        LoggedInUser = (String) jsonobject.get("username");
                        LoggedInFirstname = (String) jsonobject.get("name");
                        String adminKey = (String) jsonobject.get("admin");
                        if (adminKey.equals("true")) {
                            userIsAdmin = true;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void createNewUserJson(String name, String username, String password) throws IOException {
        parseJSON();
        JSONObject newUser = new JSONObject();
        newUser.put("name", name);
        newUser.put("username", username);
        newUser.put("password", password);

        credentialArray.add(newUser);
        System.out.println(credentialArray);
        FileWriter file = new FileWriter(FILE);
        file.write(credentialArray.toJSONString());
        file.flush();
        file.close();

        LoggedInUser = username;
        LoggedInFirstname = name;
    }
}
