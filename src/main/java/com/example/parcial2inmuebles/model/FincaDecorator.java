package com.example.parcial2inmuebles.model;

public class FincaDecorator extends InmuebleDecorator {


    public FincaDecorator(Iinmueble inmueble) {
        super(inmueble);
    }

    @Override
    public double getImpuesto(){
        double impuesto = getPrecio() * 0.3;
        return impuesto;
    }

    @Override
    public String getTipo(){
        return inmuebleDecorado.getTipo();
    }

    @Override
    public double getPrecio(){
        return inmuebleDecorado.getPrecio();
    }

    @Override
    public String getCiudad(){
        return inmuebleDecorado.getCiudad();
    }

    @Override
    public int getHabitaciones(){
        return inmuebleDecorado.getHabitaciones();
    }

    @Override
    public int getCantidadPisos(){
        return inmuebleDecorado.getCantidadPisos();
    }

}
