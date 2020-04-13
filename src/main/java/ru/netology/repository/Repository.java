package ru.netology.repository;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class Repository {
    Product[] repo = {new Book(1, "Book 1", 200, "Author 1"),
            new Book(2, "Book 2", 100, "Author 2"),
            new Book(3, "Book 3", 100, "Author 3"),
            new Smartphone(1, "S20", 300, "Samsung"),
            new Smartphone(2, "P40", 300, "Huawei"),
            new Smartphone(3, "iPhone 11", 50, "Apple")};

    public void save(Product item) {
        Product[] newRepo = new Product[repo.length + 1];
        System.arraycopy(repo, 0, newRepo, 0, repo.length);
        int lastIndex = newRepo.length - 1;
        newRepo[lastIndex] = item;
        repo = newRepo;
    }

    public Product[] getAll() {
        return repo;
    }

    public void removeById(int id) {
        boolean ifExists = false;
        for (Product item : repo) {
            if (item.getId() == id) {
                ifExists = true;
                break;
            }
        }
        if (ifExists) {
            Product[] newRepo = new Product[repo.length - 1];
            int index = 0;
            for (Product item : repo) {
                if (item.getId() != id) {
                    newRepo[index] = item;
                    index++;
                }
            }
            repo = newRepo;
        }
    }
}
