package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookExtraTest {

    private Book book;

    

    @Test
    void testGetTitle() {
        book = new Book("12345", "Cien años de soledad");
        String expectedTitle = "Cien años de soledad";
        assertEquals(expectedTitle, book.getTitle(), "El título devuelto no coincide con el esperado");
    }

    @Test
    void testGetIsbn() {
        book = new Book("12345", "Cien años de soledad");
        assertEquals("12345", book.getIsbn());
    }

    @Test
    void testBorrow() {
        book = new Book("12345", "Cien años de soledad");
        assertTrue(book.isAvailable(), "El libro debería estar disponible antes de prestarlo");
        
        book.borrow();
        
        assertFalse(book.isAvailable(), "El libro NO debería estar disponible después de borrow()");
    }

    @Test
    void testGiveBack() {
        book = new Book("12345", "Cien años de soledad");
        book.borrow(); 
        assertFalse(book.isAvailable());
        
        book.giveBack();
        
        assertTrue(book.isAvailable(), "El libro debería volver a estar disponible tras giveBack()");
    }
    
    @Test
    void testBorrowException() {
        book = new Book("12345", "Cien años de soledad");
        book.borrow(); 
        
        assertThrows(IllegalStateException.class, () -> {
            book.borrow();
        }, "Debería haber lanzado una excepción por libro no disponible");
    }
}