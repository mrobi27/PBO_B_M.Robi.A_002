import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Admin admin = new Admin();
        Mahasiswa mahasiswa = new Mahasiswa();

        System.out.println("Pilih Jenis Login: ");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan Pilihan Anda: ");
        int Pilihan = scan.nextInt();
        scan.nextLine();

        if (Pilihan == 1){
            admin.login();
        } else if (Pilihan == 2) {
            mahasiswa.login();
        } else{
            System.out.println("Inputan tidak valid! Pilih antara (1/2)");
        }
    }
}