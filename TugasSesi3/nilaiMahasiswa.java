import java.util.ArrayList;
import java.util.Scanner;

public class nilaiMahasiswa {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<mahasiswa> daftar = new ArrayList<>();

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlah = input.nextInt();
        input.nextLine();

        // INPUT
        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nData Mahasiswa ke-" + (i+1));

            System.out.print("NIM   : ");
            String nim = input.nextLine();

            System.out.print("Nama  : ");
            String nama = input.nextLine();

            System.out.print("Nilai : ");
            int nilai = input.nextInt();
            input.nextLine();

            if (nilai < 0 || nilai > 100) {
                System.out.println("Input nilai anda salah!");
                i--;
                continue;
            }

            mahasiswa m = new mahasiswa();
            m.setData(nim, nama, nilai);
            daftar.add(m);
        }

        // PROSES
        int total = 0;
        int lulus = 0, tidakLulus = 0;

        ArrayList<String> namaLulus = new ArrayList<>();
        ArrayList<String> namaTidak = new ArrayList<>();

        System.out.println("\n===== DATA MAHASISWA =====");
        for (mahasiswa m : daftar) {
            m.tampilkanData();
            total += m.getNilai();

            if (m.isLulus()) {
                lulus++;
                namaLulus.add(m.getNama());
            } else {
                tidakLulus++;
                namaTidak.add(m.getNama());
            }
        }

        double rata = (double) total / daftar.size();

        // OUTPUT
        System.out.println("Jumlah Mahasiswa : " + daftar.size());
        System.out.println("Jumlah Mahasiswa yg Lulus : " + lulus + " yaitu " + String.join(", ", namaLulus));
        System.out.println("Jumlah Mahasiswa yg Tidak Lulus : " + tidakLulus + " yaitu " + String.join(", ", namaTidak));
        System.out.println("Rata-rata nilai mahasiswa : " + rata);

        //tutup scanner
        input.close();
    }
}