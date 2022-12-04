package com.example.navwestern;

import java.io.IOException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Stack;

import javafx.scene.control.Button;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class POIJson {
    static Button[] buttonsArray = {};
    static File FILE = new File("src/main/poiData.json");
    static JSONArray poiArray = new JSONArray();
    public static void parseJSON() {
        /** Create parse object. */
        JSONParser parser = new JSONParser();
        // Parse the file and put data in buildings JSONArray.
        try{
            Object obj = parser.parse(new FileReader(FILE));
            poiArray = (JSONArray) obj;
        }catch (ParseException | IOException e){
            e.printStackTrace();
        }
    }
    public static void createNewPOIJson(String building, String floor, String name, String type, String description, String user, double x, double y) throws IOException {
        parseJSON();
        JSONObject newPOI = new JSONObject();
        newPOI.put("building", building);
        newPOI.put("floor", floor);
        newPOI.put("type", "Custom POI");
        newPOI.put("name", name);
        newPOI.put("description", description);
        newPOI.put("user", user);
        newPOI.put("x", x);
        newPOI.put("y", y);

        poiArray.add(newPOI);
        FileWriter file = new FileWriter(FILE);
        file.write(poiArray.toJSONString());
        file.flush();
        file.close();
    }
    public static Button[] togglePOI(String building, String floor, String type) throws IOException {
        parseJSON();
        for (int i = 0; i < poiArray.size(); i++) {
            Button button = new Button();
            if (poiArray.get(i) instanceof JSONObject) {
                JSONObject jsonobject = (JSONObject) poiArray.get(i);
                String buildingKey = (String) jsonobject.get("building");
                if(buildingKey.equals(building)){
                    String floorKey = (String) jsonobject.get("floor");
                    if(floorKey.equals(floor)){
                        String typeKey = (String) jsonobject.get("type");
                        if(typeKey.equals(type)){
                            double xKey = (double) jsonobject.get("x");
                            double yKey = (double) jsonobject.get("y");
                            button.setTranslateX(xKey);
                            button.setTranslateY(yKey);
                        }
                    }
                }
            }
            buttonsArray = addX(buttonsArray.length, buttonsArray, button);
        }
        return  buttonsArray;
    }
    public static Button[] toggleCustomPOI(String building, String floor, String type, String user) throws IOException {
        parseJSON();
        for (int i = 0; i < poiArray.size(); i++) {
            Button button = new Button();
            if (poiArray.get(i) instanceof JSONObject) {
                JSONObject jsonobject = (JSONObject) poiArray.get(i);
                String buildingKey = (String) jsonobject.get("building");
                if (buildingKey.equals(building)) {
                    String floorKey = (String) jsonobject.get("floor");
                    if (floorKey.equals(floor)) {
                        String typeKey = (String) jsonobject.get("type");
                        if (typeKey.equals(type)) {
                            String userKey = (String) jsonobject.get("user");
                            if (userKey.equals(user)) {
                                double xKey = (double) jsonobject.get("x");
                                double yKey = (double) jsonobject.get("y");
                                button.setTranslateX(xKey);
                                button.setTranslateY(yKey);
                            }
                        }
                    }
                }
            }
            buttonsArray = addX(buttonsArray.length, buttonsArray, button);
        }
        return buttonsArray;
    }
    public static Button[] addX(int n, Button[] buttonsArray, Button x) {
        int i;
        Button[] newButtonsArray = new Button[n + 1];
        for (i = 0; i < n; i++) {
            newButtonsArray[i] = buttonsArray[i];
        }
        newButtonsArray[n] = x;
        return newButtonsArray;
    }

    public static Stack searchPOI(String search) {
        String[] resultsArray = {};
        Stack<Object> resultsStack = new Stack<Object>();
        parseJSON();
        for (int i = 0; i < poiArray.size(); i++) {
            Button button = new Button();
            if (poiArray.get(i) instanceof JSONObject) {
                JSONObject jsonobject = (JSONObject) poiArray.get(i);
                String nameKey = (String) jsonobject.get("name");
                if (nameKey.equals(search)) {
                    resultsStack.push(poiArray.get(i));
                    String descriptionKey = (String) jsonobject.get("description");
                    if(descriptionKey.equals(search)){
                        resultsStack.push(poiArray.get(i));
                        }
                    }
                }
            }
        return  resultsStack;
        }
}
