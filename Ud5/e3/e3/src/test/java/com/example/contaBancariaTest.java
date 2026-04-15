package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        conta.retirar(50);
        assertEquals(50, conta.getSaldo());
        assertEquals(1, conta.getNumeroOperacions());
        assertEquals("Pepito", conta.getTitular());

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
    void testAplicarComision() {
        ContaBancaria conta = new ContaBancaria("Pepito", 100);

        conta.aplicarComision();
        assertEquals(100, conta.getSaldo());
        assertEquals(0, conta.getNumeroOperacions());
        assertEquals("Pepito", conta.getTitular());

    }

}
