package com.praktikum.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class LoginPane extends VBox {
    private MainApp mainApp;

    public LoginPane(MainApp mainApp) {
        this.mainApp = mainApp;

        // Atur padding dan jarak antar elemen
        this.setPadding(new Insets(20));
        this.setSpacing(10);

        // Atur alignment semua anak VBox ke tengah
        this.setAlignment(Pos.CENTER);

        Label label = new Label("Login Sistem Lost & Found");

        ComboBox<String> roleCombo = new ComboBox<>();
        roleCombo.getItems().addAll("Mahasiswa", "Admin");
        roleCombo.setValue("Mahasiswa");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");

        Label messageLabel = new Label();

        // Event handler login sederhana
        loginButton.setOnAction(e -> {
            String role = roleCombo.getValue();
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (username.isEmpty() || password.isEmpty()) {
                messageLabel.setText("Username dan password harus diisi!");
                return;
            }

            if (role.equals("Mahasiswa")) {
                if ( mainApp.checkMahasiswaLogin(username, password) ) {
                    mainApp.showMahasiswaDashboard(username);
                } else {
                    messageLabel.setText("Username atau NIM salah!");
                }
            } else if (role.equals("Admin")) {
                if (username.equals("Admin002") && password.equals("Password002")) {
                    mainApp.showAdminDashboard();
                } else {
                    messageLabel.setText("Username atau password salah!");
                }
            }
        });

        // Tambahkan semua elemen ke VBox
        this.getChildren().addAll(label, roleCombo, usernameField, passwordField, loginButton, messageLabel);
    }
}