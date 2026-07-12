package model;

public class PasienBPJS extends Pasien {

    @Override
    public int hitungBiaya(int biaya) {

        return biaya / 2;
    }

    private String nomorBPJS;

    public PasienBPJS() {
    }

    public String getNomorBPJS() {
        return nomorBPJS;
    }

    public void setNomorBPJS(String nomorBPJS) {
        this.nomorBPJS = nomorBPJS;
    }

    @Override
    public String getJenisPasien() {
        return "BPJS";
    }

}