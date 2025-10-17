package com.example.parcial2inmuebles.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class DashboardController {

    @FXML
    private Button buttonSlide;

    @FXML
    private AnchorPane buttonsContainer;

    @FXML
    private Button listadoInmuebles;

    @FXML
    private AnchorPane mainContent;

    @FXML
    private Button registrarInmueble;

    @FXML
    private HBox root;

    @FXML
    private VBox slideMenu;

    private boolean menuVisible = true;

    private void cargarVista(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/parcial2inmuebles/" + fxmlPath));
            Node view = loader.load();

            mainContent.getChildren().setAll(view);

            AnchorPane.setTopAnchor(view, 0.0);
            AnchorPane.setBottomAnchor(view, 0.0);
            AnchorPane.setLeftAnchor(view, 0.0);
            AnchorPane.setRightAnchor(view, 0.0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void agregarInmueble(ActionEvent event) {
        cargarVista("registrarInmueble.fxml");
    }

    @FXML
    void listaInmuebles(ActionEvent event) {
        cargarVista("listadoInmueble.fxml");
    }

    @FXML
    void visibleMenu(ActionEvent event) {
        if (menuVisible) {
            slideMenu.setVisible(false);
            slideMenu.setManaged(false);
        } else {
            slideMenu.setVisible(true);
            slideMenu.setManaged(true);
        }
        menuVisible = !menuVisible;
    }

}
