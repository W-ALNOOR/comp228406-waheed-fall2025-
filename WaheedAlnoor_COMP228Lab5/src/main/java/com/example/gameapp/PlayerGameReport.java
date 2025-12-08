package com.example.gameapp;

import java.time.LocalDate;

public class PlayerGameReport {
    private String playerName;
    private String gameTitle;
    private LocalDate date;
    private int score;

    public PlayerGameReport(String playerName, String gameTitle, LocalDate date, int score) {
        this.playerName = playerName;
        this.gameTitle = gameTitle;
        this.date = date;
        this.score = score;
    }

    public String getPlayerName() { return playerName; }
    public String getGameTitle() { return gameTitle; }
    public LocalDate getDate() { return date; }
    public int getScore() { return score; }
}
