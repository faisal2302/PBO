import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("--- Input Data Mahasiswa ---");
        System.out.print("Nama Mahasiswa: ");
        String sName = input.nextLine();
        System.out.print("Alamat Mahasiswa: ");
        String sAddress = input.nextLine();
        Student s1 = new Student(sName, sAddress);

        System.out.print("Masukkan jumlah Mata Kuliah yang diambil: ");
        int n = input.nextInt();
        input.nextLine(); // clear buffer

        for (int i = 0; i < n; i++) {
            System.out.print("Nama Mata Kuliah " + (i+1) + ": ");
            String cName = input.nextLine();
            System.out.print("Nilai: ");
            int cGrade = input.nextInt();
            input.nextLine();
            s1.addCourseGrade(cName, cGrade);
        }

        System.out.println("\n--- Hasil Simulasi Student ---");
        System.out.println(s1.toString());
        s1.printGrades();
        System.out.println("Rata-rata: " + s1.getAverageGrade());

        System.out.println("\n--- Input Data Dosen ---");
        System.out.print("Nama Dosen: ");
        String tName = input.nextLine();
        System.out.print("Alamat Dosen: ");
        String tAddress = input.nextLine();
        Teacher t1 = new Teacher(tName, tAddress);

        System.out.print("Tambahkan Mata Kuliah yang diampu: ");
        String tcName = input.nextLine();
        if (t1.addCourse(tcName)) {
            System.out.println("Mata kuliah " + tcName + " berhasil ditambahkan.");
        } else {
            System.out.println("Mata kuliah sudah ada!");
        }

        System.out.println("\n--- Hasil Simulasi Teacher ---");
        System.out.println(t1.toString());

        input.close();
    }
}