import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ManajemenStok {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

//        daftarBarang.add(new Barang("pensil",50));
//        for (Barang barang : daftarBarang){
//            System.out.println("Nama Barang: " + barang.getNama() + "\nStok Barang: " + barang.getStok());
//        }
        while (true){
            System.out.println("\n---Sistem Pengelolaan Barang---");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang ");
            System.out.println("0. Keluar");
            System.out.print("Pilihan Anda: ");
            String pilihan = scan.nextLine();

            switch (pilihan){
                case "1" :
                    try {
                        System.out.print("Masukkan nama barang: ");
                        String nama = scan.nextLine();
                        System.out.print("Masukkan stok awal: ");
                        int stok = scan.nextInt();
                        scan.nextLine();

                        daftarBarang.add(new Barang(nama,stok));
                        System.out.println("Barang " + nama + " berhasil ditambah");
                    } catch (InputMismatchException e){
                        System.out.println("Input stok harus berupa angka!");
                        scan.nextLine();
                    }
                    break;

                case "2" :
                    if (daftarBarang.isEmpty()){
                        System.out.println("Stok barang kosong.");
                    }else {
                        System.out.println("\n---Daftar Barang---: ");
                        int nomor = 1;
                        for (Barang barang : daftarBarang){
                            System.out.println(nomor + ". " + "Nama " + barang.getNama() + ", Stok: " + barang.getStok());
                            nomor++;
                        }
                    }
                    break;

                case "3" :
                    for (int i = 0; i < daftarBarang.size(); i++){
                        Barang barang = daftarBarang.get(i);
                        System.out.println((i + 1) + ". " + barang.getNama() + ", Stok: " + barang.getStok());
                    }
                    try {
                        System.out.print("Masukkan nomor Barang yang akan di kurangi: ");
                        int indeks = scan.nextInt();
                        indeks = indeks - 1;
                        Barang barang = daftarBarang.get(indeks);

                        if (barang.getStok() == 0) {
                            System.out.println("Stok barang habis. Tidak bisa dikurangi.");
                            break;
                        }

                        System.out.print("Masukkan jumlah yang diambil: ");
                        int jumlah = scan.nextInt();
                        scan.nextLine();

                        if (jumlah > barang.getStok()) {
                            throw new StokTidakCukupException("Stok untuk " + barang.getNama() + " hanya sisa " + barang.getStok());
                        }

                        barang.setStok(barang.getStok() - jumlah);
                        System.out.println("Stok Barang " + barang.getNama() + " berhasil dikurangi " + ", Sisa Stok: " + barang.getStok());
                    }catch (InputMismatchException e){
                        System.out.println("Input harus berupa angka!");
                        scan.nextLine();
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("Nomor barang tidak valid!");
                    }catch (StokTidakCukupException e){
                        System.out.println("Gagal: " + e.getMessage());
                    }
                    break;

                case "0" :
                    System.out.println("Terima kasih!");
                    return;

                default:
                    System.out.println("Opsi tidak dikenali.");
            }
        }

    }
}