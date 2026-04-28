public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        Bank bni = new BankBNI();
        Bank bca = new BankBCA();
        bank.transferUang(100000, "123456");
        bank.transferUang(200000, "654321", "BCA");
        bank.transferUang(300000, "111222", "BNI", "Bayar hutang");

        bank.sukuBunga();

        System.out.println("-----");

        bni.sukuBunga();
        bni.transferUang(500000, "999888", "BCA");

        System.out.println("-----");

        bca.sukuBunga();
        bca.transferUang(750000, "777666", "BNI");
    }
}