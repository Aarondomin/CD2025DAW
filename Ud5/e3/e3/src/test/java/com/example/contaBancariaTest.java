package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
class contaBancariaTest {

    @Test
    void testContructorPorDefecto() {
        ContaBancaria conta = new ContaBancaria();

        assertEquals(0, conta.getSaldo());
        assertEquals(0, conta.getNumeroOperacions());
        assertEquals("Descoñecido", conta.getTitular());
    }

    @Test
    void testContructor() {
        ContaBancaria conta = new ContaBancaria("Pepito", 100);

        assertEquals(100, conta.getSaldo());
        assertEquals(0, conta.getNumeroOperacions());
        assertEquals("Pepito", conta.getTitular());
    }

    @Test
    void testIngresar() {
        ContaBancaria conta = new ContaBancaria("Pepito", 100);

        conta.ingresar(50);
        assertEquals(150, conta.getSaldo());
        assertEquals(1, conta.getNumeroOperacions());
        assertEquals("Pepito", conta.getTitular());

    }

    @Test
    void testRetirar() {
        ContaBancaria conta = new ContaBancaria("Pepito", 100);

        boolean resultado = conta.retirar(50);
        assertTrue(resultado);
        assertEquals(50, conta.getSaldo());
        assertEquals(1, conta.getNumeroOperacions());

        resultado = conta.retirar(-10);
        assertFalse(resultado);
        assertEquals(50, conta.getSaldo());
        assertEquals(1, conta.getNumeroOperacions());


        resultado = conta.retirar(200);
        assertFalse(resultado);
        assertEquals(50, conta.getSaldo());
        assertEquals(1, conta.getNumeroOperacions());



    }

    @Test
    void testCalculaComision() {
        ContaBancaria conta = new ContaBancaria("Pepito", 100);

        conta.calcularComision();
        assertEquals(100, conta.getSaldo());
        assertEquals(0, conta.getNumeroOperacions());
        assertEquals("Pepito", conta.getTitular());



    }

    @Test
    void testAplicarComisionMenosDiez() {
        ContaBancaria conta = new ContaBancaria("Pepito", 100);

        conta.ingresar(1);
        conta.ingresar(1);
        conta.ingresar(1);
        conta.ingresar(1);
        conta.ingresar(1);
        conta.ingresar(1);
        conta.ingresar(1);
        conta.ingresar(1);
        assertEquals(conta.getNumeroOperacions(), 8);
        assertEquals(108 * 0.01, conta.calcularComision());


    }

    @Test
    void testAplicarComisionMasDiez() {
        ContaBancaria conta = new ContaBancaria("Pepito", 100);

        
        conta.ingresar(1);
        conta.ingresar(1);
        conta.ingresar(1);
        conta.ingresar(1);
        conta.ingresar(1);
        conta.ingresar(1);
        conta.ingresar(1);
        conta.ingresar(1);
        conta.ingresar(1);
        conta.ingresar(1);
        conta.ingresar(1);
        assertEquals(conta.getNumeroOperacions(), 11);
        assertEquals(111 * 0.02, conta.calcularComision());


    }

}
