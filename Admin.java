public class Admin extends Pengguna {
    private String username;
    private String password;

    public Admin(String id, String nama, String username, String password) {
        super(id, nama); // memanggil constructor parent (Pengguna)
        this.username = username;
        this.password = password;
    }

    // Method login khusus untuk Admin
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Implementasi abstract method dari class Pengguna
    @Override
    public void tambahData() {
        System.out.println("Admin baru ditambahkan: " + nama);
    }

    @Override
    public void lihatData() {
        System.out.println("Data Admin: ID=" + id + ", Nama=" + nama + ", Username=" + username);
    }
}
