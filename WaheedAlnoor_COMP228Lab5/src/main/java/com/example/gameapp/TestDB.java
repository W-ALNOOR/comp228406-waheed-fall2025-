package com.example.gameapp;

import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        try (Connection conn = DBUtil.getConnection()) {
            System.out.println("Connected to Supabase successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
