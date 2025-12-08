package com.example.gameapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDAO {

    public List<Game> getAllGames() throws Exception {
        List<Game> games = new ArrayList<>();
        String sql = "SELECT * FROM Game ORDER BY game_id";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                games.add(new Game(
                        rs.getInt("game_id"),
                        rs.getString("game_title")
                ));
            }
        }

        return games;
    }
}
