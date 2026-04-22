package com.example;

/**
 * Clase Xestor Notas
 */
public class XestorNotas {

    /** Nombre del alumno */
    private String alumno;
    
    /** Array que almacena las notas numéricas del alumno */
    private double[] notas;

    /**
     * Constructor por defecto.
     * Inicializa el alumno como "Anonimo" y el array de notas vacío.
     */
    public XestorNotas() {
        this.alumno = "Anonimo";
        this.notas = new double[0];
    }

    /**
     * Constructor con parámetros.
     * * @param alumno Nombre del estudiante.
     * @param notas Array de tipo double con las calificaciones iniciales.
     */
    public XestorNotas(String alumno, double[] notas) {
        this.alumno = alumno;
        this.notas = notas;
    }

    /**
     * Obtiene el nombre del alumno.
     * @return El nombre actual del alumno.
     */
    public String getAlumno() {
        return alumno;
    }

    /**
     * Establece el nombre del alumno.
     * @param alumno Nuevo nombre para el estudiante.
     */
    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    /**
     * Obtiene el array de notas.
     * @return Array de doubles con las calificaciones.
     */
    public double[] getNotas() {
        return notas;
    }

    /**
     * Asigna un nuevo conjunto de notas.
     * @param notas Array de doubles que sustituirá al actual.
     */
    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    /**
     * Calcula la media aritmética de las notas almacenadas.
     * * @return La media de las notas. Si no hay notas, devuelve 0.
     */
    public double calcularMedia() {
        if (notas.length == 0) {
            return 0;
        }

        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }

        return suma / notas.length;
    }

    /**
     * Busca la nota más alta dentro del array de calificaciones.
     * * @return La nota máxima encontrada. Si el array está vacío, devuelve 0.
     */
    public double calcularMaximo() {
        if (notas.length == 0) {
            return 0;
        }

        double max = notas[0];
        for (double nota : notas) {
            if (nota > max) {
                max = nota;
            }
        }

        return max;
    }

    /**
     * Determina si el alumno está aprobado basándose en la media.
     * Se considera aprobado si la media es igual o superior a 5.
     * * @return {@code true} si la media es >= 5, {@code false} en caso contrario.
     */
    public boolean estaAprobado() {
        return calcularMedia() >= 5;
    }

    /**
     * Cuenta cuántas notas son inferiores a 5 (suspensos).
     * * @return El número total de calificaciones suspensas.
     */
    public int contarSuspensos() {
        int contador = 0;
        for (double nota : notas) {
            if (nota < 5) {
                contador++;
            }
        }
        return contador;
    }
}