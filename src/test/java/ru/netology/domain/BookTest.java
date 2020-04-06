package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BookTest {

    @Test
    void shouldMatchesByAuthor() {
        Book book = new Book(3, "Book 3", 100, "Author 3");
        assertTrue(book.matches("Author 3"));
    }

    @Test
    void shouldMatchesByName() {
        Book book = new Book(3, "Book 3", 100, "Author 3");
        assertTrue(book.matches("Book 3"));
    }
}
