package ru.gb.dao;

import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Product;

import java.util.Collection;

public interface ProductDao {
    Iterable<Product> findAll();

    @Transactional
    Product findById(Long id);

    Product save(Product product);

    void deleteAll(Collection<Product> products);
}
