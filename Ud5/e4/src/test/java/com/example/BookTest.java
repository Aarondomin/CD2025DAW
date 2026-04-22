package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookExtraTest {

    private Book book;

    @BeforeEach
    void setUp() {
        // Inicializamos con datos de ejemplo
        book = new Book("978-84-206", "Cien años de soledad");
    }

    @Test
    void testGetTitle() {
        String expectedTitle = "Cien años de soledad";
        assertEquals(expectedTitle, book.getTitle(), "El título devuelto no coincide con el esperado");
    }

    @Test
    void testGetIsbn() {
        assertEquals("978-84-206", book.getIsbn());
    }

    @Test
    void testBorrow() {
        // Verificamos estado inicial
        assertTrue(book.isAvailable(), "El libro debería estar disponible antes de prestarlo");
        
        book.borrow();
        
        assertFalse(book.isAvailable(), "El libro NO debería estar disponible después de borrow()");
    }

    @Test
    void testGiveBack() {
        // Forzamos un estado previo de préstamo
        book.borrow(); 
        assertFalse(book.isAvailable());
        
        // Ejecutamos la devolución
        book.giveBack();
        
        assertTrue(book.isAvailable(), "El libro debería volver a estar disponible tras giveBack()");
    }
    
    @Test
    void testBorrowException() {
        book.borrow(); // Lo prestamos una vez
        
        // Intentar prestarlo de nuevo debe lanzar IllegalStateException
        assertThrows(IllegalStateException.class, () -> {
            book.borrow();
        }, "Debería haber lanzado una excepción por libro no disponible");
    }
}