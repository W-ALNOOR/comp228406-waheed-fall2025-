package com.example.gameapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReportDAO {

    public List<PlayerGameReport> getReportByPlayer(int playerId) throws Exception {
        List<PlayerGameReport> list = new ArrayList<>();

        String sql = """
            SELECT 
                p.first_name || ' ' || p.last_name AS player_name,
                g.game_title,
                pg.playing_date,
                pg.score
            FROM PlayerAndGame pg
            JOIN Player p ON pg.player_id = p.player_id
            JOIN Game g ON pg.game_id = g.game_id
            WHERE p.player_id = ?
            ORDER BY pg.playing_date DESC;
        """;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, playerId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new PlayerGameReport(
                        rs.getString("player_name"),
                        rs.getString("game_title"),
                        rs.getDate("playing_date").toLocalDate(),
                        rs.getInt("score")
                ));
            }
        }
        return list;
    }
}
