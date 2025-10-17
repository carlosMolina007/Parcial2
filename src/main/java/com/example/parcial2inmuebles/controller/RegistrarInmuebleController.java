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



            Iinmueble inmuebleBase = dbFacade.crearInmueble(tipoCasa, habitaciones, ciudad, cantidadPisos, precio);

            Iinmueble inmuebleDecorado;
            switch (tipoCasa) {
                case "Casa":
                    inmuebleDecorado = new CasaDecorator(inmuebleBase);
                    break;
                case "Finca":
                    inmuebleDecorado = new FincaDecorator(inmuebleBase);
                    break;
                case "Apartamento":
                    inmuebleDecorado = new ApartamentoDecorator(inmuebleBase);
                    break;
                case "Local":
                    inmuebleDecorado = new LocalDecorator(inmuebleBase);
                    break;
                default:
                    mostrarMensaje("Error", "Tipo de inmueble no válido", Alert.AlertType.ERROR);
                    return;
            }


            dbFacade.getListainmuebles().add(inmuebleDecorado);

            mostrarMensaje("Éxito", "Se ha registrado correctamente", Alert.AlertType.INFORMATION);
            limpiarCompletarRegistro();

        } catch (Exception e) {
            mostrarMensaje("Error", "No se pudo registrar la moto: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void limpiarCampos(ActionEvent event) {
        limpiarCompletarRegistro();
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
