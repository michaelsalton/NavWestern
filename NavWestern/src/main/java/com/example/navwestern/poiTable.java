package com.example.navwestern;

import java.io.IOException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;

import javafx.scene.control.Button;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class poiTable {

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
        //System.out.print(poiArray.size());
    }

    public static void createNewPOIJson(String building, String floor, String name, String type, String description, double x, double y) throws IOException {
        parseJSON();
        JSONObject newPOI = new JSONObject();
        newPOI.put("building", building);
        newPOI.put("floor", floor);
        newPOI.put("type", "Custom POI");
        newPOI.put("name", name);
        newPOI.put("description", description);
        newPOI.put("x", x);
        newPOI.put("y", y);

        poiArray.add(newPOI);
        System.out.println(poiArray);
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
                            System.out.println(typeKey);
                            double xKey = (double) jsonobject.get("x");
                            double yKey = (double) jsonobject.get("y");
                            System.out.println(xKey);
                            button.setTranslateX(xKey);
                            button.setTranslateY(yKey);
                        }
                    }
                }
            }
            buttonsArray = addX(buttonsArray.length, buttonsArray, button);
            //System.out.println(buttonsArray);
        }
        return  buttonsArray;
    }
    public static Button[] addX(int n, Button[] buttonsArray, Button x)
    {
        int i;
        // create a new array of size n+1
        Button[] newButtonsArray = new Button[n + 1];
        // insert the elements from
        // the old array into the new array
        // insert all elements till n
        // then insert x at n+1
        for (i = 0; i < n; i++){
            newButtonsArray[i] = buttonsArray[i];
        }
        newButtonsArray[n] = x;
        return newButtonsArray;
    }






}
