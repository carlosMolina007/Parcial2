package com.example.parcial2inmuebles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 640);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/iconoApp.png")));
        stage.setTitle("Sistema de Gestión inmobiliario");
        stage.setScene(scene);
        stage.show();
    }
}
