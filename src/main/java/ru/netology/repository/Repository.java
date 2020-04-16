package ru.netology.repository;

import ru.netology.domain.Product;

public class Repository {
    private Product[] repo = new Product[0];

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
