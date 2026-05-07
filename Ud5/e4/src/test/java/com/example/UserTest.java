package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class UserTest {

    private User user1;
    private Loan loan1;
    private Loan loan2;
    private Loan loan3;
    private Loan loan4;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;



    @Test
    void testUserCreation() {
         user1 = new User("12345", "Juan Pérez");
    
        assertEquals("12345", user1.getId());
        assertEquals("Juan Pérez", user1.getName());
        assertTrue(user1.getLoans().isEmpty(), "La lista de préstamos debería iniciar vacía");
    }

    @Test
    void testAddLoanSuccess() {
         user1 = new User("12345", "Juan Pérez");
        
        user1.addLoan(loan1);

        List<Loan> loans = user1.getLoans();
        assertEquals(1, loans.size());
        assertTrue(loans.contains(loan1));

    }

    @Test
    void testAddLoanLimitExceeded() {
         user1 = new User("12345", "Juan Pérez");
        book1 = new Book("A1234", "Cien años de soledad");
        book2 = new Book("B1234", "Cien años de perdon");
        book3 = new Book("C1234", "Cien años de intensidad");
        book3 = new Book("D1234", "Cien años de relax");

        loan1 = new Loan(book1, user1);
        loan2 = new Loan(book2, user1);
        loan3 = new Loan(book3, user1);
        loan4 = new Loan(book4, user1);

        user1.addLoan(loan1);
        user1.addLoan(loan2);
        user1.addLoan(loan3);

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            user1.addLoan(loan4);
        });
    }

   @Test
    void testRemoveExistentLoan() {
         user1 = new User("12345", "Juan Pérez");

        user1.addLoan(loan1);
        user1.removeLoan(loan1);
        
        assertTrue(user1.getLoans().isEmpty());
    }

    @Test
    void testRemoveLoanEmptyList() {
         user1 = new User("12345", "Juan Pérez");
        user1.addLoan(loan1);
        assertDoesNotThrow(() -> user1.removeLoan(loan1));
    }

    @Test
    void testGetLoans() {
         user1 = new User("12345", "Juan Pérez");

        user1.addLoan(loan1);
        List<Loan> currentLoans = user1.getLoans();
        
        assertNotNull(currentLoans);
        assertEquals(1, currentLoans.size());
        assertEquals(loan1, currentLoans.get(0));
    }
}