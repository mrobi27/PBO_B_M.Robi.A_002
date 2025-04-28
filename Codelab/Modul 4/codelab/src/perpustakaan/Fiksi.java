package perpustakaan;

public class Fiksi extends Buku {
    private final String genre;

    public Fiksi(String judul, String penulis, String genre) {
        super(judul, penulis);
        this.genre = genre;
    }

    @Override
    public void displayInfo() {
        System.out.println("Buku Fiksi: " + judul + " Oleh " + penulis + "(Genre : " + genre + ")");
    }
}
