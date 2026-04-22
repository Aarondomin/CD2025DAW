package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class XestorNotasTest {

    private XestorNotas xestor;

    @BeforeEach
    void setUp() {
        // Inicializamos con unos datos estándar antes de cada test
        double[] notasIniciales = {4.0, 6.0, 8.0, 2.0}; // Media: 5.0
        xestor = new XestorNotas("Pepe", notasIniciales);
    }

    @Test
    void testCalcularMedia() {
        assertEquals(5.0, xestor.calcularMedia(), "La media debería ser 5.0");
    }

    @Test
    void testCalcularMediaVacia() {
        xestor.setNotas(new double[0]);
        assertEquals(0, xestor.calcularMedia(), "La media de un array vacío debe ser 0");
    }

    @Test
    void testCalcularMaximo() {
        assertEquals(8.0, xestor.calcularMaximo(), "El valor máximo debería ser 8.0");
    }

    @Test
    void testCalcularMaximoVacio() {
        xestor.setNotas(new double[0]);
        assertEquals(0, xestor.calcularMaximo(), "El máximo de un array vacío debe ser 0");
    }

    @Test
    void testEstaAprobado() {
        assertTrue(xestor.estaAprobado(), "Con media 5.0 debería estar aprobado");
        
        xestor.setNotas(new double[]{4.0, 4.0});
        assertFalse(xestor.estaAprobado(), "Con media 4.0 debería estar suspenso");
    }

    @Test
    void testContarSuspensos() {
        // En {4.0, 6.0, 8.0, 2.0} hay dos notas menores que 5
        assertEquals(2, xestor.contarSuspensos(), "Debería haber 2 suspensos");
    }

    @Test
    void testGettersSetters() {
        xestor.setAlumno("Ana");
        assertEquals("Ana", xestor.getAlumno());
        
        double[] nuevasNotas = {10.0, 9.5};
        xestor.setNotas(nuevasNotas);
        assertArrayEquals(nuevasNotas, xestor.getNotas());
    }
}