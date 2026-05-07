package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceTest {

    private LibraryService libraryService;
    private Book book;
    private User user;

    @BeforeEach
    void setUp() {
        libraryService = new LibraryService();
    }

    @Test
    void testFullLibrary() {
        book = new Book("123", "El Quijote");
        user = new User("USER01", "Ana García");
        libraryService.addBook(book);
        libraryService.addUser(user);

        Loan loan = libraryService.borrowBook("123", "USER01");

        assertNotNull(loan);
        assertEquals(1, user.getLoans().size());
        assertFalse(book.isAvailable());
        assertTrue(loan.isActive());

        // 3. Devolver
        libraryService.returnBook(loan);

        assertFalse(loan.isActive());
        assertEquals(0, user.getLoans().size());
        assertTrue(book.isAvailable());
    }

    @Test
    void testAddDuplicateBook() {
        book = new Book("123", "El Quijote");
        user = new User("USER01", "Ana García");
        libraryService.addBook(book);
        Book duplicateBook = new Book("123", "Otro Título");

        assertThrows(IllegalArgumentException.class, () -> {
            libraryService.addBook(duplicateBook);
        });
    }

    @Test
    void testBorrowNonExistentBook() {
        book = new Book("123", "El Quijote");
        user = new User("USER01", "Ana García");
        libraryService.addUser(user);
        book = new Book("1238", "El Qui");
        libraryService.addBook(book);

        assertThrows(IllegalArgumentException.class, () -> {
            libraryService.borrowBook("999", "USER01");

        });

        assertThrows(IllegalArgumentException.class, () -> {
            libraryService.borrowBook("1238", "USER");
        });
    }

    @Test
    void testReturnLoanTwice() {
        book = new Book("123", "El Quijote");
        user = new User("USER01", "Ana García");
        libraryService.addBook(book);
        libraryService.addUser(user);
        Loan loan = libraryService.borrowBook("123", "USER01");

        libraryService.returnBook(loan);
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            libraryService.returnBook(loan);
        });
        assertEquals("Loan already closed", exception.getMessage());
    }

    @Test
    void testUserLoanLimitInService() {
        user = new User("USER01", "Ana García");
        libraryService.addUser(user);
        book = new Book("1238", "El Qui");
        libraryService.addBook(book);
        book = new Book("1235", "El jo");
        libraryService.addBook(book);
        book = new Book("1236", "El te");
        libraryService.addBook(book);
        book = new Book("1237", "El jote");
        libraryService.addBook(book);


        libraryService.borrowBook("1235", "USER01");
        libraryService.borrowBook("1236", "USER01");
        libraryService.borrowBook("1237", "USER01");

        assertThrows(IllegalArgumentException.class, () -> {
            libraryService.borrowBook("8", "USER01");
        });
    }
}