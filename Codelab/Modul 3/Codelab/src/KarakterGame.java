class KarakterGame {
    private final String nama;
    private int kesehatan;

    public KarakterGame(String nama, int kesehatan){
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    public String getNama() {
        return nama;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = Math.max(kesehatan, 0);
    }

    public int getKesehatan() {
        return kesehatan;
    }

    public void serang(KarakterGame target){
        System.out.println(nama + "menyerang" + target.getNama());
    }
}
