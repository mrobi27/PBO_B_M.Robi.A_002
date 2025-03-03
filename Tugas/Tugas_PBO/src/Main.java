import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Pilih Jenis Login: ");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan Pilihan Anda: ");
        int Pilihan = scan.nextInt();
        scan.nextLine();

        if (Pilihan == 1) {

            String nimAkhir = "002";
            String Admin = "Admin" + nimAkhir;
            String Password = "password" + nimAkhir;

            System.out.print("\nMasukkan Username: ");
            String userName = scan.nextLine();
            System.out.print("Masukkan Password: ");
            String password = scan.nextLine();

            if (userName.equals(Admin) && password.equals(Password)) {
                System.out.println("Login Admin Berhasil");
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }

        } else if (Pilihan == 2) {
            String Mahasiswa = "Muhamad Robi Ardita";
            String NimMahasiswa = "202410370110002";

            System.out.print("\nMasukkan Nama: ");
            String Nama = scan.nextLine();

            System.out.print("Masukkan NIM: ");
            String nim = scan.nextLine();

            if (Nama.equals(Mahasiswa) && nim.equals(NimMahasiswa)) {
                System.out.println("Login Mahasiswa Berhasil!");
                System.out.println("Nama    : " + Nama);
                System.out.println("NIM     : " + nim);
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }
        } else {
            System.out.println("Pilihan tidak valid, hanya angka (1/2)");
        }

    }
}