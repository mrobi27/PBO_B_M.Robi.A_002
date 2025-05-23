import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TbkAngka extends Application {
    private int angkaRahasia;
    private int jumlahPercobaan = 0;

    private final Label feedback = new Label();
    private final Label percobaan = new Label("Jumlah Percobaan: 0");
    private final Button tombol = new Button();
    private final TextField input = new TextField();

    public void resetGame() {
        angkaRahasia = (int) (Math.random() * 100) + 1;
        jumlahPercobaan = 0;
        feedback.setText("");
        percobaan.setText("Jumlah Percobaan: 0");
        input.clear();
        input.setDisable(false);

        tombol.setText(" Coba Tebak");
        Image dadu = new Image(getClass().getResourceAsStream("/image/Dadu.png"));
        ImageView daduIcon = new ImageView(dadu);
        daduIcon.setFitHeight(16);
        daduIcon.setPreserveRatio(true);
        tombol.setGraphic(daduIcon);

        feedback.setStyle("-fx-text-fill: yellow;");
    }

    @Override
    public void start(Stage stage) {
        resetGame();

        Image imageKiri = new Image(getClass().getResourceAsStream("/image/judul1.png"));
        ImageView emojiKiri = new ImageView(imageKiri);
        emojiKiri.setFitHeight(64);
        emojiKiri.setPreserveRatio(true);

        Label judul1 = new Label("Tebak Angka 1-100");
        judul1.setFont(Font.font("Poppins", 40));
        judul1.setStyle("-fx-text-fill: white;");

        Image imageKanan = new Image(getClass().getResourceAsStream("/image/judul3.png"));
        ImageView emojiKanan = new ImageView(imageKanan);
        emojiKanan.setFitHeight(64);
        emojiKanan.setPreserveRatio(true);

        HBox judulBox = new HBox(20, emojiKiri, judul1, emojiKanan);
        judulBox.setAlignment(Pos.CENTER);

        input.setPromptText("Masukkan Angka disini..");
        input.setFont(Font.font(16));
        input.setPrefWidth(300);
        input.setMaxWidth(300);

        tombol.setFont(Font.font(16));
        tombol.setStyle("-fx-background-color: #3b0df8; -fx-text-fill: white; -fx-padding: 10 20;");
        Image dadu = new Image(getClass().getResourceAsStream("/image/Dadu.png"));
        ImageView daduIcon = new ImageView(dadu);
        daduIcon.setFitHeight(16);
        daduIcon.setPreserveRatio(true);
        tombol.setGraphic(daduIcon);
        tombol.setText(" Coba Tebak");

        feedback.setFont(Font.font(16));
        feedback.setStyle("-fx-text-fill: yellow;");
        percobaan.setFont(Font.font(18));
        percobaan.setStyle("-fx-text-fill: white;");

        tombol.setOnAction(e -> {
            if (tombol.getText().equals("Main Lagi")) {
                resetGame();
                return;
            }

            String inputStr = input.getText();
            try {
                int tebakan = Integer.parseInt(inputStr);
                jumlahPercobaan++;

                if (tebakan < angkaRahasia) {
                    feedback.setText("Terlalu kecil!");
                    feedback.setStyle("-fx-text-fill: orange;");
                } else if (tebakan > angkaRahasia) {
                    feedback.setText("Terlalu besar!");
                    feedback.setStyle("-fx-text-fill: orange;");
                } else {
                    feedback.setText("✔ Tebakan benar!");
                    feedback.setStyle("-fx-text-fill: #00e676; -fx-font-weight: bold;");
                    tombol.setText("Main Lagi");
                    tombol.setGraphic(null); // hilangkan dadu saat 'Main Lagi'
                    input.setDisable(true);  // nonaktifkan input
                }

                percobaan.setText("Jumlah Percobaan: " + jumlahPercobaan);
            } catch (NumberFormatException ex) {
                feedback.setText("Masukkan angka valid!");
                feedback.setStyle("-fx-text-fill: red;");
            }

            input.clear();
        });


        HBox inputBox = new HBox(10, input, tombol);
        inputBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(30, judulBox, inputBox, feedback, percobaan);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(40));
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #000000 0%, #000000 70%, #333333 100%);");

        Scene scene = new Scene(root, 700, 500);
        stage.setScene(scene);
        stage.setTitle("Tebak Angka - Robi");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
