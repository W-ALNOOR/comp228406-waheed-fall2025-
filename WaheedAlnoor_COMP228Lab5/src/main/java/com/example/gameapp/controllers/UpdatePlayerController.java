package com.example.gameapp.controllers;

import com.example.gameapp.Player;
import com.example.gameapp.PlayerDAO;
import com.example.gameapp.SceneLoader;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdatePlayerController {

    @FXML private ComboBox<Player> playerCombo;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField addressField;
    @FXML private TextField postalCodeField;
    @FXML private TextField provinceField;
    @FXML private TextField phoneField;
    @FXML private Label statusLabel;

    private PlayerDAO dao = new PlayerDAO();

    @FXML
    public void initialize() {
        try {
            // Load all players into combo box
            playerCombo.getItems().addAll(dao.getAllPlayers());

            // Display player's name in dropdown
            playerCombo.setCellFactory(param -> new javafx.scene.control.ListCell<>() {
                @Override
                protected void updateItem(Player p, boolean empty) {
                    super.updateItem(p, empty);
                    if (empty || p == null) {
                        setText(null);
                    } else {
                        setText(p.getFirstName() + " " + p.getLastName());
                    }
                }
            });

            playerCombo.setButtonCell(new javafx.scene.control.ListCell<>() {
                @Override
                protected void updateItem(Player p, boolean empty) {
                    super.updateItem(p, empty);
                    if (empty || p == null) {
                        setText("Select Player");
                    } else {
                        setText(p.getFirstName() + " " + p.getLastName());
                    }
                }
            });

            // Fill fields when a player is selected
            playerCombo.setOnAction(e -> loadPlayerDetails());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadPlayerDetails() {
        Player p = playerCombo.getValue();
        if (p == null) return;

        firstNameField.setText(p.getFirstName());
        lastNameField.setText(p.getLastName());
        addressField.setText(p.getAddress());
        postalCodeField.setText(p.getPostalCode());
        provinceField.setText(p.getProvince());
        phoneField.setText(p.getPhone());
    }

    @FXML
    private void updatePlayer() {
        try {
            Player selected = playerCombo.getValue();
            if (selected == null) {
                statusLabel.setText("Please select a player.");
                return;
            }

            Player updated = new Player(
                    selected.getPlayerId(),
                    firstNameField.getText(),
                    lastNameField.getText(),
                    addressField.getText(),
                    postalCodeField.getText(),
                    provinceField.getText(),
                    phoneField.getText()
            );

            dao.updatePlayer(updated);

            statusLabel.setText("Player updated successfully!");

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
