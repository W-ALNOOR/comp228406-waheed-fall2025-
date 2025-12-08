module com.example.gameapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires javafx.graphics;

    opens com.example.gameapp to javafx.fxml;
    opens com.example.gameapp.controllers to javafx.fxml;
    exports com.example.gameapp;
    exports com.example.gameapp.controllers;
}
