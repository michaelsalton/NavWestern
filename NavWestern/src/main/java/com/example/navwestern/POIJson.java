/**
 *
 * this file includes all the functions to read and write to the poi json database
 *
 *
 * POIJson.java
 * @author  Michael Salton
 * @version 2.077
 * @since   2022-11-08
 */

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

    /**
     * parses the json metadata file
     */
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

    /**
     * adds a new poi to the json file
     *
     * @param  building name of selected building
     * @param floor name of selected floor
     * @param name  name of poi
     * @param type  type of poi
     * @param description   description of poi
     * @param user  user who created the poi
     * @param x    x coordinate of poi
     * @param y y coordinate of poi
     */
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

    /**
     * returns an array of buttons relating to each poi being toggled
     *
     * @param  building name of selected building
     * @param floor name of selected floor
     * @param type  type of poi
     * @return Button[]
     */
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

    /**
     * returns an array of buttons relating to each poi being toggled
     *
     * @param  building name of selected building
     * @param floor name of selected floor
     * @param type  type of poi
     * @param user user who created the poi
     * @return Button[]
     */
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

    /**
     * adds a button to the button array
     *
     * @param  n    number of elements
     * @param buttonsArray array of buttons
     * @param x button being added
     * @return Button[]
     */
    public static Button[] addX(int n, Button[] buttonsArray, Button x) {
        int i;
        Button[] newButtonsArray = new Button[n + 1];
        for (i = 0; i < n; i++) {
            newButtonsArray[i] = buttonsArray[i];
        }
        newButtonsArray[n] = x;
        return newButtonsArray;
    }

    /**
     * returns a stack conating all the related search results to the users search
     *
     * @param  search   users search text
     * @return Stack
     */
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
                    String buildingKey = (String) jsonobject.get("building");
                    String floorKey = (String) jsonobject.get("floor");
                    String typeKey = (String) jsonobject.get("type");
                    resultsStack.push(search + " | " + typeKey + " | " + buildingKey + " | " + floorKey);
                    System.out.println(resultsStack);
                }
            }
        }
        return  resultsStack;
    }
}
