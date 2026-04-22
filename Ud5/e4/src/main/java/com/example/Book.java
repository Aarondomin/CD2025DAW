package com.example;

/**
 * Calse book
 */
public class Book {

    /** O ISBN do libro. */
    private String isbn;
    
    /** O título do libro. */
    private String title;
    
    /** Indica se o libro está dispoñible */
    private boolean available;

    /**
     * Constrúe un novo obxecto Book.
     * Por defecto créanse como dispoñibles.
     *
     * @param isbn O código ISBN do libro.
     * @param title O título do libro.
     */
    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
        this.available = true;
    }

    /**
     * Obtén o ISBN do libro.
     * @return Un String co ISBN.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Obtén o título do libro.
     * @return O título do libro.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Indica se o libro está actualmente dispoñible na biblioteca.
     * @return true se está dispoñible,  false se non esta dispoñible.
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Realiza o préstamo do libro. 
     * Cambia o estado de dispoñible a falso.
     *
     * @throws IllegalStateException Se o libro xa está prestado (non dispoñible).
     */
    public void borrow() {
        if (!available) {
            throw new IllegalStateException("Book not available");
        }
        available = false;
    }

    /**
     * Devolve o libro á biblioteca.
     * Cambia o estado de dispoñible a verdadeiro.
     */
    public void giveBack() {
        available = true;
    }
}