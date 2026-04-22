package com.example;

/**
 * Clase conta bancaria
 */
public class ContaBancaria {

    /** O nome do titular da conta */
    private String titular;
    
    /** O saldo actual dispoñible na conta */
    private double saldo;
    
    /** Contador do número de operacións (ingresos e retiradas) realizadas */
    private int numeroOperacions;

    /**
     * Constructor por defecto.
     * Inicializa o titular como "Descoñecido", o saldo a 0.0 e as operacións a 0.
     */
    public ContaBancaria() {
        this.titular = "Descoñecido";
        this.saldo = 0.0;
        this.numeroOperacions = 0;
    }

    /**
     * Constructor con parámetros.
     * * @param titular Nome da persoa propietaria da conta.
     * @param saldoInicial Cantidade de cartos inicial para abrir a conta.
     */
    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
        this.numeroOperacions = 0;
    }

    /**
     * Obtén o nome do titular.
     * @return O nome do titular.
     */
    public String getTitular() {
        return titular;
    }

    /**
     * Modifica o nome do titular.
     * @param titular O novo nome para o titular.
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }

    /**
     * Obtén o saldo actual.
     * @return O valor do saldo en conta.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Obtén o número total de operacións efectuadas.
     * @return O contador de operacións.
     */
    public int getNumeroOperacions() {
        return numeroOperacions;
    }

    /**
     * Realiza un ingreso de diñeiro na conta.
     * O ingreso só se fai se a cantidade é positiva. Aumenta o contador de operacións.
     * * @param cantidade A cantidade a ingresar.
     */
    public void ingresar(double cantidade) {
        if (cantidade > 0) {
            saldo += cantidade;
            numeroOperacions++;
        }
    }

    /**
     * Retira diñeiro da conta se hai saldo suficiente.
     * Aumenta o contador de operacións se a retirada ten éxito.
     * * @param cantidade A cantidade que se quere sacar.
     * @return {@code true} se a operación foi exitosa, {@code false} se non hai saldo ou a cantidade é negativa.
     */
    public boolean retirar(double cantidade) {
        if (cantidade > 0 && saldo >= cantidade) {
            saldo -= cantidade;
            numeroOperacions++;
            return true;
        }
        return false;
    }

    /**
     * Calcula a comisión correspondente baseándose no número de operacións:
     * <ul>
     * <li>Menos de 5 operacións: 0%</li>
     * <li>Entre 5 e 10 operacións: 1% do saldo</li>
     * <li>Máis de 10 operacións: 2% do saldo</li>
     * </ul>
     * * @return O valor monetario da comisión calculada.
     */
    public double calcularComision() {
        if (numeroOperacions < 5) {
            return 0;
        } else if (numeroOperacions <= 10) {
            return saldo * 0.01;
        } else {
            return saldo * 0.02;
        }
    }

    /**
     * Aplica a comisión ao saldo actual da conta.
     * Resta directamente do saldo o valor obtido en {@link #calcularComision()}.
     */
    public void aplicarComision() {
        double comision = calcularComision();
        saldo -= comision;
    }
}