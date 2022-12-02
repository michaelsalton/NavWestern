module com.example.navwestern {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;


    opens com.example.navwestern to javafx.fxml;
    exports com.example.navwestern;
}