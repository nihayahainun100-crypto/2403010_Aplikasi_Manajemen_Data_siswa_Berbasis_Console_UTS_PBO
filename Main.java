import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Admin> daftarAdmin = new ArrayList<>();
        ArrayList<Siswa> daftarSiswa = new ArrayList<>();

        // Data awal
        Admin adminUtama = new Admin("A1", "Admin Utama", "Admin", "123");
        daftarAdmin.add(adminUtama);

        // Login
        System.out.println("===== LOGIN ADMIN =====");
        System.out.print("Username: ");
        String u = input.nextLine();
        System.out.print("Password: ");
        String p = input.nextLine();

        boolean loginSukses = false;
        for (Admin a : daftarAdmin) {
            if (a.login(u, p)) {
                System.out.println("Login berhasil! Selamat datang, " + a.getNama());
                loginSukses = true;
                break;
            }
        }

        if (!loginSukses) {
            System.out.println("Login gagal!");
            return;
        }

        // Menu utama
        int pilih;
        do {
            System.out.println("\n===== MENU APLIKASI =====");
            System.out.println("1. Tambah Data Siswa");
            System.out.println("2. Lihat Data Siswa");
            System.out.println("3. Tambah Nilai Siswa");
            System.out.println("4. Lihat Nilai Siswa");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilih = input.nextInt();
            input.nextLine(); // bersihkan buffer

            switch (pilih) {
                case 1:
                    System.out.print("ID: ");
                    String id = input.nextLine();
                    System.out.print("Nama: ");
                    String nama = input.nextLine();
                    System.out.print("NIS: ");
                    String nis = input.nextLine();

                    Siswa s = new Siswa(id, nama, nis);
                    daftarSiswa.add(s);
                    s.tambahData();
                    break;

                case 2:
                    System.out.println("=== Data Siswa ===");
                    if (daftarSiswa.isEmpty()) {
                        System.out.println("Belum ada data siswa.");
                    } else {
                        for (Siswa x : daftarSiswa) {
                            x.lihatData();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Masukkan ID Siswa: ");
                    String idS = input.nextLine();
                    Siswa target = null;
                    for (Siswa x : daftarSiswa) {
                        if (x.getId().equals(idS)) target = x;
                    }

                    if (target != null) {
                        System.out.print("ID Nilai: ");
                        String idN = input.nextLine();
                        System.out.print("Mata Pelajaran: ");
                        String mapel = input.nextLine();
                        System.out.print("Skor: ");
                        double skor = input.nextDouble();
                        input.nextLine();

                        Nilai n = new Nilai(idN, mapel, skor);
                        target.tambahNilai(n);
                        System.out.println("Nilai berhasil ditambahkan!");
                    } else {
                        System.out.println("Siswa tidak ditemukan!");
                    }
                    break;

                case 4:
                    System.out.print("Masukkan ID Siswa: ");
                    String idCari = input.nextLine();
                    boolean ditemukan = false;
                    for (Siswa x : daftarSiswa) {
                        if (x.getId().equals(idCari)) {
                            x.lihatNilai();
                            ditemukan = true;
                        }
                    }
                    if (!ditemukan) {
                        System.out.println("Siswa tidak ditemukan!");
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih telah menggunakan aplikasi!");
                    break;

                default:
                    System.out.println("Menu tidak valid, silakan pilih kembali!");
                    break;
            }
        } while (pilih != 0);
    }
}
