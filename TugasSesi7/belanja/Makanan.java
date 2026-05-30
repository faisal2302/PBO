package belanja;

public class Makanan extends ItemBelanja<String> {
    public Makanan(String kode, String nama, int harga) {
        super(kode, nama, harga, "Makanan");
    }

    @Override
    public void info() {
        System.out.println("[Makanan] " + getKode() + " - " + getNama() + " : Rp" + getHarga());
    }
}