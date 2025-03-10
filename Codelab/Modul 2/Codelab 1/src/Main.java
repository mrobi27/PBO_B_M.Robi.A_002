// Kelas Utama (Main) yang akan menjalankan program.
public class Main {
    public static void main(String[] args) {
        //Membuat objek hewan1 dan hewan 2 dengan nama, jenis, dan suara
        Hewan hewan1 = new Hewan("Kucing", "Mamalia", "Nyann~~");

        Hewan hewan2 = new Hewan("Anjing", "Mamalia", "Woof-Woof!!");

        // Memanggil metode tampilkanInfo() untuk menampilkan informasi hewan1
        hewan1.tampilkanInfo();
        // Memanggil metode tampilkanInfo() untuk menampilkan informasi hewan2
        hewan2.tampilkanInfo();
    }
}

//Muhamad Robi Ardita_202410370110002_2B