import belanja.*;
import java.util.ArrayList;

public class MainBelanja {
    public static void main(String[] args) {
        ArrayList<BarangBelanja> keranjang = new ArrayList<>();

        Makanan snack = new Makanan("B001", "Taro", 8000);
        ItemBelanja<String> sabun = new ItemBelanja<>("A001", "Sabun Mandi", 10000, "Kebutuhan Rumah");

        keranjang.add(snack);
        keranjang.add(sabun);

        System.out.println("=== Keranjang Belanja ===");
        int total = 0;
        for (BarangBelanja b : keranjang) {
            b.info();
            total += b.getHarga();
        }

        int hargaSabunDiskon = sabun.hitungDiskon(sabun.getHarga());
        int totalSetelahDiskon = snack.getHarga() + hargaSabunDiskon;

        System.out.println("\nTotal Harga Sebelum Diskon : Rp" + total);
        System.out.println("Harga Sabun Setelah Diskon : Rp" + hargaSabunDiskon);
        System.out.println("Total Harga Setelah Diskon : Rp" + totalSetelahDiskon);
    }
}