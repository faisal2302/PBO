class BankBNI extends Bank {

    @Override
    void sukuBunga() {
        System.out.println("Suku bunga Bank BNI adalah 4%");
    }

    @Override
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        int biayaAdmin = 4000;
        int total = jumlah + biayaAdmin;

        System.out.println("Transfer " + jumlah + " ke rekening " + rekeningTujuan +
                " di bank " + bankTujuan + " (BNI)");
        System.out.println("Biaya Admin: " + biayaAdmin);
        System.out.println("Total Saldo Terpotong: " + total);
    }
}