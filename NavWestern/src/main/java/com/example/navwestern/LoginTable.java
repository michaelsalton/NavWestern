package com.example.navwestern;

import org.json.simple.JSONArray;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LoginTable {
    private ArrayList<User> userList = new ArrayList<>();

    LoginTable() {
        userList.add(new User("Michael", "password"));
    }

    public String getColumnName(int column) {
        if (column==0) return "username";
        if (column==1) return "password";
        throw new IllegalStateException();
    }

    public int getColumnCount() {
        return 2;
    }

    public int getRowCount() {
        return userList.size();
    }

    public Object getValueAt(int row, int column) {
        User user = userList.get(row);
        if (column==0) return user.getUsername();
        if (column==1) return user.getPassword();
        throw new IllegalStateException();
    }

    void addUser(User user) {
        userList.add(user);
        //fireTableDateChanged();

    }

    private Path setDefaultPath() {
        String home = System.getProperty("user.home");
        return Paths.get(home).resolve("userData.json");
    }

    void save() {
        save(setDefaultPath());
    }

    void save(Path path) {
        JSONArray ja = new JSONArray();
        for (User user : userList) {
            ja.add(user.toJSONObject());
        }
        //String jsonText = Jsoner.serialize(ja); // convert json array to text
        //Files.write(path, jsonText, StandardOpenOption.CREATE);
    }


    static File FILE = new File("src/main/userAccounts.json");

    static JSONArray credentialArray = new JSONArray();

}
