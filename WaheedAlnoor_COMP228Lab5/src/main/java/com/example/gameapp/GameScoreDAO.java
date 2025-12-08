package com.example.gameapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class GameScoreDAO {

    public void insertScore(int playerId, int gameId, int score, LocalDate date) throws Exception {
        String sql = """
            INSERT INTO PlayerAndGame (player_id, game_id, playing_date, score)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, playerId);
            ps.setInt(2, gameId);
            ps.setObject(3, date); // Supabase accepts LocalDate
            ps.setInt(4, score);

            ps.executeUpdate();
        }
    }
}
