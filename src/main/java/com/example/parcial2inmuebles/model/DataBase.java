package com.example.parcial2inmuebles.model;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    //Implementación singleton
    private static DataBase db;
    private final List<Iinmueble> listaInmuebles = new ArrayList<>();

    private DataBase() {
        Iinmueble casa1 = new CasaDecorator(new Inmueble.Builder().tipo("Casa").habitaciones(3).ciudad("Armenia").cantidadPisos(2).precio(300000000).build());
        Iinmueble apartamento1 = new ApartamentoDecorator(new Inmueble.Builder().tipo("Apartamento").habitaciones(2).ciudad("Bogota").cantidadPisos(1).precio(600000000).build());
        Iinmueble Finca1 = new FincaDecorator(new Inmueble.Builder().tipo("Finca").habitaciones(10).ciudad("Medellin").cantidadPisos(2).precio(900000000).build());
        Iinmueble Local1 = new LocalDecorator(new Inmueble.Builder().tipo("Local").habitaciones(1).ciudad("Ibague").cantidadPisos(1).precio(100000000).build());

        listaInmuebles.add(casa1);
        listaInmuebles.add(apartamento1);
        listaInmuebles.add(Finca1);
        listaInmuebles.add(Local1);
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

    public List<Iinmueble> getListaInmuebles() {
        return listaInmuebles;
    }
}
