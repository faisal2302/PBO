public class HandPhone {
    String jenis_hp;
    int tahun_pembuatan;

    public String setDataHP(String jenis_hp, int tahun_pembuatan){
        this.jenis_hp = jenis_hp;
        this.tahun_pembuatan = tahun_pembuatan;
        return jenis_hp;
    }

    String getJenisHP(){
        return jenis_hp;
    }

    int getTahunPembuatan(){
        return tahun_pembuatan;
    }
    public static void main(String[] args) {
        HandPhone hp = new HandPhone();
        hp.setDataHP("Xiaomi", 2020);
        System.out.println("Jenis HP: " + hp.getJenisHP());
        System.out.println("Tahun Pembuatan: " + hp.getTahunPembuatan());
    }
}