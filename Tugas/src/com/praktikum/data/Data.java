package com.praktikum.data;

import java.util.ArrayList;
import java.util.List;

public class Data {
    // Singleton instance
    private static Data instance;

    // List untuk menyimpan data barang hilang, setiap item berupa array String
    // Contoh: [namaBarang, lokasi, tanggal, keterangan]
    private List<String[]> lostItems;

    // Private constructor agar tidak bisa diinstansiasi dari luar
    private Data() {
        lostItems = new ArrayList<>();
    }

    // Method untuk mendapatkan instance tunggal DataStore
    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

    // Method untuk menambah data barang hilang
    public void addLostItem(String namaBarang, String lokasi, String tanggal, String keterangan) {
        lostItems.add(new String[]{namaBarang, lokasi, tanggal, keterangan});
    }

    // Method untuk mengambil semua data barang hilang
    public List<String[]> getLostItems() {
        return lostItems;
    }

    // Method untuk menghapus data barang hilang berdasarkan index
    public void removeLostItem(int index) {
        if (index >= 0 && index < lostItems.size()) {
            lostItems.remove(index);
        }
    }

    // Contoh method lain bisa ditambahkan sesuai kebutuhan
}