package dao;

import database.DatabaseConnection;
import model.Pemeriksaan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PemeriksaanDAO {

    private Connection conn;

    public PemeriksaanDAO() {
        conn = DatabaseConnection.getConnection();
    }

    // Tambah Pemeriksaan
    public void tambahPemeriksaan(Pemeriksaan p) {

        String sql = "CALL sp_tambah_pemeriksaan(?,?,?,?)";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, p.getIdPasien());
            ps.setString(2, p.getKeluhan());
            ps.setInt(3, p.getBiaya());
            ps.setString(4, p.getTanggal());

            ps.executeUpdate();

            System.out.println("Data pemeriksaan berhasil ditambahkan.");

        } catch (SQLException e) {

            System.out.println("Gagal menambahkan data pemeriksaan!");
            System.out.println(e.getMessage());

        }
    }

    // Tampilkan Pemeriksaan
    public void tampilPemeriksaan() {

        String sql = "SELECT * FROM vw_data_pemeriksaan";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== DATA PEMERIKSAAN =====");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id_periksa")
                                + " | "
                                + rs.getString("nama_pasien")
                                + " | "
                                + rs.getString("keluhan")
                                + " | "
                                + rs.getInt("biaya")
                                + " | "
                                + rs.getString("tanggal"));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}