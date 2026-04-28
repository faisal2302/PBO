class BankBCA extends Bank {

    @Override
    void sukuBunga() {
        System.out.println("Suku bunga Bank BCA adalah 4.5%");
    }

    @Override
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        int biayaAdmin = 5000; 
        int total = jumlah + biayaAdmin;
        
        System.out.println("Transfer " + jumlah + " ke rekening " + rekeningTujuan + 
                           " di bank " + bankTujuan + " (BCA)");
        System.out.println("Biaya Admin: " + biayaAdmin);
        System.out.println("Total Saldo Terpotong: " + total);
    }
}