package app;

import perpustakaan.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n === PERPUSTAKAAN ===");
        NonFiksi nonfiksi1 = new NonFiksi("Madilog", "Tan Malaka", "Sejarah & Ilmu Pengetahuan");
        Fiksi fiksi2 = new Fiksi("Hainuwele: Sang Putri Kelapa", "Lilis Hu", "Dongeng");

        nonfiksi1.displayInfo();
        fiksi2.displayInfo();

        System.out.println("\n === DAFTAR ANGGOTA ===");

        Peminjaman anggota1 = new Anggota("Muhamad Robi Ardita", "B002");
        Peminjaman anggota2 = new Anggota("Naufal Arkaan", "B020");

        anggota1.tampilkanInfo();
        anggota2.tampilkanInfo();

        System.out.println("\n === DAFTAR PEMINJAM ===");

        anggota1.pinjamBuku("Madilog");
        anggota2.pinjamBuku("Hainuwele: Sang Putri Kelapa",7);

        System.out.println("\n === DAFTAR PENGEMBALIAN ===");

        anggota1.kembalikanBuku("Madilog");
        anggota2.kembalikanBuku("Hainuwele: Sang Putri Kelapa");

    }

}
