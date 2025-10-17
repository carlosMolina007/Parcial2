package com.example.parcial2inmuebles.model;

public abstract class InmuebleDecorator implements Iinmueble {
    protected  Iinmueble inmueble;

    public  InmuebleDecorator(Iinmueble inmueble) { this.inmueble = inmueble; }

    protected InmuebleDecorator() {
    }

    @Override
    public double getimpuestoInmueble() {
        return inmueble.getimpuestoInmueble();
    }

    @Override
    public  String getTipo(){
        return inmueble.getTipo();
    }

    @Override
    public int getHabitaciones(){
        return inmueble.getHabitaciones();
    }
    @Override
    public String getCiudad(){
        return  inmueble.getCiudad();
    }

    @Override
    public int getCantidadPisos(){
        return inmueble.getCantidadPisos();
    }

    @Override
    public double getPrecio(){
        return  inmueble.getPrecio();
    }



}
