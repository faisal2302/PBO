package belanja;

public class ItemBelanja<T> extends BarangBelanja implements Diskon {
    private T kategori;

    public ItemBelanja(String kode, String nama, int harga, T kategori) {
        super(kode, nama, harga);
        this.kategori = kategori;
    }

    public T getKategori() { return kategori; }

    @Override
    public void info() {
        System.out.println(getKode() + " - " + getNama() + " (" + kategori + ") : Rp" + getHarga());
    }

    @Override
    public int hitungDiskon(int harga) {
        return harga - (harga * 5 / 100); // diskon 5%
    }
}