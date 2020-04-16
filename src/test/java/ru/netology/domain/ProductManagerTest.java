package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private Book book1 = new Book(1, "Book 1", 200, "Author 1");
    private Book book2 = new Book(2, "Book 2", 100, "Author 2");
    private Book book3 = new Book(3, "Book 3", 200, "Author 3");
    private Smartphone smartphone1 = new Smartphone(1, "S20", 300, "Samsung");
    private Smartphone smartphone2 = new Smartphone(2, "P40", 300, "Huawei");
    private Smartphone smartphone3 = new Smartphone(3, "iPhone 11", 50, "Apple");
    private Repository repository;
    private ProductManager manager;

    @BeforeEach
    void setUp() {
        repository = new Repository();
        manager = new ProductManager(repository);
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);
        manager.addProduct(smartphone3);
    }

    @Test
    void shouldSearchByAuthor() {
        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Author 2");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByName() {
        Product[] expected = {book3};
        Product[] actual = manager.searchBy("Book 3");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByProducer() {
        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByPhoneName() {
        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("S20");
        assertArrayEquals(expected, actual);
    }
}
