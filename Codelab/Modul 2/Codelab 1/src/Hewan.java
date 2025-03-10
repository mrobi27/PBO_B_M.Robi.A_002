class  Hewan {
    // Variabel instance untuk menyimpan data tentang hewan
    String Nama;
    String Jenis;
    String Suara;

    // Konstruktor untuk menginisialisasi atribut objek Hewan
    public Hewan (String Nama, String Jenis, String Suara){
        this.Nama = Nama;
        this.Jenis = Jenis;
        this.Suara = Suara;
    }
    // Metode untuk menampilkan informasi hewan
    public void tampilkanInfo(){
        System.out.println("Nama : " + Nama);
        System.out.println("Jenis: " + Jenis);
        System.out.println("Suara: " + Suara);
        System.out.println();
    }
}
