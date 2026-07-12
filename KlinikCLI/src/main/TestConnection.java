package main;

import database.DatabaseConnection;
import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) {

        Connection conn = DatabaseConnection.getConnection();

        if (conn != null) {
            System.out.println("Koneksi database berhasil!");
        } else {
            System.out.println("Koneksi database gagal!");
        }

    }
}