package com.example.gameapp.controllers;

import com.example.gameapp.SceneLoader;
import javafx.scene.Node;
import javafx.stage.Stage;
import com.example.gameapp.Player;
import com.example.gameapp.PlayerDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddPlayerController {

    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField addressField;
    @FXML private TextField postalCodeField;
    @FXML private TextField provinceField;
    @FXML private TextField phoneField;
    @FXML private Label statusLabel;



    @FXML
    private void onSavePlayer() {
        try {
            Player p = new Player(
                    firstNameField.getText(),
                    lastNameField.getText(),
                    addressField.getText(),
                    postalCodeField.getText(),
                    provinceField.getText(),
                    phoneField.getText()
            );

            new PlayerDAO().insertPlayer(p);

            statusLabel.setText("Player saved successfully!");

            // Clear form
            firstNameField.clear();
            lastNameField.clear();
            addressField.clear();
            postalCodeField.clear();
            provinceField.clear();
            phoneField.clear();

        } catch (Exception e) {
            e.printStackTrace();
            statusLabel.setText("Error: " + e.getMessage());
        }
    }

    @FXML
    private void onBack(javafx.event.ActionEvent e) {
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        SceneLoader.load(stage, "/com/example/gameapp/views/main-menu.fxml", "Main Menu");
    }


}
