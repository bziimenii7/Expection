package ru.netology.javaqa.ShopRepository;

import org.junit.jupiter.api.Assertions;
import ru.netology.javaqa.Domain.Product;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void removeProductExisting() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(7, "клавиатура", 5_000);
        Product product2 = new Product(17, "монитор", 50_000);
        Product product3 = new Product(77, "наушники", 15_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(7);
        Product[] actual = repo.findAll();
        Product[] expected = {product2, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeProductNotExisting() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(7, "клавиатура", 5_000);
        Product product2 = new Product(17, "монитор", 50_000);
        Product product3 = new Product(77, "наушники", 15_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(777)
        );
    }
}
