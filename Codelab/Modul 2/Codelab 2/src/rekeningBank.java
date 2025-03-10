// Mendefinisikan kelas rekeningBank
class rekeningBank{
    // Variabel instance untuk menyimpan informasi rekening
    String nomorRekening;
    String namaPemilik;
    double saldo;

    // Konstruktor untuk menginisialisasi objek rekening dengan nomor rekening, nama pemilik, dan saldo awal
    public rekeningBank(String nomorRekening, String namaPemilik, double saldo) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    // Metode untuk menampilkan informasi rekening
    public void tampilkanInfo(){
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nomor Pemilik : " + namaPemilik);
        System.out.println("Saldo         : Rp. " + saldo);
        System.out.println();
    }

    // Metode untuk menyetor uang ke rekening
    public void setorUang(double jumlah) {
        if (jumlah > 0) { // Memastikan jumlah yang disetor lebih dari 0
            saldo += jumlah;
            System.out.println(namaPemilik + " Setor: Rp." + jumlah + " Berhasil. Saldo sekarang: Rp." + saldo);
        } else {
            System.out.println(namaPemilik + "Jumlah Setor harus lebih dari 0");
        }
        System.out.println();
    }

    // Metode untuk menarik uang dari rekening
    public void tarikUang(double jumlah) {
        if (jumlah > 0 && jumlah <= saldo) { // Memastikan jumlah tarik valid dan saldo mencukupi
            saldo -= jumlah;
            System.out.println(namaPemilik + " Tarik: Rp. " + jumlah + " Berhasil. Saldo tersisa: Rp." + saldo);
        } else if (jumlah > saldo) { // Jika saldo tidak mencukupi
            System.out.println(namaPemilik + "Saldo tidak cukup untuk penarikan!!");
        } else { //Jika jumlah tarik negatif atau nol
            System.out.println(namaPemilik + "Jumlah tarik harus lebih dari 0!");
        }
        System.out.println();
    }


}
