import java.util.Scanner;

public class Admin {
    Scanner scan = new Scanner(System.in);

    String nimAkhir = "002";
    String Admin = "Admin" + nimAkhir;
    String Password = "password" + nimAkhir;

    void login(){
        System.out.print("\nMasukkan Username: ");
        String userName = scan.nextLine();
        System.out.print("Masukkan Password: ");
        String password = scan.nextLine();

        if (userName.equals(Admin) && password.equals(Password)) {
            System.out.println("Login Admin Berhasil");
        } else {
            System.out.println("Login gagal! Username atau password salah.");
        }
    }
}
