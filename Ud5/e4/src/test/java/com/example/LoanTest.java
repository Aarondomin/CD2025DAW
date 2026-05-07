package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class LoanTest {

    private Book book;
    private User user;
    private Loan loan;

    @Test
    void testInitialState() {
        book = new Book("El Quijote", "Cervantes");
        user = new User("Juan Pérez", "ID123");
        loan = new Loan(book, user);
        assertAll("Estado inicial",
                () -> assertEquals(book, loan.getBook(), "El libro no coincide"),
                () -> assertEquals(user, loan.getUser(), "El usuario no coincide"),
                () -> assertEquals(LocalDate.now(), loan.getStartDate(), "La fecha de inicio debe ser hoy"),
                () -> assertTrue(loan.isActive(), "El préstamo debería estar activo al crearse"));
    }

    @Test
    void testCloseLoan() {
        book = new Book("El Quijote", "Cervantes");
        user = new User("Juan Pérez", "ID123");
        loan = new Loan(book, user);
        loan.closeLoan();

        assertFalse(loan.isActive(), "El préstamo NO debería estar activo tras llamar a closeLoan()");
    }

    @Test
    void testDataIntegrityAfterClosing() {
        book = new Book("El Quijote", "Cervantes");
        user = new User("Juan Pérez", "ID123");
        loan = new Loan(book, user);
        loan.closeLoan();

        assertAll("Consistencia de datos",
                () -> assertEquals(book, loan.getBook()),
                () -> assertEquals(user, loan.getUser()),
                () -> assertEquals(LocalDate.now(), loan.getStartDate()));
    }
}