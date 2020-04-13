package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.reposirory.Repository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {

    @Test
    void shouldSearchByAuthor() {
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Book(2, "Book 2", 100, "Author 2")};
        Product[] actual = manager.searchBy("Author 2");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByName() {
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Book(3, "Book 3", 100, "Author 3")};
        Product[] actual = manager.searchBy("Book 3");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByProducer() {
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Smartphone(1, "S20", 300, "Samsung")};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByPhoneName() {
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Smartphone(1, "S20", 300, "Samsung")};
        Product[] actual = manager.searchBy("S20");
        assertArrayEquals(expected, actual);
    }
}
