package com.example.parcial2inmuebles.model;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

//Patrón Facade

public class DataBaseFacade {

    private final DataBase db;

    public DataBaseFacade() {
        db = DataBase.getInstance();
    }

    public Iinmueble crearInmueble(String tipo, int habitaciones, String ciudad, int cantidadPisos, double precios) {
        Inmueble inmueble =new Inmueble
                .Builder()
                .tipo(tipo)
                .habitaciones(habitaciones)
                .ciudad(ciudad)
                .cantidadPisos(cantidadPisos)
                .precio(precios)
                .build();

        return inmueble;
    }


    public List<Iinmueble> getListainmuebles() {
        return db.getListaInmuebles();
    }

    public void eliminarInmueble(Inmueble inmueble) {
        db.eliminarInmueble(inmueble);
    }

    public DataBase getDb() {
        return db;
    }



}
