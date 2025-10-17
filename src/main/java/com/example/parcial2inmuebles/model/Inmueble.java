package com.example.parcial2inmuebles.model;

public class Inmueble implements Iinmueble {
    private String tipo;
    private int habitaciones;
    private String ciudad ;;
    private int cantidadPisos;
    private double precio;

//Patron de diseño Builder

    private Inmueble (Builder builder){
        this.tipo = builder.tipo;
        this.habitaciones = builder.habitaciones;
        this.ciudad = builder.ciudad;
        this.cantidadPisos = builder.cantidadPisos;
        this.precio = builder.precio;
    }


    public String getTipo() {
        return tipo;
    }
    public int getHabitaciones() {
        return habitaciones;
    }
    public String getCiudad() {
        return ciudad;
    }
    public int getCantidadPisos() {
        return cantidadPisos;
    }
    public double getPrecio() {
        return precio;
    }

    public static  class Builder{
        private String tipo;
        private int habitaciones;
        private String ciudad;
        private int cantidadPisos;
        private double precio;

        public Builder tipo(String tipo){
            this.tipo = tipo;
            return this;
        }
        public Builder habitaciones(int habitaciones){
            this.habitaciones = habitaciones;
            return this;
        }
        public Builder ciudad(String ciudad){
            this.ciudad = ciudad;
            return this;
        }
        public Builder cantidadPisos(int cantidadPisos){
            this.cantidadPisos = cantidadPisos;
            return this;
        }
        public Builder precio(double precio){
            this.precio = precio;
            return this;
        }
        public Inmueble build(){ return new Inmueble(this);}
    }

    @Override
    public double getImpuesto(){
        return precio * 0.08;
    }


}