// ===============================
// PARENT CLASS : Pengguna
// Superclass yang digunakan oleh Admin dan Siswa
// ===============================
public abstract class Pengguna {
    protected String id;
    protected String nama;

    public Pengguna(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }

    // Method abstrak → wajib diimplementasikan di subclass
    public abstract void tambahData();
    public abstract void lihatData();
}
