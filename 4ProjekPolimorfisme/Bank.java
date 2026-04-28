class Bank {

    void transferUang(int jumlah, String rekeningTujuan) {
        int biayaAdmin = 0;
        int total = jumlah + biayaAdmin;

        System.out.println("Transfer " + jumlah + " ke rekening " + rekeningTujuan);
        System.out.println("Total saldo terpotong: " + total);
    }

    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        int biayaAdmin = 2500;
        int total = jumlah + biayaAdmin;

        System.out.println("Transfer " + jumlah + " ke rekening " + rekeningTujuan + " di bank " + bankTujuan);
        System.out.println("Biaya Admin: " + biayaAdmin + ". Total: " + total);
    }

    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
        int biayaAdmin = 2500;
        int total = jumlah + biayaAdmin;

        System.out.println("Transfer " + jumlah + " ke rekening " + rekeningTujuan +
                " di bank " + bankTujuan + " dengan berita: " + berita);
        System.out.println("Biaya Admin: " + biayaAdmin + ". Total: " + total);
    }

    void sukuBunga() {
        System.out.println("Suku bunga standar adalah 3%");
    }
}