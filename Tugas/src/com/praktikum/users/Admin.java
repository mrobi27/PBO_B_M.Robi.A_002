package com.praktikum.users;
import com.praktikum.actions.AdminActions;
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    Scanner scan = new Scanner(System.in);
    private String username;
    private String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(String inputUser, String inputPassword) {
        return this.username.equals(inputUser) && this.password.equals(inputPassword);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login berhasil! Selamat datang, " + getNama() + "(Admin)");
    }

    @Override
    public void manageItem() {
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
    }

    @Override
    public void manageUsers() {
        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }

    @Override
    public void displayAppMenu() {
        while (true) {
            System.out.println("\n=== MENU UTAMA ADMIN ===");
            System.out.println("Silakan pilih menu yang ingin dijalankan:");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilihan Anda: ");
            int pilihan =scan.nextInt();
            scan.nextLine();
            
            if (pilihan == 1){
                manageItem();
            } else if (pilihan == 2) {
                manageItem();
            } else if (pilihan == 0) {
                System.out.println("<<< Anda Logout dari Menu Admin >>>");
                break;
            } else {
                System.out.println("Pilihan Tidak Valid!!");
            }
        }
    }

}

