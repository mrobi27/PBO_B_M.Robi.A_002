package com.praktikum.main;

import com.praktikum.users.*;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        User user1 = new Admin("X", "002", "Admin002", "Password002");
        User user2 = new Mahasiswa("Muhamad Robi Ardita", "202410370110002");

        while (true) {
            System.out.println("--------------------");
            System.out.println("Pilih Jenis Login: ");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Masukkan Pilihan Anda: ");
            int pilihan = scan.nextInt();
            scan.nextLine();

            if (pilihan == 1) {
                System.out.print("Masukkan Username: ");
                String username = scan.nextLine();
                System.out.print("Masukkan Password: ");
                String password = scan.nextLine();

                if (user1.login(username, password)) {
                    user1.displayInfo();
                    user1.displayAppMenu();
                } else {
                    System.out.println("Login Admin Gagal!! Username atau Password salah. ");
                }

            } else if (pilihan == 2) {
                System.out.print("Masukkan Username: ");
                String nama = scan.nextLine();
                System.out.print("Masukkan Password: ");
                String nim = scan.nextLine();

                if (user2.login(nama, nim)) {
                    user2.displayInfo();
                    user2.displayAppMenu();
                } else {
                    System.out.println("Login Mahasiswa Gagal!! Nama atau Nim salah. ");
                }

            } else if (pilihan == 3) {
                System.out.println("Keluar dari sistem. Terimakasih!");
                break;
            } else {
                System.out.println("Inputan tidak valid! Pilih antara (1//3)");
            }
        }
    }
}