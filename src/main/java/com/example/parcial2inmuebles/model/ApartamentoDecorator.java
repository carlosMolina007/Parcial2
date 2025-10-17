package com.example.parcial2inmuebles.model;

public class ApartamentoDecorator extends InmuebleDecorator{
    protected Iinmueble inmuebleDecorado;

    public ApartamentoDecorator(Iinmueble inmueble) {
        super(inmueble);
    }
    @Override
    public double getimpuestoInmueble(){
        double impuesto = getPrecio() * 0.15;
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

