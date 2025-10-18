import java.util.ArrayList;


public class Siswa extends Pengguna {
    private String nis;
    private ArrayList<Nilai> daftarNilai = new ArrayList<>();

    public Siswa(String id, String nama, String nis) {
        super(id, nama);
        this.nis = nis;
    }

    public String getNis() { return nis; }

    public void tambahNilai(Nilai nilai) {
        daftarNilai.add(nilai);
        nilai.setSiswa(this); // hubungan dua arah (bidirectional)
    }

    public void lihatNilai() {
        System.out.println("Nilai untuk siswa " + nama + ":");
        if (daftarNilai.isEmpty()) {
            System.out.println("Belum ada nilai yang ditambahkan.");
        } else {
            for (Nilai n : daftarNilai) {
                n.tampilkanNilai();
            }
        }
    }

    @Override
    public void tambahData() {
        System.out.println("Siswa baru ditambahkan: " + nama + " (NIS: " + nis + ")");
    }

    @Override
    public void lihatData() {
        System.out.println("Data Siswa: ID=" + id + ", Nama=" + nama + ", NIS=" + nis);
    }
}
