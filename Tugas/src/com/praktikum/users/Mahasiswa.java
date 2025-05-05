package com.praktikum.users;
import java.util.Scanner;
import com.praktikum.actions.MahasiswaActions;

public class Mahasiswa extends User implements MahasiswaActions {
    Scanner scan = new Scanner(System.in);
    public Mahasiswa(String nama, String nim){
        super(nama,nim);
    }

    @Override
    public boolean login(String inputNama, String inputNim){
        return this.getNama().equals(inputNama) && this.getNim().equals(inputNim);
    }

    @Override
    public void displayInfo(){
        System.out.println("Login berhasil! Selamat datang, " + getNama() + "(Mahasiswa)");
    }

    @Override
    public void reportItem() {
        System.out.print("Masukkan Nama Barang: ");
        String namaBarang = scan.nextLine();
        System.out.print("Masukkan Deskripsi Barang: ");
        String deskripsiBarang = scan.nextLine();
        System.out.print("Lokasi Terakhir/Ditemukan: ");
        String lokasiTerakhir = scan.nextLine();

        System.out.println("\n Laporan Berhasil Ditambah: ");
        System.out.println("Nama Barang      : " + namaBarang);
        System.out.println("Deskripsi Barang : " + deskripsiBarang);
        System.out.println("Lokasi Terakhir  : " + lokasiTerakhir);
    }

    @Override
    public void viewReportedItems() {
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
    }

    @Override
    public void displayAppMenu() {
        while (true) {
            System.out.println("\n=== MENU UTAMA MAHASISWA ===");
            System.out.println("Silakan pilih menu yang ingin dijalankan:");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilihan Anda: ");
            int pilihan = scan.nextInt();
            scan.nextLine();

            if (pilihan == 1) {
                reportItem();
            } else if (pilihan == 2) {
                viewReportedItems();
            } else if (pilihan == 0) {
                System.out.println("<<< Anda Logout dari Menu Mahasiswa >>>");
                break;
            } else {
                System.out.println("Pilihan Tidak Valid!!");
            }
        }
    }
}
