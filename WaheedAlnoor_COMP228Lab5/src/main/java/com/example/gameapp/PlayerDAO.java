package com.example.gameapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {

    // INSERT PLAYER
    public void insertPlayer(Player p) throws SQLException {
        String sql = "INSERT INTO Player (first_name, last_name, address, postal_code, province, phone_number) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getFirstName());
            ps.setString(2, p.getLastName());
            ps.setString(3, p.getAddress());
            ps.setString(4, p.getPostalCode());
            ps.setString(5, p.getProvince());
            ps.setString(6, p.getPhone());

            ps.executeUpdate();
        }
    }

    // UPDATE PLAYER
    public void updatePlayer(Player p) throws SQLException {
        String sql = "UPDATE Player SET first_name=?, last_name=?, address=?, postal_code=?, province=?, phone_number=? WHERE player_id=?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getFirstName());
            ps.setString(2, p.getLastName());
            ps.setString(3, p.getAddress());
            ps.setString(4, p.getPostalCode());
            ps.setString(5, p.getProvince());
            ps.setString(6, p.getPhone());
            ps.setInt(7, p.getPlayerId());

            ps.executeUpdate();
        }
    }

    // LOAD ALL PLAYERS
    public List<Player> getAllPlayers() throws SQLException {
        String sql = "SELECT * FROM Player";
        List<Player> list = new ArrayList<>();

        try (Connection conn = DBUtil.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Player(
                        rs.getInt("player_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getString("postal_code"),
                        rs.getString("province"),
                        rs.getString("phone_number")
                ));
            }
        }
        return list;
    }
}
