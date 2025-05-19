package com.praktikum.users;
import java.util.Scanner;
import com.praktikum.actions.MahasiswaActions;
import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;

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
    public void reportdItem() {
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

        Item item = new Item(namaBarang, deskripsiBarang, lokasiTerakhir, "Reported");
        LoginSystem.reportedItems.add(item);
        System.out.println("Laporan berhasil ditambah..");
    }

    @Override
    public void viewReportedItems() {
        if (LoginSystem.reportedItems.isEmpty()){
            System.out.println("Belum ada laporan barang." );
        } else {
            System.out.println("=== Daftar Barang yang dilaporkan === ");
            for (Item item : LoginSystem.reportedItems){
                if ("Reported".equalsIgnoreCase(item.getStatus())){
                    System.out.println("\nNama: " + item.getItemName());
                    System.out.println("Deskripsi: " + item.getDescription());
                    System.out.println("Lokasi: " +item.getLocation());
                }
            }
        }
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
                reportdItem();
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
