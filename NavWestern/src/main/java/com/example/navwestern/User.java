/**
 *
 * this file contains the object User
 *
 *
 * User.java
 * @author  Michael Salton
 * @version 2.077
 * @since   2022-11-08
 */

package com.example.navwestern;

import org.json.simple.JSONObject;

public class User {
    private String name, username, password;

    User(String name, String username, String password) {
        this.name=name;
        this.username=username;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getName() { return name;}

    public JSONObject toJSONObject() {
        JSONObject jo = new JSONObject();
        jo.put("username", username);
        jo.put("password", password);
        jo.put("name", name);
        return jo;
    }
}
