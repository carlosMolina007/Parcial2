package com.example.parcial2inmuebles.model;

public abstract class InmuebleDecorator implements Iinmueble {

    protected Iinmueble inmuebleDecorado;

    public  InmuebleDecorator(Iinmueble inmueble) { this.inmuebleDecorado = inmueble; }

    @Override
    public double getImpuesto() {
        return inmuebleDecorado.getImpuesto();
    }

    @Override
    public  String getTipo(){
        return inmuebleDecorado.getTipo();
    }

    @Override
    public int getHabitaciones(){
        return inmuebleDecorado.getHabitaciones();
    }
    @Override
    public String getCiudad(){
        return  inmuebleDecorado.getCiudad();
    }

    @Override
    public int getCantidadPisos(){
        return inmuebleDecorado.getCantidadPisos();
    }

    @Override
    public double getPrecio(){
        return  inmuebleDecorado.getPrecio();
    }

}
