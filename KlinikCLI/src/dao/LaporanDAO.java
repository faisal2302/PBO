package dao;

import database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LaporanDAO {

    private Connection conn;

    public LaporanDAO() {
        conn = DatabaseConnection.getConnection();
    }

    // Menampilkan riwayat pemeriksaan
    public void tampilRiwayat() {
        String sql = "SELECT * FROM vw_data_pemeriksaan";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== RIWAYAT PEMERIKSAAN =====");
            System.out.println("ID | Nama Pasien | Jenis Pasien | Keluhan | Biaya | Tanggal");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id_periksa") + " | "
                        + rs.getString("nama_pasien") + " | "
                        + rs.getString("jenis_pasien") + " | "
                        + rs.getString("keluhan") + " | "
                        + rs.getInt("biaya") + " | "
                        + rs.getDate("tanggal")
                );
            }

        } catch (SQLException e) {
            System.out.println("Gagal menampilkan riwayat.");
            System.out.println(e.getMessage());
        }
    }

    // Menampilkan total pendapatan
    public void tampilTotalPendapatan() {
        String sql = "SELECT fn_total_pendapatan() AS total";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("\n===== TOTAL PENDAPATAN =====");
                System.out.println("Rp " + rs.getInt("total"));
            }

        } catch (SQLException e) {
            System.out.println("Gagal mengambil total pendapatan.");
            System.out.println(e.getMessage());
        }
    }
}