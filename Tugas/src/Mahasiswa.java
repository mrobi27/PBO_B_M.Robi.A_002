public class Mahasiswa extends User {
    public Mahasiswa(String nama, String nim){
        super(nama,nim);

    }

    @Override
    public boolean login(String inputNama, String inputNim){
        return this.getNama().equals(inputNama) && this.getNim().equals(inputNim);
    }

    @Override
    public void displayInfo(){
        System.out.println("Login berhasil! Selamat datang, " + getNama() + "(Mahasiswa)");
    }

}