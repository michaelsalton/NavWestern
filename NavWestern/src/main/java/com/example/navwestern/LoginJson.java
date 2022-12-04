package com.example.navwestern;

import java.io.IOException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LoginJson {
    static File FILE = new File("src/main/userAccounts.json");
    static JSONArray credentialArray = new JSONArray();
    public static String LoggedInUser = null;
    public static String LoggedInFirstname = null;
    public static boolean userIsAdmin = false;

    /**
     * parses the json file
     */
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

    /**
     * checks if the username is in the database
     *
     * @param  username username
     */
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

    /**
     * checks if the usernme and password entered match
     *
     * @param  username username
     * @param hashedPass password
     */
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

    /**
     * creates a new user account and adds it to the json file
     *
     * @param  name name of the user
     * @param username  username of the user
     * @param password password of the user
     */
    public static void createNewUserJson(String name, String username, String password) throws IOException {
        parseJSON();
        JSONObject newUser = new JSONObject();
        newUser.put("name", name);
        newUser.put("username", username);
        password = encrypt(password);
        newUser.put("password", password);
        newUser.put("admin", "false");

        credentialArray.add(newUser);
        System.out.println(credentialArray);
        FileWriter file = new FileWriter(FILE);
        file.write(credentialArray.toJSONString());
        file.flush();
        file.close();

        LoggedInUser = username;
        LoggedInFirstname = name;
    }

    /**
     * encrypts the users password and stores it in the database
     *
     * @param  password users password
     */
    public static String encrypt(String password) {
        try {
            MessageDigest msgDigest = null;
            msgDigest = MessageDigest.getInstance("SHA-256");
            byte[] msg = msgDigest.digest(password.getBytes());
            BigInteger bigInt = new BigInteger(1, msg);
            String encryptedPassword = bigInt.toString(16);
            while (encryptedPassword.length() < 32) {
                encryptedPassword = "0" + encryptedPassword;
            }
            return encryptedPassword;
        }

        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
