package com.example;

import java.time.LocalDate;

/**
 * Clase Loan
 */
public class Loan {

    /** El libro que ha sido prestado. */
    private Book book;

    /** El usuario que realiza el préstamo. */
    private User user;

    /** La fecha en la que se inició el préstamo. */
    private LocalDate startDate;

    /** La fecha en la que se devolvió el libro (null si aún está activo). */
    private LocalDate endDate;

    /**
     * Crea una nueva instancia de un préstamo.
     * La fecha de inicio se establece automáticamente a la fecha actual.
     *
     * @param book El objeto Book que se va a prestar.
     * @param user El objeto User que solicita el libro.
     */
    public Loan(Book book, User user) {
        this.book = book;
        this.user = user;
        this.startDate = LocalDate.now();
    }

    /**
     * Obtiene el libro asociado a este préstamo.
     * @return El libro prestado.
     */
    public Book getBook() {
        return book;
    }

    /**
     * Obtiene el usuario que tiene el libro.
     * @return El usuario del préstamo.
     */
    public User getUser() {
        return user;
    }

    /**
     * Obtiene la fecha en la que se realizó el préstamo.
     * @return Objeto LocalDate con la fecha de inicio.
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Registra la devolución del libro estableciendo la fecha de finalización
     * a la fecha actual del sistema.
     */
    public void closeLoan() {
        this.endDate = LocalDate.now();
    }

    /**
     * Verifica si el préstamo sigue vigente.
     * Un préstamo se considera activo si no tiene una fecha de finalización registrada.
     *
     * @return  true si el libro aún no ha sido devuelto false en caso contrario.
     */
    public boolean isActive() {
        return endDate == null;
    }
}