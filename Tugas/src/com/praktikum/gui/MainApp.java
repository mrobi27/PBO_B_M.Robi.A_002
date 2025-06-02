package com.praktikum.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainApp extends Application {

    private Stage primaryStage;
    private ObservableList<String[]> mahasiswaReports = FXCollections.observableArrayList();
    private ObservableList<String[]> adminReports = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showLoginPane();
        primaryStage.setTitle("Lost & Found Kampus");
        primaryStage.show();
    }

    public void showLoginPane() {
        LoginPane loginPane = new LoginPane(this);
        Scene scene = new Scene(loginPane, 400, 250);
        primaryStage.setScene(scene);
    }

    public void showMahasiswaDashboard(String username) {
        MahasiswaDashboard mahasiswaDashboard = new MahasiswaDashboard(this, username, mahasiswaReports);
        Scene scene = new Scene(mahasiswaDashboard, 600, 400);
        primaryStage.setScene(scene);
    }

    public void showAdminDashboard() {
        AdminDashboard adminDashboard = new AdminDashboard(this, adminReports);
        Scene scene = new Scene(adminDashboard, 600, 400);
        primaryStage.setScene(scene);
    }

    // Method untuk menambahkan laporan dari MahasiswaDashboard
    public void addReport(String[] report) {
        mahasiswaReports.add(report);
        // langsung simpan sebagai array [nama, lokasi, status]
        adminReports.add(new String[]{ report[0], report[2], "Reported" });
    }

    // Method untuk update status laporan di adminReports
    public void updateAdminReportStatus(int idx, String newStatus) {
        String[] old = adminReports.get(idx);
        adminReports.set(idx, new String[]{ old[0], old[1], newStatus });
    }

    private ObservableList<String[]> mahasiswaData = FXCollections.observableArrayList();

    public void setMahasiswaData(ObservableList<String[]> data) {
        this.mahasiswaData = data;
    }

    public boolean checkMahasiswaLogin(String nama, String nim) {
        for (String[] mhs : mahasiswaData) {
            if (mhs[0].equalsIgnoreCase(nama) && mhs[1].equals(nim)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        launch(args);
    }
}