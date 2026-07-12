package dao;

import database.DatabaseConnection;
import model.Pasien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PasienDAO {

    private Connection conn;

    public PasienDAO() {
        conn = DatabaseConnection.getConnection();
    }

    // Tambah Data Pasien
    public void tambahPasien(Pasien pasien) {

        String sql = "CALL sp_tambah_pasien(?,?,?)";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, pasien.getNama());
            ps.setString(2, pasien.getAlamat());
            ps.setString(3, pasien.getJenisPasien());

            ps.executeUpdate();

            System.out.println("Data pasien berhasil ditambahkan.");

        } catch (SQLException e) {

            System.out.println("Gagal menambahkan data pasien!");
            System.out.println(e.getMessage());

        }

    }

    // Tampilkan Data Pasien
    public void tampilPasien() {

        String sql = "SELECT * FROM pasien";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== DATA PASIEN =====");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id_pasien")
                                + " | "
                                + rs.getString("nama_pasien")
                                + " | "
                                + rs.getString("alamat")
                                + " | "
                                + rs.getString("jenis_pasien"));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}