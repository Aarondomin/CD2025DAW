package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase User
 */
public class User {

    /** Identificador único del usuario (por ejemplo, DNI o ID de socio). */
    private String id;

    /** Nombre completo del usuario. */
    private String name;

    /** Lista de préstamos asociados al usuario. */
    private List<Loan> loans;

    /**
     * Construye un nuevo usuario con un ID y nombre específicos.
     * Inicializa la lista de préstamos como una lista vacía.
     *
     * @param id El identificador único del usuario.
     * @param name El nombre del usuario.
     */
    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.loans = new ArrayList<>();
    }

    /**
     * Obtiene el nombre del usuario.
     * @return El nombre actual del usuario.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Obtiene el identificador del usuario.
     * @return El ID del usuario.
     */
    public String getId() {
        return id;
    }

    /**
     * Obtiene la lista de todos los préstamos vinculados al usuario.
     * @return Una List que contiene los objetos Loan.
     */
    public List<Loan> getLoans() {
        return loans;
    }

    /**
     * Añade un nuevo préstamo a la cuenta del usuario.
     * * @param loan El préstamo que se desea añadir.
     * @throws IllegalStateException Si el usuario ya tiene 3 préstamos (límite máximo permitido).
     */
    public void addLoan(Loan loan) {
        if (loans.size() >= 3) {
            throw new IllegalStateException("Max loans reached");
        }
        loans.add(loan);
    }

    /**
     * Elimina un préstamo específico de la lista del usuario.
     * Suele utilizarse cuando un préstamo se cancela o se procesa su devolución.
     *
     * @param loan El préstamo a eliminar.
     */
    public void removeLoan(Loan loan) {
        loans.remove(loan);
    }
}