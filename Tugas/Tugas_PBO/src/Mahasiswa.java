import java.util.Scanner;

public class Mahasiswa {
    Scanner scan = new Scanner(System.in);

    String mahasiswa = "Muhamad Robi Ardita";
    String nimMahasiswa = "202410370110002";
    String Nama;
    String nim;

    void login(){
        System.out.print("\nMasukkan Nama: ");
        Nama = scan.nextLine();
        System.out.print("Masukkan NIM: ");
        nim = scan.nextLine();

        if (Nama.equals(mahasiswa) && nim.equals(nimMahasiswa)) {
            displayInfo();
        } else {
            System.out.println("Login gagal! Username atau password salah.");
        }
    }

    void displayInfo(){
        System.out.println("Login Mahasiswa Berhasil!");
        System.out.println("Nama    : " + Nama);
        System.out.println("NIM     : " + nim);
    }

}