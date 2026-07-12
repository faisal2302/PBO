package model;

public class Pemeriksaan {

    private int idPeriksa;
    private int idPasien;
    private String keluhan;
    private int biaya;
    private String tanggal;

    public Pemeriksaan() {
    }

    public Pemeriksaan(int idPeriksa, int idPasien, String keluhan, int biaya, String tanggal) {
        this.idPeriksa = idPeriksa;
        this.idPasien = idPasien;
        this.keluhan = keluhan;
        this.biaya = biaya;
        this.tanggal = tanggal;
    }

    public int getIdPeriksa() {
        return idPeriksa;
    }

    public void setIdPeriksa(int idPeriksa) {
        this.idPeriksa = idPeriksa;
    }

    public int getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(int idPasien) {
        this.idPasien = idPasien;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public int getBiaya() {
        return biaya;
    }

    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

}