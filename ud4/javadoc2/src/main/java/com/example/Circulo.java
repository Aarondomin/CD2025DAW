package com.example;

/**
 * Clase principal circulo  para definir el circulo 
 * contiene métodos para calcular el área, el diametro y la circunferencia
 */
public class Circulo {
    private int x;
    private int y;
    private double radio;


    /**
     * 
     * @param valorX Valo X
     * @param valorY Valor Y
     * @param valorRadio Valor Radio
     */
    public Circulo(int valorX, int valorY, double valorRadio) {
        establecerX(valorX);
        establecerY(valorY);
        establecerRadio(valorRadio);
    }

    /**
     * Método establece el valor de X
     * @param valorX Establece el valor de X
     */

    public void establecerX(int valorX) {
        x=valorX;
    }

    /**
     * Método devuelve el valor de X
     * @return Devuelve el valor de X
     */

    public int obtenerX() {
        return x;
    }

    /**
     * Método establece el valor de Y
     * @param valorY Establece el valor de Y
     */

    public void establecerY(int valorY) {
        y=valorY;
    }

    /**
     * Método devuelve Y
     * @return Devuelve el valor de Y
     */

    public int obtenerY() {
        return y;
    }

    /** 
    * Método establece el valor de radio
    * Si el valor proporcionado es negativo, se asigna 0.0 por defecto para evitar radios inválidos.
    * * @param valorRadio Establece el valor de Radio
    */
    public void establecerRadio(double valorRadio) {

        radio=(valorRadio < 0.0 ? 0.0 : valorRadio);
    }

    /**
     * Método devuelve el valor de Radio
     * @return Devuelve el valor de Radio
     */

    public double obtenerRadio() {
        return radio;
    }

    /**
     * Metodo calcula el diametro del circulo
     * @return Devuelve el diametro del circulo
     */

    public double obtenerDiametro() {
        return radio * 2;
    }

    /**
     * Método calcula la Circunferencia del circulo
     * @return Devuelve la Circunferencia del circulo
     */

    public double obtenerCircunferencia() {
        return Math.PI * obtenerDiametro();
    }

    /**
     * Método calcula el área del circulo
     * @return Devulve el área del circulo
     */

    public double obtenerArea() {
        return Math.PI * radio * radio;
    }

    /**
    * Representación en forma de String de un circulo
    * @return Una cadena de caracteres con los datos del objeto.
    */
    
    @Override
    public String toString() {
        return "Centro = [" + x + "," + y + "]; Radio = " + radio;
    }
}
