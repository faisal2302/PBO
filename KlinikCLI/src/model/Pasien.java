package model;

public class Pasien {

    private int idPasien;
    private String nama;
    private String alamat;
    private String jenisPasien;

    public Pasien() {
    }

    public Pasien(int idPasien, String nama, String alamat, String jenisPasien) {
        this.idPasien = idPasien;
        this.nama = nama;
        this.alamat = alamat;
        this.jenisPasien = jenisPasien;
    }

    public int getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(int idPasien) {
        this.idPasien = idPasien;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenisPasien() {
        return jenisPasien;
    }

    public void setJenisPasien(String jenisPasien) {
        this.jenisPasien = jenisPasien;
    }

    public int hitungBiaya(int biaya) {

        return biaya;

    }
}