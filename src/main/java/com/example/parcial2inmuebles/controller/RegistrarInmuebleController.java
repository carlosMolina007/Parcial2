package com.example.parcial2inmuebles.controller;

import com.example.parcial2inmuebles.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.time.Year;

public class RegistrarInmuebleController {

    @FXML
    private Button btnDeseleccionar;

    @FXML
    private Button btnGuardar;

    @FXML
    private ComboBox<String> comboTipoCasa;

    @FXML
    private TextField txtCiudad;

    @FXML
    private TextField txtHabitaciones;

    @FXML
    private TextField txtPisos;

    @FXML
    private TextField txtPrecio;

    private final DataBaseFacade dbFacade = new DataBaseFacade();

    @FXML
    public void initialize() {
        ObservableList<String> tipoInmueble = FXCollections.observableArrayList(
                "Casa", "Finca", "Apartamento", "Local"
        );
        comboTipoCasa.setItems(tipoInmueble);
    }

    @FXML
    void guardar(ActionEvent event) {
        try {
            String tipoCasa = comboTipoCasa.getValue();
            int habitaciones = Integer.parseInt(txtHabitaciones.getText());
            String ciudad = txtCiudad.getText();
            int cantidadPisos = 0;
            try {
                cantidadPisos = Integer.parseInt(txtPisos.getText());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido");
            }
            double precio = 0;
            try {
                precio = Double.parseDouble(txtPrecio.getText());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido para el precio");
            }



            Iinmueble inmueble = dbFacade.crearInmueble(tipoCasa, habitaciones, ciudad, cantidadPisos, precio);

            switch (tipoCasa) {
                case "Casa":
                    CasaDecorator casaInmueble = new CasaDecorator(new InmuebleDecorator() {
                    });
                    break;
                case "Finca":
                    FincaDecorator fincaInmueble = new FincaDecorator(new InmuebleDecorator() {
                    });
                    break;
                case "Apartamento":
                    ApartamentoDecorator ApartamentoInmueble = new ApartamentoDecorator(new InmuebleDecorator() {
                    });
                    break;
                case "Local":
                    LocalDecorator localInmueble = new LocalDecorator(new InmuebleDecorator() {
                    });
                    break;
                default:
                    System.out.println("Tipo de inmueble no válido");
                    break;
            }

            mostrarMensaje("Éxito", "Se ha registrado correctamente", Alert.AlertType.INFORMATION);
            limpiarCompletarRegistro();

        } catch (Exception e) {
            mostrarMensaje("Error", "No se pudo registrar la moto: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void limpiarCampos(ActionEvent event) {
        comboTipoCasa.getSelectionModel().clearSelection();
        txtPisos.clear();
        txtHabitaciones.clear();
        txtCiudad.clear();
        txtPrecio.clear();
    }

    private void mostrarMensaje(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void limpiarCompletarRegistro(){
        comboTipoCasa.getSelectionModel().clearSelection();
        txtPisos.clear();
        txtHabitaciones.clear();
        txtCiudad.clear();
        txtPrecio.clear();
    }

}
