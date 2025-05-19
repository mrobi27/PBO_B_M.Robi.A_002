package com.praktikum.users;
import com.praktikum.actions.AdminActions;
import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;

import java.util.InputMismatchException;
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
        System.out.println("1. Lihat Semua Laporan");
        System.out.println("2. Tandai Barang Telah Diambil (Claimed)");
        System.out.print("Pilihan Anda: ");

        try {
            int pilihan = scan.nextInt();
            scan.nextLine();

            switch (pilihan){
                case 1 :
                    for (Item item : LoginSystem.reportedItems){
                        System.out.println("- " + item.getItemName() + " | " + item.getDescription() + " | " + item.getLocation() + " | Status: " + item.getStatus());
                    }
                    break;

                case 2 :
                    for (int i = 0; i < LoginSystem.reportedItems.size(); i++){
                        Item item = LoginSystem.reportedItems.get(i);
                        if (item.getStatus().equalsIgnoreCase("Reported")){
                            System.out.println(i + ". " + item.getItemName() + " | " + item.getStatus());
                        }
                    }
                    try {
                        System.out.println("Masukkan indeks item yang ingin ditandai sebagai 'Claimed': ");
                        int index = scan.nextInt();
                        scan.nextLine();

                        LoginSystem.reportedItems.get(index).setStatus("Claimed");
                        System.out.println("Item berhasil ditandai sebagai 'Claimed'.");
                    } catch (IndexOutOfBoundsException | NumberFormatException e) {
                        System.out.println("Indeks tidak valid!");
                    }
                    break;
                }
        } catch (InputMismatchException e) {
        System.out.println("Input harus berupa angka!");
        scan.nextLine();
        }
    }

    @Override
    public void manageUsers() {
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Hapus Mahasiswa");
        System.out.print("Pilihan Opsi: ");

        try {
            int pilihan = scan.nextInt();
            scan.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Nama: ");
                    String nama = scan.nextLine();
                    System.out.print("Nim: ");
                    String nim = scan.nextLine();
                    LoginSystem.userlist.add(new Mahasiswa(nama, nim));
                    System.out.println("Mahasiswa ditambahkan.");
                    break;

                case 2:
                    System.out.print(" NIM Mahasiswa yang akan dihapus: ");
                    String hpsNim = scan.nextLine();

                    User userToRemove = null;

                    for (User user : LoginSystem.userlist) {
                        if (user instanceof Mahasiswa) {
                            Mahasiswa mhs = (Mahasiswa) user;
                            if (mhs.getNim().equals(hpsNim)) {
                                userToRemove = user;
                                break;
                            }
                        }
                    }

                    if (userToRemove != null) {
                        LoginSystem.userlist.remove(userToRemove);
                        System.out.println("Mahasiswa dengan NIM " + hpsNim + " berhasil dihapus.");
                    } else {
                        System.out.println("Mahasiswa dengan NIM " + hpsNim + " tidak ditemukan.");
                    }
                    break;
            }
        } catch (InputMismatchException e){
            System.out.println("Input harus berupa Angka!!!");
            scan.nextLine();
        }
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
                manageUsers();
            } else if (pilihan == 0) {
                System.out.println("<<< Anda Logout dari Menu Admin >>>");
                break;
            } else {
                System.out.println("Pilihan Tidak Valid!!");
            }
        }
    }

}

