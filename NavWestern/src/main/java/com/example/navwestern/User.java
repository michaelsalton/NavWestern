package com.example.navwestern;

import org.json.simple.JSONObject;

public class User {
    private String username;
    private String password;

    User(String username, String password) {
        this.username=username;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public JSONObject toJSONObject() {
        JSONObject jo = new JSONObject();
        jo.put("username", username);
        jo.put("password", password);
        return jo;
    }
}
