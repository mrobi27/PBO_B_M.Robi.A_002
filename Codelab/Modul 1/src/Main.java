import java.util.Scanner; // Mengimpor Kelas Scanner untuk input dari pengguna
import java.time.LocalDate; // Mengimpor LocalDate untuk mendapatkan tahun saat ini


public class Main {
    public static void main(String[] args) throws Exception {
        String nama;
        String jenisKelamin;
        int tahunLahir;
        Scanner scan = new Scanner(System.in);  // Membuat objek Scanner untuk menerima input dari pengguna

        System.out.print("\nMasukkan Nama: "); // Meminta pengguna memasukkan Nama
        nama = scan.nextLine();

        System.out.print("Masukkan Jenis Kelamin (P/L): "); // Meminta pengguna memasukkan Jenis kelamin.
        jenisKelamin = scan.nextLine();

        System.out.print("Masukkan Tahun Lahir: "); // Meminta pengguna memasukkan Tahun Lahir.
        tahunLahir = scan.nextInt();


        // Menentukan deskripsi Jenis kelamin   // equalsIgnoreCase digunakan untuk membandingkan dua string tanpa memperhatikan hurus besar atau kecil.
        if (jenisKelamin.equalsIgnoreCase("L")) {
            jenisKelamin = "Laki-Laki";
        } else if (jenisKelamin.equalsIgnoreCase("P")) {
            jenisKelamin = "Perempuan";
        } else {
            jenisKelamin ="Input tidak Valid: Input harus (P/L)";
        }

        // Mendapatkan tahun saat ini menggunakan LocalDate
        int tahunSekarang = LocalDate.now().getYear();

        // Menghitung Umur
        int umur = tahunSekarang - tahunLahir;

        //Menampilkan hasil input dan perhitungan ke layar
        System.out.println("\nData Diri");
        System.out.println("Nama          :" + nama);
        System.out.println("Jenis Kelamin :" + jenisKelamin);
        System.out.println("Umur          :" + umur + " Tahun" );

        // Menutup Scanner untuk mencegah kebocoran sumber daya
        scan.close();

    }
}
// Muhamad Robi Ardita 202410370110002 Codelab1 Modul 1 Informatika B