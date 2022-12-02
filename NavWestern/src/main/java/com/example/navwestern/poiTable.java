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

public class poiTable {

    static File FILE = new File("src/main/poiData.json");
    static JSONArray credentialArray = new JSONArray();

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

    public static void createNewPOIJson(String building, String floor, String name, String description, double x, double y) throws IOException {
        parseJSON();
        JSONObject newPOI = new JSONObject();
        newPOI.put("building", building);
        newPOI.put("floor", floor);
        newPOI.put("type", "Custom POI");
        newPOI.put("name", name);
        newPOI.put("description", description);
        newPOI.put("x", x);
        newPOI.put("y", y);

        credentialArray.add(newPOI);
        System.out.println(credentialArray);
        FileWriter file = new FileWriter(FILE);
        file.write(credentialArray.toJSONString());
        file.flush();
        file.close();

    }
}
