// ===============================
// CLASS : Nilai
// Memiliki relasi Association dengan Siswa
// ===============================
public class Nilai {
    private String mataPelajaran;
    private double skor;
    private Siswa siswa; // relasi ke class Siswa

    public Nilai(String idNilai, String mataPelajaran, double skor) {
        this.mataPelajaran = mataPelajaran;
        this.skor = skor;
    }

    public void setSiswa(Siswa siswa) {
        this.siswa = siswa;
    }

    public void tampilkanNilai() {
        System.out.println("Nilai: " + mataPelajaran + " = " + skor + 
            " | Siswa: " + (siswa != null ? siswa.getNama() : "-"));
    }
}
