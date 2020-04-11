package ru.netology.domain.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.domain.Product;
import ru.netology.domain.reposirory.Repository;

@AllArgsConstructor
@Data
public class ProductManager {
    private Repository repo;

    public void addProduct(Product item) {
        repo.save(item);
    }

    public Product[] searchBy(String text) {
        Product[] newList = new Product[0];
        for (Product item : repo.getAll()) {
            if (item.matches(text)) {
                Product[] tmp = new Product[newList.length + 1];
                System.arraycopy(newList, 0, tmp, 0, newList.length);
                tmp[tmp.length - 1] = item;
                newList = tmp;
            }
        }
        return newList;
    }
}
