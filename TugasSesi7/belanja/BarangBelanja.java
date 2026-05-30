package belanja;

public abstract class BarangBelanja {
    private String kode;
    private String nama;
    private int harga;

    public BarangBelanja(String kode, String nama, int harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }

    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public int getHarga() { return harga; }

    public abstract void info();
}