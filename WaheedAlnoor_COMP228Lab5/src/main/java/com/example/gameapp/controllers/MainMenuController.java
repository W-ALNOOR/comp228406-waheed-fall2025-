package com.example.gameapp.controllers;

import com.example.gameapp.SceneLoader;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class MainMenuController {

    private Stage getStage(Node node) {
        return (Stage) node.getScene().getWindow();
    }

    @FXML
    private void openAddPlayer(javafx.event.ActionEvent e) {
        SceneLoader.load(
                getStage((Node)e.getSource()),
                "/com/example/gameapp/views/add-player.fxml",
                "Add Player"
        );
    }

    @FXML
    private void openUpdatePlayer(javafx.event.ActionEvent e) {
        SceneLoader.load(
                getStage((Node)e.getSource()),
                "/com/example/gameapp/views/update-player.fxml",
                "Update Player"
        );
    }

    @FXML
    private void openAddGameScore(javafx.event.ActionEvent e) {
        SceneLoader.load(
                getStage((Node)e.getSource()),
                "/com/example/gameapp/views/add-game-score.fxml",
                "Add Game Score"
        );
    }

    @FXML
    private void openReport(javafx.event.ActionEvent e) {
        SceneLoader.load(
                getStage((Node)e.getSource()),
                "/com/example/gameapp/views/player-game-report.fxml",
                "Player Game Report"
        );
    }
}
