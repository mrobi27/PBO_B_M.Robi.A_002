public class Main {
    public static void main(String[] args) {
        Pahlawan pahlawan = new Pahlawan("Brimstone", 150);
        Musuh musuh = new Musuh("Viper", 200);

        System.out.println("Status Awal: ");
        System.out.println(pahlawan.getNama() + " memiliki kesehatan: " + pahlawan.getKesehatan());
        System.out.println(musuh.getNama() + " memiliki kesehatan: " + musuh.getKesehatan());

        System.out.println("\nPertarungan dimulai...\n");

        pahlawan.serang(musuh);
        musuh.serang(pahlawan);
    }
}