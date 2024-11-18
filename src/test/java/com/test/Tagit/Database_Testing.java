package com.test.Tagit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database_Testing {

    private static final String URL = "jdbc:mysql://apollo2.humanbrain.in:3306/HBA_V2";
    private static final String USER = "root";
    private static final String PASSWORD = "Health#123";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found.");
            e.printStackTrace();
            return;
        }

        String query = "SELECT sb.arrival_date, s.jp2Path "
                     + "FROM slidebatch sb "
                     + "JOIN slide s ON sb.id = s.slidebatch "
                     + "WHERE sb.arrival_date > '2024-08-01' "
                     + "AND s.jp2Path NOT LIKE '%ddn/storageIIT/humanbrain/analytics%'";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            boolean testCaseFailed = false;

            while (rs.next()) {
                String arrivalDate = rs.getString("arrival_date");
                String jp2Path = rs.getString("jp2Path");
                System.out.println("Failing Record: Arrival Date = " + arrivalDate + ", JP2 Path = " + jp2Path);
                testCaseFailed = true;
            }

            if (testCaseFailed) {
                System.out.println("Test Case Failed: Some jp2Path values do not match the expected pattern.");
            } else {
                System.out.println("Test Case Passed: All jp2Path values match the expected pattern.");
            }

        } catch (SQLException e) {
            System.err.println("Database query error.");
            e.printStackTrace();
        }
    }
}
