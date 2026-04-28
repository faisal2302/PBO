
import interfaces.Laptop;
import model.LaptopUser;
import model.Lenovo;
import model.MacBook; 
import model.Toshiba;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Laptop Lenovo = new Lenovo();
        Laptop MacBook = new MacBook();
        Laptop Toshiba = new Toshiba();

        // Pilih laptop
        System.out.println("Pilih laptop:");
        System.out.println("1. Lenovo");
        System.out.println("2. MacBook");
        System.out.println("3. Toshiba");
        int choice = 0;
        while (choice < 1 || choice > 3) {
            System.out.print("Masukkan pilihan (1-3): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (choice < 1 || choice > 3) {
                    System.out.println("Pilihan harus antara 1-3.");
                }
            } else {
                System.out.println("Input harus angka. Coba lagi.");
                scanner.next(); // consume invalid input
            }
        }
        
        Laptop selectedLaptop;
        switch (choice) {
            case 1:
                selectedLaptop = Lenovo;
                break;
            case 2:
                selectedLaptop = MacBook;
                break;
            case 3:
                selectedLaptop = Toshiba;
                break;
            default:
                System.out.println("Pilihan tidak valid, default ke Lenovo.");
                selectedLaptop = Lenovo;
                break;
        }
        
        LaptopUser revalLaptopUser = new LaptopUser(selectedLaptop);

        boolean isRunning = true;

        System.out.println("===== KONTROL LAPTOP =====");
        System.out.println("On: Menyalakan laptop");
        System.out.println("Off: Mematikan laptop");
        System.out.println("Volume Up: Menambah volume");
        System.out.println("Volume Down: Mengurangi volume");
        System.out.println("Exit: Keluar dari program");
        System.out.println("==========================");

        while (isRunning) {
            System.out.print("\nMasukkan perintah: ");
            String input = scanner.nextLine().toUpperCase();

            switch (input) {
                case "ON":
                    revalLaptopUser.turnOnLaptop();
                    break;
                case "OFF":
                    revalLaptopUser.turnOffLaptop();
                    break;
                case "VOLUME UP":
                    revalLaptopUser.makeLaptopLouder();
                    break;
                case "VOLUME DOWN":
                    revalLaptopUser.makeLaptopSilence();
                    break;
                case "EXIT":
                    System.out.println("Program dihentikan.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Perintah tidak dikenali.");
                    break;
            }
        }
        
        scanner.close();
    }
}