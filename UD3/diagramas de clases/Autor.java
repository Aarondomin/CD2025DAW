package com.example;

public class Autor {
    public String nome;
    public String nacionalidade;
    public int fechaNacimiento;
    public ArrayList<Libro> Libro;

    public Autor(String nome, String nacionalidade, int fechaNacimiento) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.fechaNacimiento = fechaNacimiento;
        this.Libro = new ArrayList<Libro>();
    }
}
