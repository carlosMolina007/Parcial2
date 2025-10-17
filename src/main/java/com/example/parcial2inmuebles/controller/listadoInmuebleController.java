package com.example.parcial2inmuebles.controller;

import com.example.parcial2inmuebles.model.DataBaseFacade;
import com.example.parcial2inmuebles.model.Iinmueble;
import com.example.parcial2inmuebles.model.Inmueble;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class listadoInmuebleController {

    @FXML
    private Button btnDeseleccionar;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableColumn<Iinmueble, String> colCiudad;

    @FXML
    private TableColumn<Iinmueble, Integer> colHabitaciones;

    @FXML
    private TableColumn<Iinmueble, Integer> colPisos;

    @FXML
    private TableColumn<Iinmueble, Double> colPrecio;

    @FXML
    private TableColumn<Iinmueble, String> colTipo;

    @FXML
    private TableView<Iinmueble> tablaInmuebles;

    @FXML
    private TableColumn<Iinmueble, Double> colImpuesto;

    private final ObservableList<Iinmueble> listaInmuebles = FXCollections.observableArrayList();
    private final DataBaseFacade dbFacade = new DataBaseFacade();


    @FXML
    public void initialize() {
        colCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colPisos.setCellValueFactory(new PropertyValueFactory<>("cantidadPisos"));
        colHabitaciones.setCellValueFactory(new PropertyValueFactory<>("habitaciones"));
        colImpuesto.setCellValueFactory(new PropertyValueFactory<>("impuesto"));

        tablaInmuebles.setItems(listaInmuebles);
        cargarInmuebles();
    }


    @FXML
    void deseleccionar(ActionEvent event) {
        tablaInmuebles.getSelectionModel().clearSelection();
    }

    @FXML
    void eliminar(ActionEvent event) {
        Iinmueble seleccionada = tablaInmuebles.getSelectionModel().getSelectedItem();

        if (seleccionada != null) {
            dbFacade.eliminarInmueble((Inmueble) seleccionada);
            cargarInmuebles();
            mostrarAlerta("Se ha eliminado correctamente.");
        } else {
            mostrarAlerta("Debe seleccionar un inmueble para eliminar.");
        }
    }

    private void cargarInmuebles() {
        listaInmuebles.setAll(dbFacade.getDb().getListaInmuebles());
    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Atención");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

}
