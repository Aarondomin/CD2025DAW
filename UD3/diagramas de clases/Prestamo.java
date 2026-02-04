package com.example;

import java.util.ArrayList;

public class Prestamo {
    public int fechaInicio;
    public int fechaFin;
    public ArrayList<Multa> multas;
    public ArrayList<Lector>lectores;

    public Prestamo(int fechaInicio, int fechaFin ){
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.lectores = new ArrayList<Lector>()
    }

    public int calcularFechaFin(int fechaInicio, int fechaFin){
        return fechaFin;
    }

    public String generarMulta(){
        return multa;
    }
} 
