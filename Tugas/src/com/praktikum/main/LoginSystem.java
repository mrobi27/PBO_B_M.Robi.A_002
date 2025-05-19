package com.praktikum.main;

import com.praktikum.data.Item;
import com.praktikum.users.*;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginSystem {
    public static ArrayList<User> userlist = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        userlist.add(new Admin("X", "002", "Admin002", "Password002"));
        userlist.add(new Mahasiswa("Muhamad Robi Ardita", "202410370110002"));
//        User user1 = new Admin("X", "002", "Admin002", "Password002");
//        User user2 = new Mahasiswa("Muhamad Robi Ardita", "202410370110002");

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

                boolean loginBerhasil = false;

                for (User user : userlist) {
                    if (user instanceof Admin) {
                        if (user.login(username, password)) {
                            user.displayInfo();
                            user.displayAppMenu();
                            loginBerhasil = true;
                            break;
                        }
                    }
                }
                if (!loginBerhasil) {
                    System.out.println("Login Admin Gagal!! Username atau Password salah.");
                }

            } else if (pilihan == 2) {
                System.out.print("Masukkan Username: ");
                String nama = scan.nextLine();
                System.out.print("Masukkan Password: ");
                String nim = scan.nextLine();

                boolean loginBerhasil = false;

                for (User user : userlist){
                    if (user instanceof Mahasiswa){
                        if (user.login(nama, nim)) {
                            user.displayInfo();
                            user.displayAppMenu();
                            loginBerhasil = true;
                            break;
                        }
                    }
                }
                if (!loginBerhasil){
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