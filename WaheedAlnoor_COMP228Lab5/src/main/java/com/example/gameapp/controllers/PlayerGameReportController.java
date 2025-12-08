package com.example.gameapp.controllers;

import com.example.gameapp.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PlayerGameReportController {

    @FXML private ComboBox<Player> playerCombo;
    @FXML private TableView<PlayerGameReport> reportTable;

    @FXML private TableColumn<PlayerGameReport, String> colPlayer;
    @FXML private TableColumn<PlayerGameReport, String> colGame;
    @FXML private TableColumn<PlayerGameReport, String> colDate;
    @FXML private TableColumn<PlayerGameReport, Integer> colScore;

    private PlayerDAO playerDAO = new PlayerDAO();
    private ReportDAO reportDAO = new ReportDAO();

    @FXML
    public void initialize() {
        try {
            // Load players in combo
            playerCombo.getItems().addAll(playerDAO.getAllPlayers());

            // Setup table columns
            colPlayer.setCellValueFactory(new PropertyValueFactory<>("playerName"));
            colGame.setCellValueFactory(new PropertyValueFactory<>("gameTitle"));
            colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
            colScore.setCellValueFactory(new PropertyValueFactory<>("score"));

            // When player selected → load report
            playerCombo.setOnAction(e -> loadReport());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadReport() {
        try {
            Player selected = playerCombo.getValue();
            if (selected == null) return;

            var data = reportDAO.getReportByPlayer(selected.getPlayerId());
            reportTable.setItems(FXCollections.observableArrayList(data));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onBack(javafx.event.ActionEvent e) {
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        SceneLoader.load(stage, "/com/example/gameapp/views/main-menu.fxml", "Main Menu");
    }
}
