package main;

import java.util.Scanner;

import dao.PasienDAO;
import dao.PemeriksaanDAO;
import dao.LaporanDAO;
import model.Pasien;
import model.Pemeriksaan;
import exception.InputKosongException;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        PasienDAO pasienDAO = new PasienDAO();
        PemeriksaanDAO pemeriksaanDAO = new PemeriksaanDAO();
        LaporanDAO laporanDAO = new LaporanDAO();

        int pilihan;

        do {

            System.out.println("\n==============================");
            System.out.println("      APLIKASI KLINIK");
            System.out.println("==============================");
            System.out.println("1. Menu Pasien");
            System.out.println("2. Menu Pemeriksaan");
            System.out.println("3. Menu Laporan");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu : ");

            pilihan = input.nextInt();

            switch (pilihan) {

                case 1:

                    int pilihPasien;

                    do {

                        System.out.println("\n===== MENU PASIEN =====");
                        System.out.println("1. Tambah Pasien");
                        System.out.println("2. Lihat Data Pasien");
                        System.out.println("0. Kembali");
                        System.out.print("Pilih Menu : ");

                        pilihPasien = input.nextInt();
                        input.nextLine();

                        switch (pilihPasien) {

                            case 1:

                                try {

                                    Pasien pasien = new Pasien();

                                    System.out.print("Nama Pasien : ");
                                    String nama = input.nextLine();

                                    if (nama.isEmpty()) {
                                        throw new InputKosongException("Nama pasien tidak boleh kosong!");
                                    }

                                    pasien.setNama(nama);

                                    System.out.print("Alamat : ");
                                    pasien.setAlamat(input.nextLine());

                                    System.out.print("Jenis Pasien (Umum/BPJS) : ");
                                    pasien.setJenisPasien(input.nextLine());

                                    pasienDAO.tambahPasien(pasien);

                                } catch (InputKosongException e) {

                                    System.out.println(e.getMessage());

                                }

                                break;

                            case 2:

                                pasienDAO.tampilPasien();

                                break;

                            default:

                                System.out.println("Pilihan tidak tersedia.");

                        }

                    } while (pilihPasien != 0);

                    break;

                case 2:

                    int pilihPeriksa;

                    do {

                        System.out.println("\n===== MENU PEMERIKSAAN =====");
                        System.out.println("1. Tambah Pemeriksaan");
                        System.out.println("2. Lihat Data Pemeriksaan");
                        System.out.println("0. Kembali");
                        System.out.print("Pilih Menu : ");

                        pilihPeriksa = input.nextInt();
                        input.nextLine();

                        switch (pilihPeriksa) {

                            case 1:

                                Pemeriksaan periksa = new Pemeriksaan();

                                System.out.print("ID Pasien : ");
                                periksa.setIdPasien(input.nextInt());
                                input.nextLine();

                                System.out.print("Keluhan : ");
                                periksa.setKeluhan(input.nextLine());

                                System.out.print("Biaya : ");
                                periksa.setBiaya(input.nextInt());
                                input.nextLine();

                                System.out.print("Tanggal (YYYY-MM-DD) : ");
                                periksa.setTanggal(input.nextLine());

                                pemeriksaanDAO.tambahPemeriksaan(periksa);

                                break;

                            case 2:

                                pemeriksaanDAO.tampilPemeriksaan();

                                break;

                            default:

                                System.out.println("Pilihan tidak tersedia.");

                        }

                    } while (pilihPeriksa != 0);

                    break;
                case 3:

                    int pilihLaporan;

                    do {

                        System.out.println("\n===== MENU LAPORAN =====");
                        System.out.println("1. Lihat Riwayat Pemeriksaan");
                        System.out.println("2. Lihat Total Pendapatan");
                        System.out.println("0. Kembali");
                        System.out.print("Pilih Menu : ");

                        pilihLaporan = input.nextInt();
                        input.nextLine();

                        switch (pilihLaporan) {

                            case 1:

                                laporanDAO.tampilRiwayat();

                                break;

                            case 2:

                                laporanDAO.tampilTotalPendapatan();

                                break;

                            case 0:

                                System.out.println("Kembali ke menu utama...");
                                break;

                            default:

                                System.out.println("Pilihan tidak tersedia.");

                        }

                    } while (pilihLaporan != 0);

                    break;

                case 0:
                    System.out.println("\nTerima kasih...");
                    break;

                default:
                    System.out.println("Menu tidak tersedia!");

            }

        } while (pilihan != 0);

        input.close();
    }

}