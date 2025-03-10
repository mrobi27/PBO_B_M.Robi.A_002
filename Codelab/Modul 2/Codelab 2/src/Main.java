public class Main {
    public static void main(String[] args) {
        // Membuat objek rekening dengan nomor rekening, nama pemilik, dan saldo
        rekeningBank rekening1 = new rekeningBank("202410370110002", "Muhamad Robi Ardita", 150000);
        rekeningBank rekening2 = new rekeningBank("202410370110020", "Naufal Arkaan", 2000000);

        //Menampilkan informasi awal dari kedua rekening
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();

        // Melakukan penyetoran uang ke masing-masing rekening
        rekening1.setorUang(1000000);
        rekening2.setorUang(2000000);

        // Melakukan penarikan uang dari masing-masing rekening
        rekening1.tarikUang(50000);
        rekening2.tarikUang(200000);

        // Menampilkan informasi ekening setelah transaksi
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();
    }
}

//Muhamad Robi Ardita_202410370110002_2B