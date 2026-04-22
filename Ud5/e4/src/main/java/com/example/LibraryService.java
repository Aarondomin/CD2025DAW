package com.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase LibraryService
 */
public class LibraryService {

    /** Mapa de libros indexados por su ISBN. */
    private Map<String, Book> books = new HashMap<>();
    
    /** Mapa de usuarios indexados por su ID único. */
    private Map<String, User> users = new HashMap<>();

    /**
     * Registra un nuevo libro en el sistema de la biblioteca.
     *
     * @param book El objeto Book que se desea añadir.
     * @throws IllegalArgumentException si el libro ya existe en el sistema (basado en el ISBN).
     */
    public void addBook(Book book) {
        if (books.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException("Book already exists");
        }
        books.put(book.getIsbn(), book);
    }

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param user El objeto User que se desea dar de alta.
     * @throws IllegalArgumentException si el ID del usuario ya se encuentra registrado.
     */
    public void addUser(User user) {
        if (users.containsKey(user.getId())) {
            throw new IllegalArgumentException("User already exists");
        }
        users.put(user.getId(), user);
    }

    /**
     * Realiza el préstamo de un libro a un usuario específico.
     *
     * @param isbn   El código ISBN del libro que se solicita.
     * @param userId El identificador único del usuario que solicita el préstamo.
     * @return Un objeto Loan que representa la transacción del préstamo.
     * @throws IllegalArgumentException si el libro o el usuario no existen en los registros.
     */
    public Loan borrowBook(String isbn, String userId) {
        Book book = books.get(isbn);
        User user = users.get(userId);

        if (book == null || user == null) {
            throw new IllegalArgumentException("Invalid data");
        }

        book.borrow();

        Loan loan = new Loan(book, user);
        user.addLoan(loan);

        return loan;
    }

    /**
     * Procesa la devolución de un libro y cierra el préstamo activo.
     *
     * @param loan El objeto  Loan que se desea finalizar.
     * @throws IllegalStateException si el préstamo ya se encuentra cerrado o inactivo.
     */
    public void returnBook(Loan loan) {
        if (!loan.isActive()) {
            throw new IllegalStateException("Loan already closed");
        }

        loan.closeLoan();
        loan.getBook().giveBack();
        loan.getUser().removeLoan(loan);
    }
}