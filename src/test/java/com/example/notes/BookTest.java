package com.example.notes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {
    @Test
    public void testBook() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Title");
        book.setAuthor("Author");

        assertEquals(1L, book.getId());
        assertEquals("Title", book.getTitle());
        assertEquals("Author", book.getAuthor());

        Book book2 = new Book("Title2", "Author2");

        assertEquals("Title2", book2.getTitle());
        assertEquals("Author2", book2.getAuthor());
    }
}
