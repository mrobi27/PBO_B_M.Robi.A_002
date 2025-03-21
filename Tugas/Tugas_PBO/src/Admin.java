public class Admin extends User {
    private final String username;
    private final String password;

    public Admin(String nama, String nim, String username, String password){
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(String inputUser, String inputPassword){
        return this.username.equals(inputUser) && this.password.equals(inputPassword);
    }

    @Override
    public void displayInfo(){
        System.out.println("Login berhasil! Selamat datang, " + getNama() + "(Admin)");
    }
}
