package com.praktikum.gui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;
import com.praktikum.data.Data;
import java.util.*;

public class MahasiswaDashboard extends VBox {
    private MainApp mainApp;
    private String username;
    private ObservableList<String[]> mahasiswaReports;

    public MahasiswaDashboard(MainApp mainApp, String username, ObservableList<String[]> mahasiswaReports) {
        this.mainApp = mainApp;
        this.username = username;
        this.mahasiswaReports = mahasiswaReports;

        this.setPadding(new Insets(20));
        this.setSpacing(10);

        Label welcomeLabel = new Label("Selamat datang, " + username);
        Label informasi = new Label("Laporkan Barang Hilang/Temuan");

        TextField itemNameField = new TextField();
        itemNameField.setPromptText("Nama Barang");

        TextField itemDescField = new TextField();
        itemDescField.setPromptText("Deskripsi Barang");

        TextField itemLocationField = new TextField();
        itemLocationField.setPromptText("Lokasi Barang");

        Button reportButton = new Button("Laporkan");

        HBox hboxFields = new HBox(15, itemNameField, itemDescField, itemLocationField, reportButton);

        TableView<String[]> reportTable = new TableView<>();
        reportTable.setItems(mahasiswaReports);

        TableColumn<String[], String> nameCol = new TableColumn<>("Nama Barang");
        nameCol.setCellValueFactory(param -> new javafx.beans.property.SimpleStringProperty(param.getValue()[0]));

        TableColumn<String[], String> descCol = new TableColumn<>("Deskripsi");
        descCol.setCellValueFactory(param -> new javafx.beans.property.SimpleStringProperty(param.getValue()[1]));

        TableColumn<String[], String> locationCol = new TableColumn<>("Lokasi");
        locationCol.setCellValueFactory(param -> new javafx.beans.property.SimpleStringProperty(param.getValue()[2]));

        reportTable.getColumns().addAll(nameCol, descCol, locationCol);

        reportButton.setOnAction(e -> {
            String itemName = itemNameField.getText().trim();
            String itemDesc = itemDescField.getText().trim();
            String itemLocation = itemLocationField.getText().trim();

            if (itemName.isEmpty() || itemLocation.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Nama Barang dan Lokasi harus diisi!");
                alert.showAndWait();
                return;
            }

            String[] newReport = new String[]{itemName, itemDesc, itemLocation};
            mainApp.addReport(newReport);

            itemNameField.clear();
            itemDescField.clear();
            itemLocationField.clear();
        });

        Data dataStore = Data.getInstance();
        List<String[]> lostItems = dataStore.getLostItems();

        for (String[] item : lostItems) {
            System.out.println("Nama Barang: " + item[0]);
            System.out.println("Lokasi: " + item[1]);
            System.out.println("Tanggal: " + item[2]);
            System.out.println("Keterangan: " + item[3]);
            System.out.println("---------------------------");
        }

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> mainApp.showLoginPane());

        this.getChildren().addAll(
                welcomeLabel,
                informasi,
                hboxFields,
                new Label("Daftar Laporan Anda:"),
                reportTable,
                logoutButton
        );
    }
}