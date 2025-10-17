package com.example.parcial2inmuebles.model;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    //Implementación singleton
    private static DataBase db;
    private final List<Inmueble> listaInmuebles = new ArrayList<>();

    private DataBase() {
        Inmueble casa1 = new Inmueble.Builder().tipo("Casa").habitaciones(3).ciudad("Armenia").cantidadPisos(2).precio(300000000).build();
        Inmueble apartamento1 = new Inmueble.Builder().tipo("Apartamento").habitaciones(2).ciudad("Bogota").cantidadPisos(1).precio(600000000).build();
        Inmueble Finca1 = new Inmueble.Builder().tipo("Finca").habitaciones(10).ciudad("Medellin").cantidadPisos(2).precio(900000000).build();
        Inmueble Local1 = new Inmueble.Builder().tipo("Local").habitaciones(1).ciudad("Ibague").cantidadPisos(1).precio(100000000).build();
    }

    public static DataBase getInstance() {
        if (db == null) {
            db = new DataBase();
        }
        return db;
    }

    public void eliminarInmueble(Inmueble inmueble) {
        listaInmuebles.remove(inmueble);
    }

    public List<Inmueble> getListaInmuebles() {
        return listaInmuebles;
    }
}
