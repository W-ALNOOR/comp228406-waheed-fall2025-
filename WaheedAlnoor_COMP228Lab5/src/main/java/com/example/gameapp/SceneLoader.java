package com.example.gameapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneLoader {

    public static void load(Stage stage, String fxmlFile, String title) {
        try {
            Parent root = FXMLLoader.load(SceneLoader.class.getResource(fxmlFile));
            Scene scene = new Scene(root);
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
