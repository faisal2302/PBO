public class mahasiswa {
    private String nim, nama;
    private int nilai;

    // setter
    public void setData(String nim, String nama, int nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
    }

    // getter
    public String getNama() {
        return nama;
    }

    public int getNilai() {
        return nilai;
    }

    public String getGrade() {
        if (nilai >= 80 && nilai <= 100) return "A";
        else if (nilai >= 70) return "B";
        else if (nilai >= 60) return "C";
        else if (nilai >= 50) return "D";
        else if (nilai >= 0) return "E";
        else return "Invalid";
    }

    public boolean isLulus() {
        return nilai >= 60;
    }

    public void tampilkanData() {
        System.out.println("NIM   : " + nim);
        System.out.println("Nama  : " + nama);
        System.out.println("Nilai : " + nilai);
        System.out.println("Grade : " + getGrade());
        System.out.println("=====================================");
    }
}