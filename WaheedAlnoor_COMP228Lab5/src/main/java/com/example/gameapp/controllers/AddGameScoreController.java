package com.example.gameapp.controllers;


import com.example.gameapp.*;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddGameScoreController {

    @FXML private ComboBox<Player> playerCombo;
    @FXML private ComboBox<Game> gameCombo;
    @FXML private TextField scoreField;
    @FXML private DatePicker datePicker;
    @FXML private Label statusLabel;

    private PlayerDAO playerDAO = new PlayerDAO();
    private GameDAO gameDAO = new GameDAO();
    private GameScoreDAO scoreDAO = new GameScoreDAO();

    @FXML
    public void initialize() {
        try {
            // Load players and games from DB
            playerCombo.getItems().addAll(playerDAO.getAllPlayers());
            gameCombo.getItems().addAll(gameDAO.getAllGames());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void saveScore() {
        try {
            Player selectedPlayer = playerCombo.getValue();
            Game selectedGame = gameCombo.getValue();
            int score = Integer.parseInt(scoreField.getText());
            var date = datePicker.getValue();

            if (selectedPlayer == null || selectedGame == null || date == null) {
                statusLabel.setText("Please fill all fields.");
                return;
            }

            scoreDAO.insertScore(
                    selectedPlayer.getPlayerId(),
                    selectedGame.getGameId(),
                    score,
                    date
            );

            statusLabel.setText("Score saved successfully!");

            scoreField.clear();
            datePicker.setValue(null);

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
